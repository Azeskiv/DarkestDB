package com.example.darkestdb;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura el BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;
            switch (item.getTitle().toString()) {
                case "Personajes":
                    selectedFragment = new PersonajesFragment();
                    break;
                case "Encuentros":
                    selectedFragment = new EncuentrosFragment();
                    break;
                default:
                    return false;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
            return true;
        });

        // Carga el fragmento inicial
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PersonajesFragment()).commit();
    }
}
