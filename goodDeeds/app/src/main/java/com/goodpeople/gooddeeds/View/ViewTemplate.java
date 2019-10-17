package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * The template which other views can extend
 */

public abstract class ViewTemplate extends AppCompatActivity {

    protected final AccountController accountController = new AccountController();

    final DeedController deedController = new DeedController();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected boolean isEmailValid(String email) {
        return email.contains("@") && email.contains(".");
    }

    protected boolean isPostalCodeValid(Integer postalCode) {
        return (postalCode != null && postalCode.toString().length() == 5);

    }


    protected void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }

    protected void removeError(int textInputLayout) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(null);

    }

    void goBack(View view) {
        finish();
    }
}
