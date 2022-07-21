package com.example.movieapi.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapi.Model.MovieModel;

import java.util.List;

public class MovieApiClient {

    private MutableLiveData<List<MovieModel>> mMovie;

    public static MovieApiClient instance;

    public static MovieApiClient getInstance(){
        if (instance == null){
            instance = new MovieApiClient();
        }
        return instance;
    }

    private MovieApiClient(){
        mMovie = new MutableLiveData<>();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return mMovie;
    }
}
