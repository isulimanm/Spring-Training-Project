package com.example.spring_training_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SliderViewHolder>{

    private final int[] imageResIds;


    public ImageSliderAdapter(int[] imageResIds) {
        this.imageResIds = imageResIds;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_of_slider, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.imageView.setImageResource(imageResIds[position]);
    }

    @Override
    public int getItemCount() {
        return imageResIds.length;
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sliderImageView);
        }
    }
}
