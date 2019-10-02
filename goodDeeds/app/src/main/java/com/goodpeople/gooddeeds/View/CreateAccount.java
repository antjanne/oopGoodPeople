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

public class CreateAccount extends AppCompatActivity {

    AccountController accountController = new AccountController();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
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
            login();

        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void submitAccount(View view) {
        EditText editTextName = findViewById(R.id.name);
        String name = editTextName.getText().toString();

        EditText editTextEmail = findViewById(R.id.email);
        String email = editTextEmail.getText().toString();

        EditText editTextPostalCode = findViewById(R.id.postal_code);
        String postalCodeText = editTextPostalCode.getText().toString();

        EditText editTextPassword = findViewById(R.id.password);
        String password = editTextPassword.getText().toString();

        if (validateData(name, email, postalCodeText, password)) {
            int postalCode = Integer.valueOf(postalCodeText);
            accountController.createAccount(name, postalCode, email, password);

            goBack(view);
        }

    }

    private boolean validateData(String name, String email, String postalCode, String password) {
        boolean returnValue = true;

        if (name == null || name.trim().isEmpty()) {
            sendError(R.id.nameLayout, R.string.invalidName);
            returnValue = false;

        }
        if (email == null || email.trim().isEmpty() || !email.contains("@") || accountController.validateAccountEmail(email)) {
            sendError(R.id.emailLayout, R.string.invalidEmail);
            returnValue = false;

        }
        if (postalCode == null || postalCode.length() != 5) {
            sendError(R.id.postal_codeLayout, R.string.invalidPostalCode);
            returnValue = false;

        }
        if (password == null || password.isEmpty()) {
            sendError(R.id.passwordLayout, R.string.invalidPassword);
            returnValue = false;
        }
        return returnValue;
    }

    private void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }


    public void goBack(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void login() {
        if (!accountController.isLoggedIn()) {
            Intent myIntent = new Intent(this, Login.class);
            startActivityForResult(myIntent, 0);
        } else {
            Intent intent = new Intent(this, ActiveOffersActivity.class);
            startActivity(intent);
        }

    }


}
