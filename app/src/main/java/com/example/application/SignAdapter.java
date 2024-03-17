package com.example.application;


// SignAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class SignAdapter extends RecyclerView.Adapter<SignAdapter.SignViewHolder> {
    private List<Sign> signList;

    public void setData(List<Sign> signList) {
        this.signList = signList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override 
    public SignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_sign, parent, false);
        return new SignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SignViewHolder holder, int position) {
        Sign sign = signList.get(position);
        holder.signNameTextView.setText(sign.getSignName());

        // Use Picasso or another image loading library to load images
        Picasso.get().load(sign.getImageUrl()).into(holder.signImageView);
    }

    @Override
    public int getItemCount() {
        return signList != null ? signList.size() : 0;
    }

    static class SignViewHolder extends RecyclerView.ViewHolder {
        TextView signNameTextView;
        ImageView signImageView;

        SignViewHolder(@NonNull View itemView) {
            super(itemView);
            signNameTextView = itemView.findViewById(R.id.signNameTextView);
            signImageView = itemView.findViewById(R.id.signImageView);
        }
    }
}

