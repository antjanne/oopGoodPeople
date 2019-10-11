package com.goodpeople.gooddeeds.View;

import android.os.Bundle;


import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;


public class ViewOffer extends ViewTemplate {
    private IDeed deed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.view_offer);
        super.onCreate(savedInstanceState);
        this.deed = getIntent().getParcelableExtra("clicked_deed");
        TextView subject = findViewById(R.id.deedSubject);
        subject.setText(deed.getSubject());
        TextView description = findViewById(R.id.deedDescription);
        description.setText(deed.getDescription());

    }
}
