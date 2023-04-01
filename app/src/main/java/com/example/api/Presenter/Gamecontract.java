package com.example.api.Presenter;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;

import java.util.List;

public interface Gamecontract {

    interface View {
        void init();

        void getcategoria(List<categorias> categorias);

        void loadDataInList(List<ListGames> users);

        void loadDataInListh(List<ListGames> usersh);
    }

    interface Presenter {

        void start();

        void guardcategoria(List<categorias> categorias);

        void loadgameH(List<ListGames> usersh);

        void loadgames(List<ListGames> users);
    }
}
