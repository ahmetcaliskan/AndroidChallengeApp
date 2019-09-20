package com.c.a.androidchallengeapp.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.constants.ConstantApp;
import com.c.a.androidchallengeapp.databinding.ActivityMainBinding;
import com.c.a.androidchallengeapp.ui.fragment.FragmentLogin;
import com.c.a.androidchallengeapp.utility.UtilSharedPreferences;

public class ActivityMain extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        boolean isRememberMe = UtilSharedPreferences.getBoolean(ConstantApp.SP_KEY_IS_REMEMBER_ME, getApplicationContext());//default false

        if (!isRememberMe) {
            navigateFragment(FragmentLogin.newInstance());
        } else {

        }

    }

    private void navigateFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rlFragmentArea, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
