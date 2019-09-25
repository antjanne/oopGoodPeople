package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.goodpeople.gooddeeds.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newOfferButton = findViewById(R.id.newOfferButton);
        newOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newOffer();
            }
        });
    }

    private void newOffer() {
        Intent myIntent = new Intent(this, NewOffer.class);
        startActivity(myIntent);
    }
}
