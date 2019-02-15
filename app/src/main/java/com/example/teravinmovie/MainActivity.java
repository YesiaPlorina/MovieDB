package com.example.teravinmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.teravinmovie.adapter.AdapterMovie;
import com.example.teravinmovie.model.ResponseMovie;
import com.example.teravinmovie.model.ResultsItem;
import com.example.teravinmovie.network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        sendRequest();

    }

    private void sendRequest() {

        ConfigRetrofit.getInstanc().getDataMovie().enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {

                if (response != null) {
                    List<ResultsItem> ListDataMovie = response.body().getResults();
                    setUpListMovie(ListDataMovie);
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

            }
        });
    }

    private void setUpListMovie(List<ResultsItem> listDataMovie) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        AdapterMovie adapter = new AdapterMovie(this, listDataMovie);
        recyclerView.setAdapter(adapter);
    }

}

