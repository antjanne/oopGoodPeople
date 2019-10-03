package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.R;

import java.util.UUID;

public class EditOffer extends AppCompatActivity {

    UUID id = UUID.randomUUID();
    private DeedController deedController = new DeedController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_offer);
        Button submitButton = findViewById(R.id.submitButton);
        EditText editSubj = (EditText) findViewById(R.id.subjectEditText);
        EditText editDesc = (EditText) findViewById(R.id.descriptionEditText);
        editSubj.setText(deedController.getDeedSubject());
        editDesc.setText(deedController.getDeedDescription());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subjectEditText = findViewById(R.id.subjectEditText);
                EditText descriptionEditText = findViewById(R.id.descriptionEditText);
                deedController.editOffer(deedController.getDeedID(), subjectEditText.toString(), descriptionEditText.toString());
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

