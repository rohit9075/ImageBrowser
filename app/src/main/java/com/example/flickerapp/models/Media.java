package com.example.flickerapp.models;

import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("m")
    private String ImageLink;

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        this.ImageLink = imageLink;
    }
}
