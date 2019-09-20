package com.c.a.androidchallengeapp.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.constants.ConstantApp;
import com.c.a.androidchallengeapp.databinding.FragmentLoginBinding;

import java.util.Objects;

public class FragmentLogin extends Fragment implements View.OnClickListener {
    private AppCompatActivity activity;
    private FragmentLoginBinding binding;
    private EditText etUserName, etPassword;

    public static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View view = binding.getRoot();

        hideToolbar();

        etUserName = binding.etUserName;
        etPassword = binding.etPassword;

        if (getActivity() != null) {
            activity = (AppCompatActivity) getActivity();
            binding.btnLogin.setOnClickListener(this);
        }

        return view;
    }

    private void navigateFragment(Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rlFragmentArea, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                login();
                break;
        }
    }

    private void login() {
        if (isValid())
            if (auth()) {
                navigateFragment(FragmentOrders.newInstance());
            } else {
                showDialog("Marketim", "Kullanıcı Adı veya Şifre hatalı");
            }
    }

    private boolean isValid() {
        boolean isEmpty = true;

        if (TextUtils.isEmpty(etUserName.getText())) {
            etUserName.setError("Lütfen kullanıcı adını giriniz");
            isEmpty = false;
        }

        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError("Lütfen şifreyi giriniz");
            isEmpty = false;
        }

        return isEmpty;
    }

    private boolean auth() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        return userName.equals(ConstantApp.DEFAULT_USER_NAME) && password.equals(ConstantApp.DEFAULT_PASSWORD);
    }

    private void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void hideToolbar() {
        if (getActivity() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }
}
