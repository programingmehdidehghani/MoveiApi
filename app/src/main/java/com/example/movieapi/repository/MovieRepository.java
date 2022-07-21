package com.example.movieapi.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapi.Model.MovieModel;
import com.example.movieapi.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    public static MovieRepository instance;

    private MovieApiClient movieApiClient;


    public static MovieRepository getInstance(){
        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
          movieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieApiClient.getMovies();
    }
}
