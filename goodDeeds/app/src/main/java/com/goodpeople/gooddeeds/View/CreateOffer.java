package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;

public class CreateOffer extends ViewTemplate {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.create_offer);
        super.onCreate(savedInstanceState);
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

}
