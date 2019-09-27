package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.R;

public class AccountDetails extends AppCompatActivity {

    private AccountController accountController = new AccountController();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        populateFields();
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

    @Override
    public void onResume() {
        super.onResume();
        populateFields();
    }

    private void populateFields() {

        Account account = accountController.accountHandler();

        TextView name = (TextView) findViewById(R.id.account_name_data);
        TextView email = (TextView) findViewById(R.id.account_email_data);
        TextView postalCode = (TextView) findViewById(R.id.account_postal_code_data);

        name.setText(account.getName());
        email.setText(account.getEmail());
        postalCode.setText(Integer.toString(account.getPostalCode()));

    }

    public void edit(View view) {
        Intent myIntent = new Intent(this, EditAccount.class);
        startActivity(myIntent);
    }


}
