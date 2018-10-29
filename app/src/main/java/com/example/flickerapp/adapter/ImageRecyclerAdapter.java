package com.example.flickerapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flickerapp.R;
import com.example.flickerapp.activities.GlideApp;
import com.example.flickerapp.models.PhotoModel;


import java.util.List;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MyViewHolder> {

    private List<PhotoModel> imageList;
    private Context context;

    //********************** added in the version 2.0 ********************************
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    public ImageRecyclerAdapter(Context context, List<PhotoModel> imageList) {

        this.context = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_items, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        PhotoModel photo = imageList.get(position);

        String ImageLink = photo.getMedia().getImageLink();

        String link = ImageLink.replaceFirst("_m.","_b.");

        GlideApp.with(context)
                .load(link)
                .thumbnail(Glide.with(context).load(R.drawable.ic_placeholder))
                .into(holder.image);


        holder.title.setText(photo.getTitle());

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;

        MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);

        }

    }

}
