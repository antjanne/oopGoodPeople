package com.goodpeople.gooddeeds.View;

import android.os.Bundle;

import com.goodpeople.gooddeeds.Controller.DeedController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;


public class ViewOffer extends AppCompatActivity {
    DeedController deedController = new DeedController();
    private IDeed deed;

    public ViewOffer() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_offer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.deed = getIntent().getParcelableExtra("clicked_deed");
        TextView subject = findViewById(R.id.deedSubject);
        subject.setText(deed.getSubject());
        TextView description = findViewById(R.id.deedDescription);
        description.setText(deed.getDescription());

    }
}
