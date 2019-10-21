package com.goodpeople.gooddeeds.View;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

public class MyActiveDeeds extends ViewTemplate {
    private boolean isOfferPressed;
    private RecyclerView.Adapter mAdapter;
    private TextView deedType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.my_active_deeds);
        super.onCreate(savedInstanceState);
        deedType = findViewById(R.id.deedTypeCurrentlyShowing);
    }

    public void showMyActiveOffers(View view) {
        isOfferPressed = true;
        deedType.setText("Offers");
        viewDeeds(deedController.showMyActiveOffersHandler());
    }

    public void showMyActiveRequests(View view) {
        isOfferPressed = false;
        deedType.setText("Requests");
        viewDeeds(deedController.showMyActiveRequestsHandler());
    }

    private void viewDeeds(List<IDeed> deeds) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DeedAdapter(deeds);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showClaimedDeeds(List<IDeed> deeds) {
        deedType.setText("Claimed Deeds");
        viewDeeds(deedController.getMyClaimedDeedsHandler());

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdapter != null) {
            if (isOfferPressed)
                showMyActiveOffers(getCurrentFocus());
            else
                showMyActiveRequests(getCurrentFocus());
        }
    }
}
