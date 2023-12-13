package com.example.fortourists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.AttractionViewHolder> {

    private List<Attraction> attractions;
    private Context context;

    public AttractionsAdapter(List<Attraction> attractions, Context context) {
        this.attractions = attractions;
        this.context = context;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attraction, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        Attraction attraction = attractions.get(position);

        holder.nameTextView.setText(attraction.getName());
        holder.descriptionTextView.setText(attraction.getDescription());
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    // ViewHolder class
    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_attraction_name);
            descriptionTextView = itemView.findViewById(R.id.text_attraction_description);
        }
    }
}
