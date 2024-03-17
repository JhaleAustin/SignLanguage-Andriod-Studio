package com.example.application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<DataModel> data;

    public Adapter(Context context) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>(); // Initialize data list
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel item = data.get(position);
        holder.textView.setText(item.getText());
        // Load image from URL using your preferred image loading library (e.g., Picasso, Glide)
        // Example using Picasso:
        Picasso.get().load(item.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size(); // Return size of data list
    }

    public void setData(List<DataModel> newData) {
        data.clear(); // Clear previous data
        data.addAll(newData); // Add new data to the list
        notifyDataSetChanged(); // Notify adapter about the data change
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView); // Replace with your TextView ID
            imageView = itemView.findViewById(R.id.imageView); // Replace with your ImageView ID
        }
    }
}
