package com.goodpeople.gooddeeds.View;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.UUID;

public class NewOffer extends AppCompatActivity {

    UUID id = UUID.randomUUID();
    private DeedController deedController = new DeedController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_offer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subjectEditText = findViewById(R.id.subjectEditText);
                EditText descriptionEditText = findViewById(R.id.descriptionEditText);

                validateInput(subjectEditText.getText().toString(), descriptionEditText.getText().toString());

                deedController.addOffer(id, subjectEditText.getText().toString(), descriptionEditText.getText().toString());

                finish();
            }
        });*/

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void submitOffer(View view) {
        EditText subjectEditText = findViewById(R.id.subjectEditText);
        String subject = subjectEditText.getText().toString();

        EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        String description = descriptionEditText.getText().toString();

        if (validateInput(subject, description)) {
            deedController.addOffer(id, subject, description);
            goBack(view);
        }
    }

    private boolean validateInput(String subject, String description) {
        boolean returnValue = true;

        if (subject == null || subject.trim().isEmpty()) {
            sendError(R.id.subjectEditText, R.string.invalidSubject);
            returnValue = false;

        }
        if (description == null || description.trim().isEmpty()) {
            sendError(R.id.descriptionEditText, R.string.invalidDescription);
            returnValue = false;
        }
        return returnValue;
    }

    private void sendError(int textInputLayout, int errorCodeId) {
        TextInputLayout layout = findViewById(textInputLayout);
        layout.setError(getString(errorCodeId));

    }

    public void goBack(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
    }





}
