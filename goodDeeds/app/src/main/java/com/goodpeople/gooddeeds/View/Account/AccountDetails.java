package com.goodpeople.gooddeeds.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.IAccount;
import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.ViewTemplate;

public class AccountDetails extends ViewTemplate {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.account_detail);
        super.onCreate(savedInstanceState);
        populateFields();
    }


    @Override
    public void onResume() {
        super.onResume();
        populateFields();
    }

    private void populateFields() {

        IAccount account = accountController.accountHandler();

        TextView name = (TextView) findViewById(R.id.account_name_data);
        TextView email = (TextView) findViewById(R.id.account_email_data);
        TextView postalCode = (TextView) findViewById(R.id.account_postal_code_data);

        name.setText(account.getName());
        email.setText(account.getEmail());
        postalCode.setText(Integer.toString(account.getPostalCode()));

    }

    public void editDetailsView(View view) {
        Intent myIntent = new Intent(this, EditAccount.class);
        startActivity(myIntent);
    }

    public void editPassword(View view) {
        Intent myIntent = new Intent(this, EditAccountPassword.class);
        startActivity(myIntent);
    }


}
