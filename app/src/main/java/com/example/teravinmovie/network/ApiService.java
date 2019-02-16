package com.example.teravinmovie.network;

import com.example.teravinmovie.model.ResponseFilm;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {
    @GET("registrasi.php")
    Call<ResponseFilm> getDataMovie();
}
