package com.goodpeople.gooddeeds.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.view.account.AccountOptions;
import com.goodpeople.gooddeeds.view.account.Login;

/**
 * Responsible for handling events in the MainActivity view
 */

public class MainActivity extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.toolbar_login) {
            login();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void editOffer(View view) {
        Intent myIntent = new Intent(this, EditDeed.class);
        startActivity(myIntent);
    }

    private void login() {
        if (!accountController.isLoggedIn()) {
            Intent myIntent = new Intent(this, Login.class);
            startActivity(myIntent);
        } else {
            Intent intent = new Intent(this, AccountOptions.class);
            startActivity(intent);
        }
    }

    public void createDeed(View view) {
        if (accountController.isLoggedIn()) {
            final Intent myIntent = new Intent(this, CreateDeed.class);

            AlertDialog.Builder alert = new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog);
            alert.setMessage("What type of Deed?");
            alert.setCancelable(true);
            alert.setPositiveButton("Offer", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    myIntent.putExtra("isOffer", true);
                    dialog.cancel();
                    startActivity(myIntent);
                }
            });
            alert.setNegativeButton("Request", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    myIntent.putExtra("isOffer", false);
                    dialog.cancel();
                    startActivity(myIntent);
                }
            });
            alert.show();
        } else {
            Intent myIntent = new Intent(this, NoAccess.class);
            startActivity(myIntent);
        }
    }

    public void goToMarket(View view) {
        Intent myIntent = new Intent(this, MarketActivity.class);
        startActivity(myIntent);
    }
}
