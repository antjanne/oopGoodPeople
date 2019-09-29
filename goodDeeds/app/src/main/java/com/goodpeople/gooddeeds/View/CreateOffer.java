package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.R;
import com.google.android.material.textfield.TextInputLayout;

public class CreateOffer extends AppCompatActivity {

    private DeedController deedController = new DeedController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_offer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        finish();
        return super.onOptionsItemSelected(menuItem);
    }

    public void submitOffer(View view) {
        EditText subject = findViewById(R.id.subject);
        String subjectText = subject.getText().toString();

        EditText description = findViewById(R.id.description);
        String descriptionText = description.getText().toString();

        if (validateInput(subjectText, descriptionText)) {
            deedController.createOfferHandler(subjectText, descriptionText);
            goBack(view);
        }
    }

    private boolean validateInput(String subject, String description) {
        boolean returnValue = true;

        if (subject == null || subject.trim().isEmpty()) {
            sendError(R.id.subjectLayout, R.string.invalid_subject);
            returnValue = false;

        } else {
            removeError(R.id.subjectLayout);
        }

        if (description == null || description.trim().isEmpty()) {
            sendError(R.id.descriptionLayout, R.string.invalid_description);
            returnValue = false;
        } else {
            removeError(R.id.descriptionLayout);
        }

        return returnValue;
    }

    private void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }

    private void removeError(int textInputLayout) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(null);
    }

    public void goBack(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
