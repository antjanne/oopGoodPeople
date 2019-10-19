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

    RecyclerView.Adapter mAdapter;
    private boolean isOfferPressed;


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
        isOfferPressed = true;
        viewDeeds(deedController.showAllActiveOffers());

    }

    public void showRequests(View view) {
        isOfferPressed = false;
        viewDeeds(deedController.showAllActiveRequests());

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdapter != null) {
            if (isOfferPressed) {
                showOffers(getCurrentFocus());
            } else {
                showRequests(getCurrentFocus());
            }
        }

    }
}
