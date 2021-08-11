package com.prabhakar.desimasala;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    VideoView videoView;
    TextView videoUserName, videoThumbnail;
    ImageView likeButton, shareButton;
    private boolean like;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        like=false;
        videoView = itemView.findViewById(R.id.video);
        videoUserName = itemView.findViewById(R.id.title);
        videoThumbnail = itemView.findViewById(R.id.description);
        likeButton = itemView.findViewById(R.id.like_btn);
        shareButton = itemView.findViewById(R.id.share_btn);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("txt/plain");
                v.getContext().startActivity(share);
            }
        });


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!like) {
                    likeButton.setImageResource(R.drawable.like);
                    like = true;
                }
                else {
                    likeButton.setImageResource(R.drawable.unlike);
                    like=false;
                }
            }
        });

    }

    public void setLayoutData(VideoModel model) {
        // videoView.setVideoPath(model.getVideoURL());

        String video_url = "android.resource://" + videoView.getContext().getPackageName() + "/" + model.getVideoURL();
        Uri videoUri = Uri.parse(video_url);
        videoView.setVideoURI(videoUri);
        videoUserName.setText(model.getUserName());
        videoThumbnail.setText(model.getThumbnail());
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
//                float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
//                float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
//                float scale = videoRatio / screenRatio;
//                if (scale>=1f){
//                    videoView.setScaleX(scale);
//                }else {
//                    videoView.setScaleY(1f/scale);
//                }

            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }
}
