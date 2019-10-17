package com.goodpeople.gooddeeds.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.ActiveDeeds;
import com.goodpeople.gooddeeds.View.MainActivity;
import com.goodpeople.gooddeeds.View.ViewTemplate;

public class AccountOptions extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.account_options);
        super.onCreate(savedInstanceState);
    }

    public void goToAccountDetails(View view) {
        Intent intent = new Intent(this, AccountDetails.class);
        startActivity(intent);
    }

    public void goToActiveDeeds(View view) {
        Intent intent = new Intent(this, ActiveDeeds.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        accountController.logout();
    }
}
