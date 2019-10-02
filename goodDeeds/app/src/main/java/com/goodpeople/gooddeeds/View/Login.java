package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.R;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    AccountController accountController = new AccountController();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        } else if (menuItem.getItemId() == R.id.toolbar_login) {
            finish();
            startActivity(getIntent());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
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

    private void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }

    public void goBack(View view) {
        finish();
    }


}
