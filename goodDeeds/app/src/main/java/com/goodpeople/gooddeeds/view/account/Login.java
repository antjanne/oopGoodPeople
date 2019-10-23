package com.goodpeople.gooddeeds.view.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.view.MainActivity;
import com.goodpeople.gooddeeds.view.ViewTemplate;

public class Login extends ViewTemplate {


    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.login);

        super.onCreate(savedInstanceState);
    }


    public void createAccount(View view) {
        Intent myIntent = new Intent(view.getContext(), CreateAccount.class);
        startActivityForResult(myIntent, 0);
    }

    public void login(View view) {
        EditText editTextEmail = findViewById(R.id.login_email);
        String email = editTextEmail.getText().toString();

        EditText editTextName = findViewById(R.id.login_password);
        String password = editTextName.getText().toString();

        if (accountController.validateLogin(email, password)) {
            accountController.login(email, password);
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);
        } else {
            sendError(R.id.login_error_message, R.string.login_error);
        }

    }

}
