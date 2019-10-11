package com.goodpeople.gooddeeds.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Responsible for putting deeds in the recyclerview
 */

public class DeedAdapter extends RecyclerView.Adapter<DeedAdapter.DeedViewHolder> {
    private List<IDeed> mDeeds;
    public static class DeedViewHolder extends RecyclerView.ViewHolder{
        public TextView mSubject;
        public TextView mDescription;

        public DeedViewHolder(@NonNull View itemView) {
            super(itemView);

            mSubject = itemView.findViewById(R.id.subjectText);
            mDescription = itemView.findViewById(R.id.descriptionText);
        }
    }

    public DeedAdapter(List<IDeed> deeds){
        mDeeds = deeds;
    }
    @NonNull
    @Override
    public DeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deed_cardview,parent, false);
        DeedViewHolder dvh = new DeedViewHolder(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DeedViewHolder holder, int position) {
    IDeed currentDeed = mDeeds.get(position);

    holder.mDescription.setText(currentDeed.getDescription());
    holder.mSubject.setText(currentDeed.getSubject());

    }

    @Override
    public int getItemCount() {
        return mDeeds.size();
    }
}
