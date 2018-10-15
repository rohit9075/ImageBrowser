package com.example.flickerapp.activities;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.flickerapp.R;
import com.example.flickerapp.fragments.ImageListFragment;
import com.example.flickerapp.fragments.PhotoDetailFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();


    }

}
