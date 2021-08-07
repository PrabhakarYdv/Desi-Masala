package com.prabhakar.desimasala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AccountActivity extends AppCompatActivity {
    private Button buttonLogin, buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_account);
        initViews();
    }

    private void initViews() {
        buttonLogin = findViewById(R.id.login_btn);
        buttonRegister = findViewById(R.id.register_btn);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegisterFragment = new Intent(AccountActivity.this,LoginRegister_Activity.class);
                gotoRegisterFragment.putExtra("fragment","register");
                startActivity(gotoRegisterFragment);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoLoginFragment = new Intent(AccountActivity.this,LoginRegister_Activity.class);
                gotoLoginFragment.putExtra("fragment","login");
                startActivity(gotoLoginFragment);
            }
        });
    }


}