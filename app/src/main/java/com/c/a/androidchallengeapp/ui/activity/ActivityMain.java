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
import com.c.a.androidchallengeapp.ui.fragment.FragmentOrders;
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
            navigateFragment(FragmentOrders.newInstance());
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

    @Override
    public void onBackPressed() {//geri tuşu ile uygulamadan çıkış yapması için. Aksi durumda uygulamada sadece boş ekran gözükür
        int count = getSupportFragmentManager().getBackStackEntryCount();
//        if (count == 1) {
        finishAffinity();
//        } else {
//            getSupportFragmentManager().popBackStack();
//        }
    }

}
