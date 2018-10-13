package com.example.flickerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flickerapp.R;
import com.example.flickerapp.adapter.ImageRecyclerAdapter;
import com.example.flickerapp.api_client.APIClient;
import com.example.flickerapp.api_client.ImagelistEndPoint;
import com.example.flickerapp.models.PhotoModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageListFragment extends Fragment {


    // reference variables
    RecyclerView mRecyclerView;

    List<PhotoModel> mFlickerDataList;


    ImageRecyclerAdapter mImageRecyclerAdapter;




    public ImageListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_image_list, container, false);


        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ImagelistEndPoint apiService =
                APIClient.getClient().create(ImagelistEndPoint.class);

        Call<PhotoModel> call = apiService.getRepo("car","any","json","1");
        call.enqueue(new Callback<PhotoModel>() {
            @Override
            public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {

                //adding the all data to the ArrayList
                mFlickerDataList = new ArrayList<>();
                mFlickerDataList.addAll(response.body());
                Toast.makeText(getContext(), mFlickerDataList.size(), Toast.LENGTH_SHORT).show();

                mImageRecyclerAdapter = new ImageRecyclerAdapter(getContext(), mFlickerDataList);

                mImageRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {
                // Log error here since request failed
                Log.e("Repos", t.toString());
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }

        });



        return view;
    }

}
