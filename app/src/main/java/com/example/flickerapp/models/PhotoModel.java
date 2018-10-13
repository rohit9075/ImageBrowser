package com.example.flickerapp.models;

import com.google.gson.annotations.SerializedName;

public class PhotoModel {

    @SerializedName("media")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("author")
    private String author;

    @SerializedName("tags")
    private String tags;


    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image= image;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getTags(){
        return tags;
    }

    public void setTags(String tags){
        this.tags = tags;
    }

}
