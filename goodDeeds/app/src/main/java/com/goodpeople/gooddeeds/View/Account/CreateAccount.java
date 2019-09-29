package com.goodpeople.gooddeeds.View.Account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.ViewTemplate;

public class CreateAccount extends ViewTemplate {

    String name;
    String email;
    Integer postalCode;
    String password;

    public AccountController accountController = new AccountController();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.create_account);
        super.onCreate(savedInstanceState);
    }


    public void submitAccount(View view) {
        getTextFromFields();

        if (validateAccountData()) {
            accountController.createAccount(name, postalCode, email, password);
            this.finish();

        } else {
            handleError();
        }
    }

    private void getTextFromFields() {
        EditText editTextName = findViewById(R.id.name);
        this.name = editTextName.getText().toString();

        EditText editTextEmail = findViewById(R.id.email);
        this.email = editTextEmail.getText().toString();

        EditText editTextPostalCode = findViewById(R.id.postal_code);
        if (editTextPostalCode.getText().toString().length() != 0) {
            this.postalCode = Integer.parseInt(editTextPostalCode.getText().toString());
        }
        EditText editTextPassword = findViewById(R.id.password);
        this.password = editTextPassword.getText().toString();
    }

    private boolean validateAccountData() {
        return (!name.trim().isEmpty() && validateEmail(email) && !accountController.isEmailUsedHandler(email) &&
                validatePostalCode(postalCode) && !password.trim().isEmpty());
    }

    private void handleError() {
        if (name.trim().isEmpty()) {
            sendError(R.id.nameLayout, R.string.invalid_name);
        } else {
            removeError(R.id.nameLayout);
        }

        if (!validateEmail(email) || accountController.isEmailUsedHandler(email)) {
            sendError(R.id.emailLayout, R.string.invalid_email);
        } else {
            removeError(R.id.emailLayout);
        }

        if (!validatePostalCode(postalCode)) {
            sendError(R.id.postal_codeLayout, R.string.invalid_postal_code);
        } else {
            removeError(R.id.postal_codeLayout);
        }

        if (password.trim().isEmpty()) {
            sendError(R.id.passwordLayout, R.string.invalid_password);
        } else {
            removeError(R.id.passwordLayout);
        }
    }


}
