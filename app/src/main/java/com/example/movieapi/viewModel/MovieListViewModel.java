package com.example.movieapi.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapi.Model.MovieModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> mMovie = new MutableLiveData<>();

    public MovieListViewModel() {
    }

    public LiveData<List<MovieModel>> getMovies(){
        return mMovie;
    }

}
