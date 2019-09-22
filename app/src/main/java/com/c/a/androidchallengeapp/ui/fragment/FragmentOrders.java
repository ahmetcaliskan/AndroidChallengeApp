package com.c.a.androidchallengeapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.constants.ConstantApp;
import com.c.a.androidchallengeapp.databinding.FragmentOrdersBinding;
import com.c.a.androidchallengeapp.model.ModelOrders;
import com.c.a.androidchallengeapp.ui.adapter.AdapterOrders;
import com.c.a.androidchallengeapp.ui.component.CustomProgressDialog;
import com.c.a.androidchallengeapp.utility.UtilSharedPreferences;
import com.c.a.androidchallengeapp.viewmodel.ViewModelOrders;

import java.util.List;
import java.util.Objects;

public class FragmentOrders extends Fragment implements View.OnClickListener {
    private AppCompatActivity activity;
    private MutableLiveData<List<ModelOrders>> mutableLiveData;
    private ViewModelOrders viewModel;
    private Observer<List<ModelOrders>> observer;
    private FragmentOrdersBinding binding;
    private RecyclerView rcvOrders;
    private AdapterOrders adapter;

    private CustomProgressDialog customProgressDialog;

    public static FragmentOrders newInstance() {
        return new FragmentOrders();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);
        View view = binding.getRoot();

        if (getActivity() != null)
            activity = (AppCompatActivity) getActivity();

        showProgressDialog();

        showToolbar();

        rcvOrders = binding.rcvOrders;

        adapter = new AdapterOrders();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL);
        rcvOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvOrders.setHasFixedSize(true);
        rcvOrders.setAdapter(adapter);
        rcvOrders.addItemDecoration(dividerItemDecoration);

        viewModel = ViewModelProviders.of(this).get(ViewModelOrders.class);
        binding.setViewModel(viewModel);

        binding.sRLOrders.setOnRefreshListener(() -> {
            if (getActivity() != null)
                getActivity().runOnUiThread(() -> {
                    showProgressDialog();
                    removeObserver();
                    startObserve(viewModel.getOrders());
                    binding.sRLOrders.setRefreshing(false);
                });
        });

        binding.btnOrders.setOnClickListener(this);
        binding.btnLogout.setOnClickListener(this);

        startObserve(viewModel.getOrders());

        return view;
    }

    private void startObserve(MutableLiveData<List<ModelOrders>> mld) {
        observer = list -> {
            customProgressDialog.hide();
            if (list != null) {
                adapter.submitList(list);
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(activity, getString(R.string.failOrdersList), Toast.LENGTH_SHORT).show();
            }
        };
        mld.observe(this, observer);
        mutableLiveData = mld;
    }

    private void removeObserver() {
        if (mutableLiveData.hasObservers())
            mutableLiveData.removeObservers(this);
    }

    private void showToolbar() {
        if (getActivity() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOrders:
                showProgressDialog();
                removeObserver();
                startObserve(viewModel.getOrders());
                break;

            case R.id.btnLogout:
                showAlertDialog(getString(R.string.appName), getString(R.string.confirmLogout));
                break;
        }
    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.logout), (dialogInterface, i) -> {
            if (getActivity() != null) {
                UtilSharedPreferences.putData(ConstantApp.SP_KEY_IS_REMEMBER_ME, false, getContext());
                getActivity().finishAffinity();
            }
        });

        builder.setNegativeButton(getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showProgressDialog() {
        int animRawId = getContext().getResources().getIdentifier("loader", "raw", getContext().getPackageName());//json anim dosyası (lottie için)
        customProgressDialog = new CustomProgressDialog(activity, animRawId,
                getString(R.string.pleaseWaiting), false, () -> customProgressDialog.hide());

        if (isAdded())
            customProgressDialog.show();
    }
}
