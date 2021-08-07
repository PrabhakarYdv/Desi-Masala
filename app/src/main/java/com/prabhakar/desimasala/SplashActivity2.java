package com.prabhakar.desimasala;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class SplashActivity2 extends AppCompatActivity {
    private final static int TIME_GAP = 10000;
    private Animation textAnimation;
    private TextView appName;
    private GifImageView loadingImage;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash2);
        appName = findViewById(R.id.name);
        loadingImage = findViewById(R.id.loading);
        start();
        textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        appName.setAnimation(textAnimation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity2.this, AccountActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_GAP);
    }

    private void start() {
        Handler loadingHandler = new Handler();
        loadingHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingImage.setVisibility(View.VISIBLE);
            }
        },1000);

    }
}