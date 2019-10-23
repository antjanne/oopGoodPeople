package com.goodpeople.gooddeeds.View.Account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.Balance;
import com.goodpeople.gooddeeds.View.ClaimedDeeds;
import com.goodpeople.gooddeeds.View.MainActivity;
import com.goodpeople.gooddeeds.View.MyActiveDeeds;
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
        Intent intent = new Intent(this, MyActiveDeeds.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        accountController.logout();
    }

    public void goToClaimedDeeds(View view) {
        Intent intent = new Intent(this, ClaimedDeeds.class);
        startActivity(intent);
    }

    public void goToMyBalance(View View) {
        Intent intent = new Intent(this, Balance.class);
        startActivity(intent);
    }


}
