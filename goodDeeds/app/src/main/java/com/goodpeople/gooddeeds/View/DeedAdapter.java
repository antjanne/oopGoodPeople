package com.goodpeople.gooddeeds.View;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;


/**
 * Responsible for putting deeds in the recyclerview
 */


public class DeedAdapter extends RecyclerView.Adapter<DeedAdapter.DeedViewHolder> {
    DeedController deedController = new DeedController();

    public DeedAdapter() {
    }

    @NonNull
    @Override
    public DeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deed_cardview, parent, false);
        return new DeedViewHolder(v, deedController.showMyOffersHandler());
    }

    @Override
    public void onBindViewHolder(@NonNull DeedViewHolder holder, int position) {
        IDeed currentDeed = deedController.showMyOffersHandler().get(position);

        holder.mDescription.setText(currentDeed.getDescription());
        holder.mSubject.setText(currentDeed.getSubject());

    }

    @Override
    public int getItemCount() {
        return deedController.showMyOffersHandler().size();
    }

    public static class DeedViewHolder extends RecyclerView.ViewHolder {
        public TextView mSubject;
        public TextView mDescription;

        public DeedViewHolder(@NonNull View itemView, final List<IDeed> deeds) {
            super(itemView);
            mSubject = itemView.findViewById(R.id.subjectText);
            mDescription = itemView.findViewById(R.id.descriptionText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IDeed deed = deeds.get(getAdapterPosition());
                    Intent intent = new Intent(v.getContext(), ViewOffer.class);
                    new DeedController().setCurrentDeedHandler(deed.getUuid());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
