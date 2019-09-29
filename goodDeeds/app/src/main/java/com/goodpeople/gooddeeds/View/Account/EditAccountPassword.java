package com.goodpeople.gooddeeds.View.Account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.ViewTemplate;

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

        if (!accountController.accountHandler().getPassword().equals(oldPassword)) {
            return false;
        }
        if (newPassword.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private void setError(String oldPassword, String newPassword) {
        if (!accountController.accountHandler().getPassword().equals(oldPassword)) {
            sendError(R.id.edit_password_old_password_layout, R.string.invalidPassword);
        }
        if (newPassword.trim().isEmpty()) {
            sendError(R.id.edit_password_new_password_layout, R.string.invalidPassword);
        }


    }

}
