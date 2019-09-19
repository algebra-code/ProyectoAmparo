package com.amparo.films.retrofit;

import com.amparo.films.model.FilmGhibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {

    @GET("films/")
    Call<List<FilmGhibli>> getFilmGhibli();
}
