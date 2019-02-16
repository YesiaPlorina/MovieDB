package com.example.teravinmovie;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.teravinmovie.adapter.AdapterMovie;
import com.example.teravinmovie.model.DataItem;
import com.example.teravinmovie.model.ResponseFilm;
import com.example.teravinmovie.model.ResponseMovie;
import com.example.teravinmovie.model.ResultsItem;
import com.example.teravinmovie.network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe);

        sendRequest();

        swipeRefreshLayout.setColorScheme(
                android.R.color.holo_blue_bright);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        sendRequest();
                    }
                },3000);
            }
        });
    }


    private void sendRequest() {

        ConfigRetrofit.getInstanc().getDataMovie().enqueue(new Callback<ResponseFilm>() {
            @Override
            public void onResponse(Call<ResponseFilm> call, Response<ResponseFilm> response) {
                if (response!= null){
                    List<DataItem>ListDataMovie= response.body().getData();
                    setUpListMovie(ListDataMovie);
                }
            }

            @Override
            public void onFailure(Call<ResponseFilm> call, Throwable t) {

            }
        });



    }

    private void setUpListMovie(List<DataItem> listDataMovie) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        AdapterMovie adapterMovie = new AdapterMovie(this, listDataMovie);
        recyclerView.setAdapter(adapterMovie);
    }
}

