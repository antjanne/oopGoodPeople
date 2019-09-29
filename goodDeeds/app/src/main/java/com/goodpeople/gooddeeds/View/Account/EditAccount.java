package com.goodpeople.gooddeeds.View.Account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.ViewTemplate;

public class EditAccount extends ViewTemplate {

    TextView nameView;
    TextView emailView;
    TextView postalCodeView;

    String name;
    String email;
    int postalCode;

    Account account;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.edit_account);
        super.onCreate(savedInstanceState);

        account = accountController.accountHandler();
        getTextViews();
        populateFields();
    }

    private void getTextViews() {
        this.nameView = (EditText) findViewById(R.id.account_edit_name);
        this.emailView = (EditText) findViewById(R.id.account_edit_email);
        this.postalCodeView = (EditText) findViewById(R.id.account_edit_postal_code);
    }

    public void populateFields() {
        nameView.setText(account.getName());
        emailView.setText(account.getEmail());
        postalCodeView.setText(Integer.toString(account.getPostalCode()));
    }


    public void saveUpdates(View view) {
        getFilledOutFields();

        if (validateEditedFields()) {
            account.setName(name);
            account.setEmail(email);
            account.setPostalCode(postalCode);
            finish();
        } else {
            setError();
        }
    }

    private void getFilledOutFields() {
        EditText editTextName = findViewById(R.id.account_edit_name);
        name = editTextName.getText().toString();

        EditText editTextEmail = findViewById(R.id.account_edit_email);
        email = editTextEmail.getText().toString();

        EditText editTextPostalCode = findViewById(R.id.account_edit_postal_code);
        postalCode = Integer.valueOf(editTextPostalCode.getText().toString().trim());
    }

    private boolean validateEditedFields() {
        return (name.trim().isEmpty() || validateEmail(email) ||
                validatePostalCode(postalCode));
    }

    private void setError() {
        if (name.trim().isEmpty()) {
            sendError(R.id.nameLayout, R.string.invalidName);
        } else {
            removeError(R.id.nameLayout);
        }

        if (validateEmail(email)) {
            sendError(R.id.emailLayout, R.string.invalidEmail);

        } else {
            removeError(R.id.emailLayout);
        }
        if (validatePostalCode(postalCode)) {
            sendError(R.id.postal_codeLayout, R.string.invalidPostalCode);

        } else {
            removeError(R.id.postal_codeLayout);
        }
    }
}



