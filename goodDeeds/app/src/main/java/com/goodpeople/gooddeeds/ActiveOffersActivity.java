package com.goodpeople.gooddeeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.View.MainActivity;

public class ActiveOffersActivity extends AppCompatActivity {
    DeedController controller = new DeedController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_offers);

    }

    public void changeToMainActivity(View view) {
        Intent intent = new Intent(ActiveOffersActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void getOffers(){
    }
}
