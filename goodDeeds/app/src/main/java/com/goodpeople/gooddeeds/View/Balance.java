package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.widget.TextView;

import com.goodpeople.gooddeeds.R;

public class Balance extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.my_balance);
        super.onCreate(savedInstanceState);
        setPoints();
    }

    private void setPoints() {
        TextView currentBalance = findViewById(R.id.current_balance_data);
        int points = accountController.getKarmaPoints();
        String showBalance = points + "/n Karma Points";
        currentBalance.setText(showBalance);

    }

    @Override
    public void onResume() {
        super.onResume();
        setPoints();
    }

}