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


public class SignupFragment extends Fragment {
    private EditText register_userName, register_userFullName, register_emailOrPhone, register_password, register_retypePassword;
    private TextView alreadyAccount;
    private Button user_registerButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        register_userName = view.findViewById(R.id.register_user_name);
        register_userFullName = view.findViewById(R.id.register_fullName);
        register_emailOrPhone = view.findViewById(R.id.register_email_or_phone);
        register_password = view.findViewById(R.id.register_password);
        register_retypePassword = view.findViewById(R.id.register_retype_password);
        alreadyAccount = view.findViewById(R.id.already_account);
        user_registerButton = view.findViewById(R.id.user_register_button);

        user_registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity( intent);
            }
        });


        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoLoginFragment = new Intent(getContext(),LoginRegister_Activity.class);
                gotoLoginFragment.putExtra("fragment","login");
                startActivity(gotoLoginFragment);
            }
        });
    }
}