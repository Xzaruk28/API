package com.example.api.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Model.AdapterHorizontal;
import com.example.api.Model.AdapterListGames;
import com.example.api.Model.CategoryAdapter;
import com.example.api.Presenter.Gamecontract;
import com.example.api.Presenter.PPrincipalP;
import com.example.api.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaGames extends AppCompatActivity implements Gamecontract.View {

    private RecyclerView recyclerViewVerticalB;
    private AdapterListGames adapterListGames;
    private ImageView arrow;
    private TextView tv;
    private List<ListGames> listaCompleta = new ArrayList<>();
    private List<ListGames> lista = new ArrayList<>();
    private Gamecontract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_games);
        mPresenter = new PPrincipalP(this);
        init();
        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerViewVerticalB = (RecyclerView) findViewById(R.id.listagames2);
        recyclerViewVerticalB.setLayoutManager(new GridLayoutManager(this, 2));

        tv = (TextView) findViewById(R.id.filtro);
        tv.setOnKeyListener(new View.OnKeyListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                lista.clear();
                lista.addAll(listaCompleta.stream().filter(x -> x.getTitle().toLowerCase().contains(tv.getText().toString().toLowerCase()))
                        .collect(Collectors.toList()));

                adapterListGames.notifyDataSetChanged();
                return false;
            }
        });

        arrow = findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void getcategoria(List<categorias> categorias) {
    }

    @Override
    public void loadDataInList(List<ListGames> users) {
        listaCompleta = users;
        lista.clear();
        lista.addAll(listaCompleta);
        adapterListGames = new AdapterListGames(lista);
        recyclerViewVerticalB.setAdapter(adapterListGames);
    }

    @Override
    public void loadDataInListh(List<ListGames> usersh) {
    }
}