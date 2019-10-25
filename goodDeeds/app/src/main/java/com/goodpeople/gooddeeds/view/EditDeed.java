package com.goodpeople.gooddeeds.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goodpeople.gooddeeds.R;

/**
 * Responsible for providing the form for editing a deed.
 */

public class EditDeed extends ViewTemplate {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.edit_deed);
        super.onCreate(savedInstanceState);
        Button submitButton = findViewById(R.id.submitButton);
        EditText editSubj = findViewById(R.id.subjectEditText);
        EditText editDesc = findViewById(R.id.descriptionEditText);
        editSubj.setText(deedController.getDeedSubject());
        editDesc.setText(deedController.getDeedDescription());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subjectEditText = findViewById(R.id.subjectEditText);
                EditText descriptionEditText = findViewById(R.id.descriptionEditText);
                deedController.editDeedHandler(subjectEditText.getText().toString(), descriptionEditText.getText().toString());
                finish();
            }
        });

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
