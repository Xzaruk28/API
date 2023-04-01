package com.example.api.Presenter;

import com.example.api.Listas.ListGames;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Game_api {

    @GET("games")
    Call<List<ListGames>> leerTodo();
}
