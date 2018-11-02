package com.example.flickerapp.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import com.example.flickerapp.R;
import com.example.flickerapp.fragments.ImageListFragment;
import com.example.flickerapp.fragments.PhotoDetailFragment;
import com.example.flickerapp.fragments.PhotoPreviewFragment;

public class MainActivity extends AppCompatActivity {

    Bundle myBundle;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();
    }


}
