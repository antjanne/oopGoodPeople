package com.goodpeople.gooddeeds.View;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

public class ActiveDeeds extends ViewTemplate {
    private boolean isOfferPressed;
    private RecyclerView.Adapter mAdapter;
    private TextView deedType;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.active_deeds);
        super.onCreate(savedInstanceState);
        deedType = findViewById(R.id.deedTypeCurrentlyShowing);
         context = getApplicationContext();
    }

    public void showMyActiveOffers(View view) {
        isOfferPressed = true;
        if(deedController.showMyActiveOffersHandler().isEmpty()){
            Toast toast = Toast.makeText(context,"You have no active offers",Toast.LENGTH_SHORT);
            toast.show();
        }
        deedType.setText("Offers");
        viewDeeds(deedController.showMyActiveOffersHandler());
    }

    public void showMyActiveRequests(View view) {
        isOfferPressed = false;
        deedType.setText("Requests");
        if(deedController.showMyActiveRequestsHandler().isEmpty()){
            Toast toast = Toast.makeText(context,"You have no active requests",Toast.LENGTH_SHORT);
            toast.show();
        }
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
