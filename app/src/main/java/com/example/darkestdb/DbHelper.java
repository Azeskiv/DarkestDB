package com.example.darkestdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mi_base_datos.db";
    private static final int DATABASE_VERSION = 1;

    // Sentencias SQL para crear las tablas
    private static final String SQL_CREATE_PERSONAJES =
            "CREATE TABLE " + Contract.PersonajeEntry.TABLE_NAME + " (" +
                    Contract.PersonajeEntry._ID + " INTEGER PRIMARY KEY," +
                    Contract.PersonajeEntry.COLUMN_NOMBRE + " TEXT," +
                    Contract.PersonajeEntry.COLUMN_TIPO + " TEXT," +
                    Contract.PersonajeEntry.COLUMN_NIVEL + " INTEGER," +
                    Contract.PersonajeEntry.COLUMN_EXP + " INTEGER," +
                    Contract.PersonajeEntry.COLUMN_IMAGEN + " TEXT)";

    private static final String SQL_CREATE_ENCUENTROS =
            "CREATE TABLE " + Contract.EncuentroEntry.TABLE_NAME + " (" +
                    Contract.EncuentroEntry._ID + " INTEGER PRIMARY KEY," +
                    Contract.EncuentroEntry.COLUMN_NUMERO + " INTEGER," +
                    Contract.EncuentroEntry.COLUMN_SEMANA + " INTEGER," +
                    Contract.EncuentroEntry.COLUMN_PERSONAJE1 + " TEXT," +
                    Contract.EncuentroEntry.COLUMN_PERSONAJE2 + " TEXT," +
                    Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1 + " INTEGER," +
                    Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2 + " INTEGER)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PERSONAJES);
        db.execSQL(SQL_CREATE_ENCUENTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Manejo de actualizaciones de la base de datos (no necesario para este ejemplo)
    }
}
