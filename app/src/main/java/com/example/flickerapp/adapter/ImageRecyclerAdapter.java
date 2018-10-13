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

import com.example.flickerapp.R;
import com.example.flickerapp.models.PhotoModel;


import java.util.List;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MyViewHolder> {

    List<PhotoModel> imageList;
    Context context;

    //********************** added in the version 2.0 ********************************
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    public ImageRecyclerAdapter(Context context, List<PhotoModel> imageList) {

        this.context = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


//        holder.bind(imageList.get(position),listener);

        PhotoModel photo = imageList.get(position);





//        GlideApp.with(context)
//                .load(photo.getImage())
//                .thumbnail(Glide.with(context).load(R.drawable.ic_placeholder))
//                .into(holder.image);

        holder.title.setText(photo.getTitle());

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);

        }

    }

}
