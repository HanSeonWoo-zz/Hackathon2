package com.example.hackathon;

import android.graphics.Bitmap;

public class RecyclerViewData {

    private Bitmap userImage3;
    private String userNickName;
    private Bitmap youTubeThumbnail;
    private String countLike;
    private String countView;
    private String contents;

    public Bitmap getUserImage() {
        return userImage3;
    }

    public void setUserImage(Bitmap userImage) {
        this.userImage3 = userImage;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Bitmap getYouTubeThumbnail() {
        return youTubeThumbnail;
    }

    public void setYouTubeThumbnail(Bitmap youTubeThumbnail) {
        this.youTubeThumbnail = youTubeThumbnail;
    }

    public String getCountLike() {
        return countLike;
    }

    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }

    public String getCountView() {
        return countView;
    }

    public void setCountView(String countView) {
        this.countView = countView;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
