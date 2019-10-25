package com.goodpeople.gooddeeds.view.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.view.ViewTemplate;

public class EditAccountPassword extends ViewTemplate {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.edit_account_password);
        super.onCreate(savedInstanceState);
    }


    public void onSubmit(View view) {
        String oldPassword = ((EditText) findViewById(R.id.edit_password_old_password)).getText().toString();
        String newPassword = ((EditText) findViewById(R.id.edit_password_new_password)).getText().toString();

        if (validatePassword(oldPassword, newPassword)) {
            accountController.updatePasswordHandler(newPassword);
            finish();
        } else {
            setError(oldPassword, newPassword);
        }


    }

    private boolean validatePassword(String oldPassword, String newPassword) {
        return !newPassword.trim().isEmpty() && (accountController.getLoggedInAccountHandler().getPassword()==oldPassword.hashCode());
    }

    private void setError(String oldPassword, String newPassword) {
        if (!(accountController.getLoggedInAccountHandler().getPassword()==oldPassword.hashCode()|| newPassword.trim().isEmpty())) {
            sendError(R.id.edit_password_old_password_layout, R.string.invalid_password);
        }
    }

}
