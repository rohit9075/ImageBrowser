package com.example.flickerapp.api_client;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImagelistEndPoint {


    @GET("/services/feeds/photos_public.gne")
    Call<ResponseList> getRepo(
            @Query("tags") String name,
            @Query("tagmode") String tagmod,
            @Query("format") String format,
            @Query("nojsoncallback") String callback);


}


