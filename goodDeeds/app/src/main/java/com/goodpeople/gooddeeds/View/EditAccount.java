package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.R;

public class EditAccount extends AppCompatActivity {

    private AccountController accountController = new AccountController();
    TextView name;
    TextView email;
    TextView postalCode;
    Account account;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.name = (EditText) findViewById(R.id.account_edit_name);
        this.email = (EditText) findViewById(R.id.account_edit_email);
        this.postalCode = (EditText) findViewById(R.id.account_edit_postal_code);
        this.account = accountController.accountHandler();

        populateFields();
    }


    public void populateFields() {
        name.setText(account.getName());
        email.setText(account.getEmail());
        postalCode.setText(Integer.toString(account.getPostalCode()));
    }

    public void saveUpdates(View view) {
        account.setName(this.name.getText().toString());
        account.setEmail(this.email.getText().toString());
        account.setPostalCode(Integer.valueOf(this.postalCode.getText().toString()));

        finish();

    }
}
