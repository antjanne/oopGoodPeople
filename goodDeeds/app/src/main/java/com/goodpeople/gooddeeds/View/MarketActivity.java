package com.goodpeople.gooddeeds.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

/**
 * Responsible for showing active offers.
 * Holds a recyclerview, adapter, layout manager.
 */



public class MarketActivity extends ViewTemplate {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_market);
        super.onCreate(savedInstanceState);
    }

    private void viewDeeds(List<IDeed> deeds) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter mAdapter = new DeedAdapter(deeds);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void showOffers(View view) {
        viewDeeds(deedController.showAllActiveOffers());

    }

    public void showRequests(View view) {
        viewDeeds(deedController.showAllActiveRequests());

    }
}
