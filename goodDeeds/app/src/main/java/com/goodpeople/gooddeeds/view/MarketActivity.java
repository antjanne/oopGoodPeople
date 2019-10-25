package com.goodpeople.gooddeeds.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.goodpeople.gooddeeds.model.entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

/**
 * Responsible for showing active offers.
 * Holds a recyclerview, adapter, layout manager.
 */


public class MarketActivity extends ViewTemplate {

    private RecyclerView.Adapter mAdapter;
    private boolean isOfferPressed;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_market);
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
    }

    private void viewDeeds(List<IDeed> deeds) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DeedAdapter(deeds);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void showOffers(View view) {
        isOfferPressed = true;
        if (deedController.showAllActiveOffersHandler().isEmpty()) {
            Toast toast = Toast.makeText(context, "No available offers", Toast.LENGTH_SHORT);
            toast.show();
        }
        viewDeeds(deedController.showAllActiveOffersHandler());

    }

    public void showRequests(View view) {
        isOfferPressed = false;
        if (deedController.showAllActiveRequestsHandler().isEmpty()) {
            Toast toast = Toast.makeText(context, "No available requests", Toast.LENGTH_SHORT);
            toast.show();
        }
        viewDeeds(deedController.showAllActiveRequestsHandler());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdapter != null) {
            if (isOfferPressed)
                showOffers(getCurrentFocus());
            else
                showRequests(getCurrentFocus());
        }
    }
}
