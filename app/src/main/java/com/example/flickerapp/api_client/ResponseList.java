package com.example.flickerapp.api_client;

import com.example.flickerapp.models.PhotoModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseList {

    @SerializedName("items")
    @Expose
    private List<PhotoModel> itemList = null;

    public List<PhotoModel> getItemList() {
        return itemList;
    }

}
