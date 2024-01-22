package com.example.darkestdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.darkestdb.Personaje;
import com.example.darkestdb.R;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    private List<Personaje> personajes;

    public PersonajeAdapter(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.bind(personaje);
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    public void clear() {
        personajes.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Personaje> newList) {
        personajes.addAll(newList);
        notifyDataSetChanged();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenView;  // Agrega ImageView para la imagen
        private TextView nombreTextView;
        private TextView tipoTextView;
        private TextView nivelTextView;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenView = itemView.findViewById(R.id.imagenView);  // Asigna el ImageView

            // Otros TextView
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            tipoTextView = itemView.findViewById(R.id.tipoTextView);
            nivelTextView = itemView.findViewById(R.id.nivelTextView);
        }

        public void bind(Personaje personaje) {
            // Cargar imagen con Glide
            Glide.with(itemView.getContext())
                    .load(personaje.getImagen())
                    .placeholder(R.drawable.carga)
                    .error(R.drawable.error)
                    .into(imagenView);

            // Otros campos del ViewHolder
            nombreTextView.setText(personaje.getNombre());
            tipoTextView.setText(personaje.getTipo());
            nivelTextView.setText("Nivel: " + personaje.getNivel());
        }
    }
}
