package com.prabhakar.desimasala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<VideoModel> videos;
    private VideoAdapter videoAdapter;
    private ViewPager2 videoSlider;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        intiViews();
        buildVideoSliderList();
        setVideoSliderAdapter();

    }

    private void intiViews() {
        videoSlider = findViewById(R.id.viewPager);
    }

    private void buildVideoSliderList() {
        videos = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            videos.add(new VideoModel(R.raw.video1, "Prabhakar", "Wah Bete MOj kar diya tune #latest #trending"));
            videos.add(new VideoModel(R.raw.video2, "Abhishek", "Bhai tujhe koi nahi samajh  skta hai #latest #trending"));
            videos.add(new VideoModel(R.raw.video3, "Anurag", "Har ek friend kamina hota hia #freinds #latest #trending"));
            videos.add(new VideoModel(R.raw.video1, "Aditya", "#latest #trending"));

        }
    }

    private void setVideoSliderAdapter() {
        videoAdapter = new VideoAdapter(videos);
        videoSlider.setAdapter(videoAdapter);
    }
}