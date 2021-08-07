package com.prabhakar.desimasala;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class LoginFragment extends Fragment {
    private EditText login_userName, login_userPassword;
    private TextView notAccount;
    private Button user_loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        login_userName = view.findViewById(R.id.login_userName_entry);
        login_userPassword = view.findViewById(R.id.login_password_entry);
        notAccount = view.findViewById(R.id.not_account);
        user_loginButton = view.findViewById(R.id.user_login_btn);
        user_loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLoginUsername() && validateLoginPassword()) {
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        notAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoRegisterFragment = new Intent(getContext(), LoginRegister_Activity.class);
                gotoRegisterFragment.putExtra("fragment", "register");
                startActivity(gotoRegisterFragment);
            }
        });
    }

    private boolean validateLoginUsername() {
        if (login_userName.getText().toString().isEmpty()) {
            login_userName.setError("User Name Required");
            return false;
        }
        if (login_userName.getText().toString().equals("prabhakar01")) {
            return true;
        } else {
            login_userName.setError("User name is incorrect");
            return false;
        }
    }

    private boolean validateLoginPassword() {
        if (login_userPassword.getText().toString().isEmpty()) {
            login_userPassword.setError("Password Required");
            return false;
        } else if (login_userPassword.getText().toString().equals("123456")) {
            return true;
        } else {
            login_userPassword.setError("Password is incorrect");
            return false;
        }

    }
}