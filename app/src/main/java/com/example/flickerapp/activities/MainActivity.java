package com.example.flickerapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.flickerapp.R;
import com.example.flickerapp.fragments.ImageListFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();
    }

}
