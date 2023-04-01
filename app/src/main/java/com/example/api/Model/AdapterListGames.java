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

import java.util.List;

public class AdapterListGames extends RecyclerView.Adapter<AdapterListGames.MYViewHolder> {

    private List<ListGames> listGames;
    private Context context;

    public AdapterListGames(List<ListGames> listGames) {
        this.listGames = listGames;
        this.context = context;
    }

    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games, parent, false);
        return new MYViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MYViewHolder holder, int position) {
        ListGames game = listGames.get(position);
        holder.title.setText(listGames.get(position).getTitle());
        Picasso.get().load(game.getThumbnail()).resize(350, 500).centerCrop().into(holder.foto);
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

    public class MYViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView foto;

        public MYViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tituloItem1);
            foto = (ImageView) itemView.findViewById(R.id.foto);

        }
    }
}

