package com.prabhakar.desimasala;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private ArrayList<VideoModel> videoLists;

    public VideoAdapter(ArrayList<VideoModel> videoLists) {
        this.videoLists = videoLists;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoModel model = videoLists.get(position);
        holder.setLayoutData(model);
    }

    @Override
    public int getItemCount() {
        return videoLists.size();
    }
}