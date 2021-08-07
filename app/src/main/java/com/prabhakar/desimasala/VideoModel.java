package com.prabhakar.desimasala;

public class VideoModel {
    int videoURL;
    String userName;
    String thumbnail;

    public VideoModel(int videoURL, String userName, String thumbnail) {
        this.videoURL = videoURL;
        this.userName = userName;
        this.thumbnail = thumbnail;
    }

    public int getVideoURL() {
        return videoURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
