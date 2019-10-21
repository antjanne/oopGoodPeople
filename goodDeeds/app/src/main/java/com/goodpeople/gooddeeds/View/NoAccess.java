package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.Account.Login;

public class NoAccess extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.no_access);
        super.onCreate(savedInstanceState);
    }

    public void login(View view) {
        Intent myIntent = new Intent(this, Login.class);
        startActivity(myIntent);
    }


}
