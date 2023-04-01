package com.example.api.Presenter;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Model.PPrincimalMinterface;
import com.example.api.Model.PPrincipalM;

import java.util.List;

public class PPrincipalP implements Gamecontract.Presenter {

    private PPrincimalMinterface model;
    private Gamecontract.View view;

    public PPrincipalP(Gamecontract.View view) {
        this.view = view;
        model = new PPrincipalM(this);
    }

    @Override
    public void start() {
        model.getGames();
        model.getGeneror();
    }

    @Override
    public void guardcategoria(List<categorias> categorias) {
        view.getcategoria(categorias);
    }

    @Override
    public void loadgameH(List<ListGames> usersh) {
        view.loadDataInListh(usersh);
    }

    @Override
    public void loadgames(List<ListGames> users) {
        view.loadDataInList(users);
    }
}
