package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.R;


public class EditOffer extends AppCompatActivity {

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
                deedController.editOfferHandler(subjectEditText.getText().toString(), descriptionEditText.getText().toString());
                //View desc = findViewById(R.id.view_offer);
                //desc.requestLayout();
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
