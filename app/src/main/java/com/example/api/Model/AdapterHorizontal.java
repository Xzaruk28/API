package com.example.api.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.Listas.ListGames;
import com.example.api.R;
import com.example.api.View.Detalles;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class AdapterHorizontal extends RecyclerView.Adapter<AdapterHorizontal.MyViewHolder> {

    private List<ListGames> listGames;
    private Context context;

    public AdapterHorizontal(List<ListGames> listGames) {
        this.listGames = listGames;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHorizontal.MyViewHolder holder, int position) {

        ListGames game = listGames.get(position);
        holder.title.setText(listGames.get(position).getTitle());
        Picasso.get().load(game.getThumbnail()).resize(500, 300).centerCrop().into(holder.foto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Detalles.class);
                intent.putExtra("itemdetalle", game);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView foto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tituloHorizontal);
            foto = (ImageView) itemView.findViewById(R.id.fotoHorizontal);
        }
    }
}
