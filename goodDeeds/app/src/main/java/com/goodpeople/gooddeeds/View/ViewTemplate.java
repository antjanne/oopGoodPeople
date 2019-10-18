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

    public AccountController accountController = new AccountController();

    public DeedController deedController = new DeedController();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    public boolean isEmailValid(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean isPostalCodeValid(Integer postalCode) {
        return (postalCode != null && postalCode.toString().length() == 5);

    }


    public void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }

    public void removeError(int textInputLayout) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(null);

    }

    public void goBack(View view) {
        finish();
    }

}