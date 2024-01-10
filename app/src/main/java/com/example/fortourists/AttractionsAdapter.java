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

    private List<Attraction> attractions; // List to hold attractions data
    private Context context;

    // Constructor to initialize the adapter with attractions data and context
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

    // Binds the data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        // Get the attraction at the current position
        Attraction attraction = attractions.get(position);

        // Set the name and description in the ViewHolder
        holder.nameTextView.setText(attraction.getName());
        holder.descriptionTextView.setText(attraction.getDescription());
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return attractions.size();
    }

    // ViewHolder class to hold the views for each item in the RecyclerView
    public static class AttractionViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;

        // Constructor to initialize the views
        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find and store the TextViews for name and description
            nameTextView = itemView.findViewById(R.id.text_attraction_name);
            descriptionTextView = itemView.findViewById(R.id.text_attraction_description);
        }
    }
}
