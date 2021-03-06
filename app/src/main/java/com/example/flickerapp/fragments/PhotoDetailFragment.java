package com.example.flickerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.flickerapp.R;
import com.example.flickerapp.activities.GlideApp;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoDetailFragment extends Fragment {

    private TextView author,title,tags,link;
    private ImageView image;

    public PhotoDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_photo_detail, container, false);


        author = view.findViewById(R.id.photo_author);
        title = view.findViewById(R.id.photo_title);
        tags = view.findViewById(R.id.photo_tags);
        link = view.findViewById(R.id.photo_link);
        image = view.findViewById(R.id.photo_image);


        Bundle bundle = getArguments();

        if (bundle != null){

            author.setText(bundle.getString("author"));
            title.setText(bundle.getString("title"));
            tags.setText(bundle.getString("tags"));

            String imagelink = bundle.getString("link");
            String link = imagelink.replaceFirst("_m.","_b.");

            GlideApp.with(getContext())
                    .load(link)
                    .thumbnail(Glide.with(getContext()).load(R.drawable.ic_placeholder))
                    .into(image);
        }

        return view;
    }
}
