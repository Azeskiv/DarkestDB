package com.example.darkestdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbManager dbManager;
    private RecyclerView recyclerView;
    private PersonajeAdapter personajeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear instancia de DbManager
        dbManager = new DbManager(this);

        // Agregar más registros de ejemplo
        dbManager.agregarPersonaje("Alfonso", "Físico", 10, 100, "guerrero_image_url");
        dbManager.agregarPersonaje("Lorenzo", "Mágico", 8, 80, "mago_image_url");
        dbManager.agregarPersonaje("Pater", "Físico", 10, 100, "guerrero_image_url");
        dbManager.agregarPersonaje("Maker", "Mágico", 8, 80, "mago_image_url");
        dbManager.agregarPersonaje("Gamer", "Físico", 12, 150, "paladin_image_url");
        dbManager.agregarPersonaje("Katarina", "Mágico", 9, 90, "hechicera_image_url");
        dbManager.agregarPersonaje("Lee Sin", "Físico", 11, 120, "explorador_image_url");

        dbManager.agregarEncuentro(1, 1, "Alfonso", "Lorenzo", 2, 3);
        dbManager.agregarEncuentro(2, 1, "Pater", "Maker", 1, 1);
        dbManager.agregarEncuentro(3, 2, "Gamer", "Hechicera", 3, 2);
        dbManager.agregarEncuentro(4, 2, "Aventurero", "Lorenzo", 1, 4);

        // Configurar RecyclerView para personajes
        RecyclerView recyclerViewPersonajes = findViewById(R.id.recyclerViewPersonajes);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(this));
        List<Personaje> personajes = dbManager.obtenerTodosLosPersonajes();
        personajeAdapter = new PersonajeAdapter(personajes);
        recyclerViewPersonajes.setAdapter(personajeAdapter);

        // Configurar RecyclerView para encuentros
        RecyclerView recyclerViewEncuentros = findViewById(R.id.recyclerViewEncuentros);
        recyclerViewEncuentros.setLayoutManager(new LinearLayoutManager(this));
        List<Encuentro> encuentros = dbManager.obtenerTodosLosEncuentros();
        EncuentroAdapter encuentroAdapter = new EncuentroAdapter(encuentros);
        recyclerViewEncuentros.setAdapter(encuentroAdapter);

        // Después de agregar nuevos personajes o encuentros, para reflejar los cambios
        personajeAdapter.notifyDataSetChanged();
        encuentroAdapter.notifyDataSetChanged();
    }


}
