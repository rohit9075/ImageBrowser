package com.example.flickerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flickerapp.R;
import com.example.flickerapp.adapter.ImageRecyclerAdapter;
import com.example.flickerapp.api_client.APIClient;
import com.example.flickerapp.api_client.ImagelistEndPoint;
import com.example.flickerapp.models.PhotoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;


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

        mFlickerDataList = new ArrayList<>();


        ImagelistEndPoint apiService =
                APIClient.getClient().create(ImagelistEndPoint.class);

        Call<List<PhotoModel>> call = apiService.getRepo("flower","any","json","1");
        call.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {

                mFlickerDataList.clear();

                Log.d("Fragment", "onResponse: " + response.toString());

                //adding the all data to the ArrayList
                mFlickerDataList.addAll(response.body());

                mImageRecyclerAdapter = new ImageRecyclerAdapter(getContext(), mFlickerDataList);

                mImageRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Repos", t.toString());
            }

        });



        return view;
    }

}
