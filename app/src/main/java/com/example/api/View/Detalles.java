package com.example.api.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Presenter.Gamecontract;
import com.example.api.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Detalles extends AppCompatActivity {

    private ImageView fotoDetalles;
    private ImageView arrow;
    private TextView tituloDetalle;
    private TextView descripcionDetalle;
    private TextView categoryDetalle;
    private TextView plataformDetalle;
    private com.example.api.Listas.ListGames gamedto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        initViews();
        initValues();
    }

    public void initViews() {
        fotoDetalles = findViewById(R.id.imagenDetalle);
        tituloDetalle = findViewById(R.id.titulo);
        arrow= findViewById(R.id.arrow);
        descripcionDetalle = findViewById(R.id.plataforma);
        categoryDetalle = findViewById(R.id.categoria);
        plataformDetalle = findViewById(R.id.descripcion2);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void initValues() {
        gamedto = (com.example.api.Listas.ListGames) getIntent().getExtras().getSerializable("itemdetalle");
        tituloDetalle.setText(gamedto.getTitle());
        descripcionDetalle.setText(gamedto.getPlatform());
        categoryDetalle.setText(gamedto.getGenre());
        plataformDetalle.setText(gamedto.getShort_description());
        Picasso.get().load(gamedto.getThumbnail()).resize(650, 400).centerCrop().into(fotoDetalles);
    }
}