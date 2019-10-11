package com.goodpeople.gooddeeds.View.Account;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.DeedAdapter;
import com.goodpeople.gooddeeds.View.ViewTemplate;

import java.util.List;

public class ActiveDeeds extends ViewTemplate {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView deedType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.active_deeds);
        super.onCreate(savedInstanceState);
        deedType = findViewById(R.id.deedTypeCurrentlyShowing);
    }

    public void showMyActiveOffers(View view) {
        deedType.setText("Offers");
        viewDeeds(deedController.showMyActiveOffersHandler());
    }

    public void showMyActiveRequests(View view) {
        deedType.setText("Requests");
        viewDeeds(deedController.showMyActiveRequestsHandler());
    }

    private void viewDeeds(List<IDeed> deeds) {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DeedAdapter(deeds);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


}
