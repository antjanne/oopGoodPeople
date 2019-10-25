package com.goodpeople.gooddeeds.view.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.view.MyActiveDeeds;
import com.goodpeople.gooddeeds.view.MainActivity;
import com.goodpeople.gooddeeds.view.ViewTemplate;

/**
 * Responsible for providing account options to the user.
 */

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
        Intent intent = new Intent(this, MyActiveDeeds.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        accountController.logoutHandler();
    }
}
