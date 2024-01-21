package com.example.darkestdb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbManager dbManager;
    private BottomNavigationView bottomNavigationView;

    private PersonajeAdapter personajeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewPersonajes = findViewById(R.id.recyclerViewPersonajes);
        recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(this));
        personajeAdapter = new PersonajeAdapter(new ArrayList<>());
        recyclerViewPersonajes.setAdapter(personajeAdapter);

        // Inicializa DbManager
        dbManager = new DbManager(this);

        // Operaciones de la base de datos en un hilo secundario
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                dbManager.agregarPersonaje("Personaje" + i, "Tipo" + i, i * 2, i * 100, "imagen" + i + ".jpg");
            }

            // Insertar 5 encuentros de ejemplo
            for (int i = 1; i <= 5; i++) {
                dbManager.agregarEncuentro(i, i + 2, "Personaje" + i, "Personaje" + (i + 5), i, i + 1);
            }

            // Actualizar la lista en el hilo principal
            runOnUiThread(() -> {
                List<Personaje> personajes = dbManager.obtenerTodosLosPersonajes();
                personajeAdapter.clear();
                personajeAdapter.addAll(personajes);
                personajeAdapter.notifyDataSetChanged();
            });
        }).start();

        // Configura el BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;
            switch (item.getItemId()) {
                case 1000014:
                    selectedFragment = new PersonajesFragment();
                    break;
                case 1000006:
                    selectedFragment = new EncuentrosFragment();
                    break;
                default:
                    return false;
            }
            loadFragment(selectedFragment);
            return true;
        });

        // Carga el fragmento inicial
        loadFragment(new PersonajesFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
