package com.goodpeople.gooddeeds.view.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.view.ViewTemplate;

/**
 * Responsible for handling a form for creating a new account.
 */

public class CreateAccount extends ViewTemplate {

    private String name;
    private String email;
    private Integer postalCode;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.create_account);
        super.onCreate(savedInstanceState);
    }

    public void submitAccount(View view) {
        getTextFromFields();

        if (validateAccountData()) {
            accountController.createAccountHandler(name, postalCode, email, password);
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
        if (!editTextPostalCode.getText().toString().trim().isEmpty()) {
            this.postalCode = Integer.parseInt(editTextPostalCode.getText().toString());
        } else {
            this.postalCode = 0;
        }
        EditText editTextPassword = findViewById(R.id.password);
        this.password = editTextPassword.getText().toString();
    }

    private boolean validateAccountData() {
        return (!name.trim().isEmpty() && isEmailValid(email) && !accountController.isEmailUsedHandler(email) &&
                isPostalCodeValid(postalCode) && !password.trim().isEmpty());
    }

    private void handleError() {
        if (name.trim().isEmpty()) {
            sendError(R.id.nameLayout, R.string.invalid_name);
        } else {
            removeError(R.id.nameLayout);
        }

        if (!isEmailValid(email) || accountController.isEmailUsedHandler(email)) {
            sendError(R.id.emailLayout, R.string.invalid_email);
        } else {
            removeError(R.id.emailLayout);
        }

        if (!isPostalCodeValid(postalCode)) {
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
