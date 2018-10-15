package com.example.flickerapp.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import com.example.flickerapp.R;
import com.example.flickerapp.fragments.ImageListFragment;
import com.example.flickerapp.fragments.PhotoDetailFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getScreenOrientation();

    }



    public void getScreenOrientation()
    {
        Display screenOrientation = getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;

        if(screenOrientation.getWidth() < screenOrientation.getHeight()){
            // orientation = Configuration.ORIENTATION_PORTRAIT;

            // portrait
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();

        }else {
            //  orientation = Configuration.ORIENTATION_LANDSCAPE;
            // Landscape
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.containerforPhotoDetail,new PhotoDetailFragment()).commit();
            //Do something

        }
    }


}
