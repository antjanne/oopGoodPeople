package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goodpeople.gooddeeds.R;
import com.goodpeople.gooddeeds.View.Account.AccountDetails;

public class ActiveOffersActivity extends ViewTemplate {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_active_offers);
        super.onCreate(savedInstanceState);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DeedAdapter(deedController.showMyActiveOffersHandler());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }


    public void goToAccountDetails(View view) {
        Intent intent = new Intent(this, AccountDetails.class);
        startActivity(intent);
    }


}
