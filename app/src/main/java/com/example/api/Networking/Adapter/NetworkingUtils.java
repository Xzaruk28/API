package com.example.api.Networking.Adapter;

import com.example.api.Presenter.Game_api;

public class NetworkingUtils {

    private static Game_api game_api;

    public static Game_api leerTodoAPIInstance() {
        if (game_api == null)
            game_api = RetrofitAdapter.getInterface().create(Game_api.class);

        return game_api;
    }
}
