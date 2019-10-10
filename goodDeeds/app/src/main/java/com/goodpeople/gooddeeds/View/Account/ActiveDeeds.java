package com.goodpeople.gooddeeds.View.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_active_offers);
        super.onCreate(savedInstanceState);

        viewDeeds(deedController.showMyActiveOffersHandler());
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
