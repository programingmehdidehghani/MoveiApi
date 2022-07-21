package com.example.movieapi.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapi.Model.MovieModel;

import java.util.List;

public class MovieRepository {

    public static MovieRepository instance;

    private MutableLiveData<List<MovieModel>> mMovie;

    public static MovieRepository getInstance(){
        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
          mMovie = new MutableLiveData<>();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return mMovie;
    }
}
