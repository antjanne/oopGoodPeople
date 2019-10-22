package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.goodpeople.gooddeeds.R;

/**
 * Responsible for handling input in the view when creating an offer.
 */

public class CreateDeed extends ViewTemplate {
    private boolean isOffer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        isOffer = getIntent().getExtras().getBoolean("isOffer");
        setContentView(R.layout.create_deed);
        super.onCreate(savedInstanceState);
        TextView deedType = findViewById(R.id.createDeedTextView);
        deedType.setText(isOffer ? "Create Offer" : "Create Request");
    }

    public void submitOffer(View view) {
        EditText subject = findViewById(R.id.subject);
        String subjectText = subject.getText().toString();

        EditText description = findViewById(R.id.description);
        String descriptionText = description.getText().toString();

        if (validateInput(subjectText, descriptionText)) {
            if (isOffer) {
                deedController.createOfferHandler(subjectText, descriptionText);
                goBack(view);
            }
        } else {
            deedController.createRequestHandler(subjectText, descriptionText);
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


}
