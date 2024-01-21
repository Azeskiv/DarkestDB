package com.example.darkestdb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EncuentrosFragment extends Fragment {

    private DbManager dbManager;
    private EncuentroAdapter encuentroAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encuentros, container, false);

        // Configurar RecyclerView
        RecyclerView recyclerViewEncuentros = view.findViewById(R.id.recyclerViewEncuentros);
        recyclerViewEncuentros.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obtener datos y configurar el adaptador
        dbManager = new DbManager(getContext());
        List<Encuentro> encuentros = dbManager.obtenerTodosLosEncuentros();
        encuentroAdapter = new EncuentroAdapter(encuentros);
        recyclerViewEncuentros.setAdapter(encuentroAdapter);

        return view;
    }
}
