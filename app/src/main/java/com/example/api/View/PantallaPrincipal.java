package com.example.api.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Model.AdapterHorizontal;
import com.example.api.Model.AdapterListGames;
import com.example.api.Model.CategoryAdapter;
import com.example.api.Presenter.Gamecontract;
import com.example.api.Presenter.PPrincipalP;
import com.example.api.Presenter.onClick;
import com.example.api.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PantallaPrincipal extends AppCompatActivity implements Gamecontract.View, onClick {

    private RecyclerView recyclerViewHorizontal;
    private RecyclerView recyclerViewVertical;
    private Button reintentar;
    private RecyclerView recyclerViewCategory;
    private List<ListGames> listaCompleta = new ArrayList<>();
    private List<ListGames> lista = new ArrayList<>();
    private AdapterListGames adapterListGames;
    private ImageView errorconexion;
    private Gamecontract.Presenter mPresenter;
    private AdapterHorizontal adapterHorizontal;
    private CategoryAdapter categoryAdapter;
    private ImageView busqueda;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        recyclerViewHorizontal = (RecyclerView) findViewById(R.id.listagameshorizontal);
        recyclerViewCategory = (RecyclerView) findViewById(R.id.generos);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewVertical = (RecyclerView) findViewById(R.id.listagames);
        reintentar= (Button) findViewById(R.id.reintentar);
        mPresenter = new PPrincipalP(this);
        ConnectivityManager connectivityManager = (ConnectivityManager) getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        errorconexion= findViewById(R.id.errorconexion);
        if (networkInfo!=null && networkInfo.isConnected()){
            errorconexion.setVisibility(View.INVISIBLE);
            reintentar.setVisibility(View.INVISIBLE);
            recyclerViewCategory.setVisibility(View.VISIBLE);
            init();
        }else {
            recyclerViewCategory.setVisibility(View.INVISIBLE);
            errorconexion.setVisibility(View.VISIBLE);
            reintentar.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Error de coneccion",Toast.LENGTH_LONG).show();
        }




        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerViewVertical = findViewById(R.id.listagames);
        recyclerViewVertical.setLayoutManager(new GridLayoutManager(this, 2));

        busqueda = findViewById(R.id.search);
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PantallaPrincipal.this, BusquedaGames.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getcategoria(List<categorias> categorias) {
        categoryAdapter = new CategoryAdapter(categorias, this, this);
        recyclerViewCategory.setAdapter(categoryAdapter);
    }

    @Override
    public void loadDataInList(List<ListGames> listGames) {
        listaCompleta = listGames;
        lista.clear();
        lista.addAll(listaCompleta);
        adapterListGames = new AdapterListGames(lista);
        recyclerViewVertical.setAdapter(adapterListGames);
        adapterListGames.notifyDataSetChanged();
    }

    @Override
    public void loadDataInListh(List<ListGames> usersh) {
        adapterHorizontal = new AdapterHorizontal(usersh);
        recyclerViewHorizontal.setAdapter(adapterHorizontal);
    }

    @Override
    public void onClickcategory(String categorias) {
        lista.clear();
        lista.addAll(listaCompleta.stream().filter(x -> x.getGenre().toLowerCase().contains(categorias.toLowerCase()))
                .collect(Collectors.toList()));

        adapterListGames.notifyDataSetChanged();
    }

    public void restart(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
