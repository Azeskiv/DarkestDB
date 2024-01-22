package com.example.darkestdb;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonajesFragment extends Fragment {

    private DbManager dbManager;
    private PersonajeAdapter personajeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personajes, container, false);
        Log.d("Fragment", "PersonajesFragment onCreateView");
        // Configurar RecyclerView
        RecyclerView recyclerViewPersonajes = view.findViewById(R.id.recyclerViewPersonajes);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtener datos y configurar el adaptador
        dbManager = new DbManager(getContext());
        List<Personaje> personajes = dbManager.obtenerTodosLosPersonajes();
        personajeAdapter = new PersonajeAdapter(personajes);
        recyclerViewPersonajes.setAdapter(personajeAdapter);

        return view;
    }
}
