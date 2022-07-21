package com.example.movieapi.Utils;

import com.example.movieapi.Model.MovieModel;
import com.example.movieapi.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {


    //https://api.themoviedb.org/3/search/movie?api_key={api_key
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );


    //https://api.themoviedb.org/3/movie/550?api_key = 54wewe34
    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id")  int movie_id ,
            @Query("api_key") String api_key
    );
}
