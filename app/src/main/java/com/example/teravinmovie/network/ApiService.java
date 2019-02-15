package com.example.teravinmovie.network;

import com.example.teravinmovie.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {
    @GET("popular?api_key=79f4bb533b8b56319af2890e5f0667b0")
    Call<ResponseMovie> getDataMovie();
}
