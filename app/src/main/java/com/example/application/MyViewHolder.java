package com.example.application;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class MyViewHolder extends ViewHolder {


    ImageView imageView;
    TextView letterView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView3);
        letterView  = itemView.findViewById(R.id.textView4);
    }
}
