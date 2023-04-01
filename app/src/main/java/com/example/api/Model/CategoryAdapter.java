package com.example.api.Model;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.Listas.ListGames;
import com.example.api.Listas.categorias;
import com.example.api.Presenter.onClick;
import com.example.api.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<categorias> categoris;
    private List<ListGames> lista = new ArrayList<>();
    private List<ListGames> listaCompleta = new ArrayList<>();
    private Context context;
    private onClick listener;

    public CategoryAdapter(List<categorias> categoris,Context context,onClick listener ) {
        this.categoris = categoris;
        this.context = context;
        this.lista= lista;
        this.listaCompleta= lista;
        this.listener= listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcategoria,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      categorias categorias = categoris.get(position);
      holder.genero.setText(categorias.getGeneros());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.N)
          @Override
          public void onClick(View v) {
              listener.onClickcategory(categorias.getGeneros());
          }
      });
    }

    @Override
    public int getItemCount() {
        return categoris.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView genero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            genero = itemView.findViewById(R.id.categorias);
        }
    }
}
