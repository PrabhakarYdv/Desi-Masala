package com.prabhakar.desimasala;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.concurrent.FutureTask;

public class LoginRegister_Activity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        fragmentManager = getSupportFragmentManager();
        String fragmentType = getIntent().getStringExtra("fragment");
        if (fragmentType.equals("login")){
            launchLoginFragment();
        }
         if (fragmentType.equals("register")){
            launchSignUpFragment();
        }
    }

    private void launchLoginFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.account_fragment, loginFragment, "login").commit();

    }

    private void launchSignUpFragment() {
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        SignupFragment signupFragment = new SignupFragment();
        fragmentTransaction.replace(R.id.account_fragment,signupFragment,"singup").commit();

    }
}