package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;


public class ViewDeed extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.view_deed);
        super.onCreate(savedInstanceState);
        IDeed deed = deedController.getCurrentDeedHandler();
        TextView subject = findViewById(R.id.deedSubject);
        subject.setText(deed.getSubject());
        TextView description = findViewById(R.id.deedDescription);
        description.setText(deed.getDescription());
        View button = (Button) findViewById(R.id.edit_offer);
        if (!deedController.isMyActiveDeedHandler()) {
            button.setVisibility(View.GONE);
        }
        View claimbutton = (Button) findViewById(R.id.claim_deed);
        if (deedController.isMyOwnDeedHandler() &&
                deedController.isClaimedHandler()) {
            claimbutton.setVisibility(View.GONE);
        }
        claimbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deedController.claimDeed();
                finish();
            }
        });
    }

    public void editOffer(View view) {
        Intent myIntent = new Intent(this, EditOffer.class);
        startActivity(myIntent);
    }
}
