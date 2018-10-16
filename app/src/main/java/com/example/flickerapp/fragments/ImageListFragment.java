package com.example.flickerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flickerapp.Listner.RecyclerOnClickListner;
import com.example.flickerapp.Listner.RecyclerViewTouchListener;
import com.example.flickerapp.R;
import com.example.flickerapp.adapter.ImageRecyclerAdapter;
import com.example.flickerapp.api_client.APIClient;
import com.example.flickerapp.api_client.ImagelistEndPoint;
import com.example.flickerapp.api_client.ResponseList;
import com.example.flickerapp.models.PhotoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageListFragment extends Fragment {

    Bundle bundle;

    RecyclerView  mRecyclerView;

    List<PhotoModel>  mFlickerDataList;



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

        handlingRecyclerViewItemClick();

        ImagelistEndPoint apiService =
                APIClient.getClient().create(ImagelistEndPoint.class);

        Call<ResponseList> call = apiService.getRepo("car","any","json","1");
        call.enqueue(new Callback<ResponseList>() {
            @Override
            public void onResponse(Call<ResponseList> call, Response<ResponseList> response) {

                //adding the all data to the ArrayList

                mFlickerDataList = new ArrayList<>();
                mFlickerDataList = (response.body().getItemList());


             ImageRecyclerAdapter   mImageRecyclerAdapter = new ImageRecyclerAdapter(getContext(), mFlickerDataList);

             mRecyclerView.setAdapter(mImageRecyclerAdapter);


            }

            @Override
            public void onFailure(Call<ResponseList> call, Throwable t) {
                // Log error here since request failed
                Log.e("Repos", t.toString());
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }

        });

        return view;
    }


    private void handlingRecyclerViewItemClick() {
        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(), mRecyclerView, new RecyclerOnClickListner() {
            @Override
            public void onClick(View view, int position) {

                PhotoModel modelClass = mFlickerDataList.get(position);


                bundle = new Bundle();
                bundle.putString("author" , modelClass.getAuthor());
                bundle.putString("title",modelClass.getTitle());
                bundle.putString("tags" , modelClass.getTags());
                bundle.putString("link", modelClass.getMedia().getImageLink());

                PhotoZoomFragment fragment = new PhotoZoomFragment();
                fragment.setArguments(bundle);




//                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit();


                // checking the display orientation

                Display screenOrientation = getActivity().getWindowManager().getDefaultDisplay();
//                int orientation = Configuration.ORIENTATION_UNDEFINED;

                if(screenOrientation.getWidth() < screenOrientation.getHeight()){
                    // orientation = Configuration.ORIENTATION_PORTRAIT;

                    // portrait
                    getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit();

                }else {
                    Toast.makeText(getContext(),     "Click working in else part", Toast.LENGTH_SHORT).show();
                    //  orientation = Configuration.ORIENTATION_LANDSCAPE;
                    // Landscape
//                    getFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();
                    getFragmentManager().beginTransaction().replace(R.id.containerforPhotoDetail,fragment).commit();
                    //Do something

                }



            }

            @Override
            public void onLongClick(View view, int position) {

                PhotoModel modelClass = mFlickerDataList.get(position);


                bundle = new Bundle();
                bundle.putString("author" , modelClass.getAuthor());
                bundle.putString("title",modelClass.getTitle());
                bundle.putString("tags" , modelClass.getTags());
                bundle.putString("link", modelClass.getMedia().getImageLink());

                PhotoDetailFragment fragment = new PhotoDetailFragment();
                fragment.setArguments(bundle);


//                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit();


                // checking the display orientation

                Display screenOrientation = getActivity().getWindowManager().getDefaultDisplay();
//                int orientation = Configuration.ORIENTATION_UNDEFINED;

                if(screenOrientation.getWidth() < screenOrientation.getHeight()){
                    // orientation = Configuration.ORIENTATION_PORTRAIT;

                    // portrait
                    getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit();

                }else {
                    Toast.makeText(getContext(),     "Click working in else part", Toast.LENGTH_SHORT).show();
                    //  orientation = Configuration.ORIENTATION_LANDSCAPE;
                    // Landscape
//                    getFragmentManager().beginTransaction().replace(R.id.container,new ImageListFragment()).commit();
                    getFragmentManager().beginTransaction().replace(R.id.containerforPhotoDetail,fragment,"PhotoDetailFrag").commit();
                    //Do something

                }

            }
        }));
    }


}
