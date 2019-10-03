package com.goodpeople.gooddeeds.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

public class ActiveOffersActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    DeedController controller = new DeedController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_offers);

        mRecyclerView =findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DeedAdapter(controller.showMyOffersHandler());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



    }

    public void changeToMainActivity(View view) {
        Intent intent = new Intent(ActiveOffersActivity.this, MainActivity.class);
        startActivity(intent);
    }



}
