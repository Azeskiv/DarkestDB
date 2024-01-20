package com.example.darkestdb;

import android.provider.BaseColumns;

public final class Contract {

    private Contract() {}

    public static class PersonajeEntry implements BaseColumns {
        public static final String TABLE_NAME = "personajes";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_TIPO = "tipo";
        public static final String COLUMN_NIVEL = "nivel";
        public static final String COLUMN_EXP = "experiencia";
        public static final String COLUMN_IMAGEN = "imagen_url";
    }

    public static class EncuentroEntry implements BaseColumns {
        public static final String TABLE_NAME = "encuentros";
        public static final String COLUMN_NUMERO = "numero";
        public static final String COLUMN_SEMANA = "semana";
        public static final String COLUMN_PERSONAJE1 = "personaje1";
        public static final String COLUMN_PERSONAJE2 = "personaje2";
        public static final String COLUMN_PUNTUACION_PERSONAJE1 = "puntuacion_personaje1";
        public static final String COLUMN_PUNTUACION_PERSONAJE2 = "puntuacion_personaje2";
    }
}
