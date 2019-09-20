package com.c.a.androidchallengeapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.databinding.FragmentOrdersBinding;
import com.c.a.androidchallengeapp.model.ModelOrders;
import com.c.a.androidchallengeapp.viewmodel.ViewModelOrders;

import java.util.List;

public class FragmentOrders extends Fragment {
    private AppCompatActivity activity;
    private ViewModelOrders viewModel;
    private Observer<List<ModelOrders>> observer;
    private FragmentOrdersBinding binding;
    private SwipeRefreshLayout sRLOrders;
    private RecyclerView rcvOrders;

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

        showToolbar();

        sRLOrders = binding.sRLOrders;
        rcvOrders = binding.rcvOrders;

        viewModel = ViewModelProviders.of(this).get(ViewModelOrders.class);
        startObserve(viewModel.getOrders());

        return view;
    }

    private void startObserve(MutableLiveData<List<ModelOrders>> mediatorLiveData) {
        observer = new Observer<List<ModelOrders>>() {
            @Override
            public void onChanged(List<ModelOrders> list) {
                if (list != null) {

                }
            }
        };
        mediatorLiveData.observe(this, observer);
    }

    private void showToolbar() {
        if (getActivity() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}
