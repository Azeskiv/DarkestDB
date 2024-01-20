package com.example.darkestdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EncuentroAdapter extends RecyclerView.Adapter<EncuentroAdapter.EncuentroViewHolder> {

    private List<Encuentro> encuentros;

    public EncuentroAdapter(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }

    @NonNull
    @Override
    public EncuentroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_encuentro, parent, false);
        return new EncuentroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EncuentroViewHolder holder, int position) {
        Encuentro encuentro = encuentros.get(position);
        holder.bind(encuentro);
    }

    @Override
    public int getItemCount() {
        return encuentros.size();
    }

    public static class EncuentroViewHolder extends RecyclerView.ViewHolder {

        private TextView numeroTextView;
        private TextView semanaTextView;
        private TextView personaje1TextView;
        private TextView personaje2TextView;
        private TextView puntuacion1TextView;
        private TextView puntuacion2TextView;

        public EncuentroViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroTextView = itemView.findViewById(R.id.numeroTextView);
            semanaTextView = itemView.findViewById(R.id.semanaTextView);
            personaje1TextView = itemView.findViewById(R.id.personaje1TextView);
            personaje2TextView = itemView.findViewById(R.id.personaje2TextView);
            puntuacion1TextView = itemView.findViewById(R.id.puntuacion1TextView);
            puntuacion2TextView = itemView.findViewById(R.id.puntuacion2TextView);
        }

        public void bind(Encuentro encuentro) {
            numeroTextView.setText("Encuentro #" + encuentro.getNumero());
            semanaTextView.setText("Semana: " + encuentro.getSemana());
            personaje1TextView.setText("Personaje 1: " + encuentro.getPersonaje1());
            personaje2TextView.setText("Personaje 2: " + encuentro.getPersonaje2());
            puntuacion1TextView.setText("Puntuación 1: " + encuentro.getPuntuacion1());
            puntuacion2TextView.setText("Puntuación 2: " + encuentro.getPuntuacion2());
        }
    }
}
