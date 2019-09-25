package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.goodpeople.gooddeeds.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(View view) {
        Intent myIntent = new Intent(view.getContext(), CreateAccount.class);
        startActivityForResult(myIntent, 0);
    }

    public void login(View view) {
        Intent myIntent = new Intent(view.getContext(), Login.class);
        startActivityForResult(myIntent, 0);
    }
}
