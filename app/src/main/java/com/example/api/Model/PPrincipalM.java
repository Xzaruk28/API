package com.example.api.Model;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Networking.Adapter.NetworkingUtils;
import com.example.api.Presenter.Gamecontract;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Response;

public class PPrincipalM implements PPrincimalMinterface {

    private Gamecontract.Presenter presenter;
    private List<categorias> categoriasList;
    private List<ListGames> listaCompleta = new ArrayList<>();
    private List<ListGames> lista;
    private AdapterListGames adapterListGames;

    public PPrincipalM(Gamecontract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getGames() {

        NetworkingUtils.leerTodoAPIInstance()
                .leerTodo()
                .enqueue(new retrofit2.Callback<List<ListGames>>() {
                    @Override
                    public void onResponse(Call<List<ListGames>> call, Response<List<ListGames>> response) {
                        presenter.loadgames(response.body());
                        presenter.loadgameH(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<ListGames>> call, Throwable t) {
                        System.out.println();
                    }
                });
    }

    @Override
    public void getGeneror() {
        categoriasList = new ArrayList<>();
        categoriasList.add(new categorias("MMORPG"));
        categoriasList.add(new categorias("Shooter"));
        categoriasList.add(new categorias("Strategy"));
        categoriasList.add(new categorias("MOBA"));
        categoriasList.add(new categorias("Card Game"));
        categoriasList.add(new categorias("Fighting"));
        categoriasList.add(new categorias("Social"));
        categoriasList.add(new categorias("MMO"));
        categoriasList.add(new categorias("Sports"));
        categoriasList.add(new categorias("ARPG"));
        categoriasList.add(new categorias("Action RPG"));
        categoriasList.add(new categorias("Battle Royale"));
        categoriasList.add(new categorias("MMOFPS"));
        presenter.guardcategoria(categoriasList);
    }
}
