package com.example.flickerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;
import com.example.flickerapp.R;
import com.example.flickerapp.activities.GlideApp;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoZoomFragment extends Fragment {


    public PhotoZoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_photo_zoom, container, false);

        ImageView imageView = view.findViewById(R.id.imageView_photo_zoom);
        imageView.setOnTouchListener(new ImageMatrixTouchHandler(view.getContext()));

        Bundle bundle = getArguments();

        String imagelink = bundle.getString("link");
        String link = imagelink.replaceFirst("_m.","_b.");

        GlideApp.with(getContext())
                .load(link)
                .thumbnail(Glide.with(getContext()).load(R.drawable.ic_placeholder))
                .into(imageView);

        return view;
    }

}
