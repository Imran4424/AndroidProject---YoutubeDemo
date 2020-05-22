package com.luminous.android.youtubedemo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerVideoAdapter extends RecyclerView.Adapter<RecyclerVideoAdapter.VideoViewHolder> {
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
