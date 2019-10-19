package com.goodpeople.gooddeeds.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;


public class ViewDeed extends ViewTemplate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.view_deed);
        super.onCreate(savedInstanceState);
        loadDeed();
        View button = (Button) findViewById(R.id.edit_offer);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        if (!deedController.isMyActiveDeedHandler()) {
            button.setVisibility(View.GONE);
            deleteButton.setVisibility(View.GONE);
        }
    }

    private void loadDeed() {
        IDeed deed = deedController.getCurrentDeedHandler();
        TextView subject = findViewById(R.id.deedSubject);
        subject.setText(deed.getSubject());
        TextView description = findViewById(R.id.deedDescription);
        description.setText(deed.getDescription());
    }

    public void editOffer(View view) {
        Intent myIntent = new Intent(this, EditOffer.class);
        startActivity(myIntent);
    }

    public void onDeleteClick(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Delete");
        alert.setMessage("Are you sure you want to delete?");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                deedController.deleteCurrentDeedHandler();
                finish();
            }
        });
        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDeed();

    }
}
