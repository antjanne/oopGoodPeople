package com.goodpeople.gooddeeds.View;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.ActiveOffersActivity;
import com.goodpeople.gooddeeds.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activeOffers(View view) {
        Intent intent = new Intent(MainActivity.this, ActiveOffersActivity.class);
        startActivity(intent);
    }
}
