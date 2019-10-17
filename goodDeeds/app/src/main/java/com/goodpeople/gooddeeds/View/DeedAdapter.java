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

    private final List<IDeed> deeds;

    public DeedAdapter(List<IDeed> deeds) {
        this.deeds = deeds;
    }

    @NonNull
    @Override
    public DeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deed_cardview, parent, false);
        return new DeedViewHolder(v, deeds);
    }

    @Override
    public void onBindViewHolder(@NonNull DeedViewHolder holder, int position) {
        IDeed currentDeed = deeds.get(position);
        holder.mDescription.setText(currentDeed.getDescription());
        holder.mSubject.setText(currentDeed.getSubject());

    }

    @Override
    public int getItemCount() {
        return deeds.size();
    }

    public static class DeedViewHolder extends RecyclerView.ViewHolder {
        final TextView mSubject;
        final TextView mDescription;

        DeedViewHolder(@NonNull View itemView, final List<IDeed> deeds) {
            super(itemView);
            mSubject = itemView.findViewById(R.id.subjectText);
            mDescription = itemView.findViewById(R.id.descriptionText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IDeed deed = deeds.get(getAdapterPosition());
                    Intent intent = new Intent(v.getContext(), ViewDeed.class);

                    new DeedController().setCurrentDeedHandler(deed.getUuid());
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
