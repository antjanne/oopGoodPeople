package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.R;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    AccountController accountController = new AccountController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.toolbar_login:
                login();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void activeOffers(View view) {
        Intent intent = new Intent(MainActivity.this, ActiveOffersActivity.class);
        startActivity(intent);
    }


    public void login() {
        if (!accountController.isLoggedIn()) {
            Intent myIntent = new Intent(this, Login.class);
            startActivity(myIntent);
        } else {
            Intent intent = new Intent(this, ActiveOffersActivity.class);
            startActivity(intent);

        }
    }

    public void createOffer(View view) {
        if (accountController.isLoggedIn()) {
            Intent myIntent = new Intent(this, CreateOffer.class);
            startActivity(myIntent);
        } else {
            login();
        }
    }

    public void viewOffer(View view) {
        Intent myIntent = new Intent(this, ViewOffer.class);
        startActivity(myIntent);
    }
}
