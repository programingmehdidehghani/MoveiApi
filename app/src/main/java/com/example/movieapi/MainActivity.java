package com.example.movieapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.movieapi.Model.MovieModel;
import com.example.movieapi.Utils.Credentials;
import com.example.movieapi.Utils.MovieApi;
import com.example.movieapi.request.Servicey;
import com.example.movieapi.response.MovieSearchResponse;
import com.example.movieapi.viewModel.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    public MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.main_avtivity_btn);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {

            }
        });
    }

    private void GetRetrofitResponse() {
        MovieApi movieApi = Servicey.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Jack Reacher",
                        "1"
                );

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200){
                    Log.v("Tag","the response" + response.body().toString());
                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for (MovieModel movie : movies){
                        Log.v("Tag","the release date" + movie.getRelease_date());
                    }
                }
                else {
                    try {
                        Log.v("Tag","Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void GetRetrofitResponseAccordingToID(){
        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieModel> responseCall = movieApi.getMovie(
                550 ,
                Credentials.API_KEY
        );

        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.code() == 200){
                    MovieModel movie = response.body();
                    Log.v("Tag","The response" + movie.getTitle());
                }
                else {
                    try {
                        Log.v("Tag","Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}