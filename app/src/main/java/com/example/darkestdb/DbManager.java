package com.example.darkestdb;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private DbHelper dbHelper;

    public DbManager(Context context) {
        dbHelper = new DbHelper(context);
    }

    // Métodos CRUD para Personajes

    public long agregarPersonaje(String nombre, String tipo, int nivel, int experiencia, String imagen) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.PersonajeEntry.COLUMN_NOMBRE, nombre);
        values.put(Contract.PersonajeEntry.COLUMN_TIPO, tipo);
        values.put(Contract.PersonajeEntry.COLUMN_NIVEL, nivel);
        values.put(Contract.PersonajeEntry.COLUMN_EXP, experiencia);
        values.put(Contract.PersonajeEntry.COLUMN_IMAGEN, imagen);

        long newRowId = db.insert(Contract.PersonajeEntry.TABLE_NAME, null, values);

        db.close();

        return newRowId;
    }

    public List<Personaje> obtenerTodosLosPersonajes() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.PersonajeEntry._ID,
                Contract.PersonajeEntry.COLUMN_NOMBRE,
                Contract.PersonajeEntry.COLUMN_TIPO,
                Contract.PersonajeEntry.COLUMN_NIVEL,
                Contract.PersonajeEntry.COLUMN_EXP,
                Contract.PersonajeEntry.COLUMN_IMAGEN
        };

        Cursor cursor = db.query(
                Contract.PersonajeEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<Personaje> personajes = new ArrayList<>();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry._ID));
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_NOMBRE));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_TIPO));
            int nivel = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_NIVEL));
            int exp = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_EXP));
            String imagen = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_IMAGEN));

            Personaje personaje = new Personaje(id, nombre, tipo, nivel, exp, imagen);
            personajes.add(personaje);
        }

        cursor.close();
        db.close();

        return personajes;
    }

    // Métodos CRUD para Encuentros

    public long agregarEncuentro(int numero, int semana, String personaje1, String personaje2, int puntuacion1, int puntuacion2) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.EncuentroEntry.COLUMN_NUMERO, numero);
        values.put(Contract.EncuentroEntry.COLUMN_SEMANA, semana);
        values.put(Contract.EncuentroEntry.COLUMN_PERSONAJE1, personaje1);
        values.put(Contract.EncuentroEntry.COLUMN_PERSONAJE2, personaje2);
        values.put(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1, puntuacion1);
        values.put(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2, puntuacion2);

        long newRowId = db.insert(Contract.EncuentroEntry.TABLE_NAME, null, values);

        db.close();

        return newRowId;
    }

    public List<Encuentro> obtenerTodosLosEncuentros() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.EncuentroEntry._ID,
                Contract.EncuentroEntry.COLUMN_NUMERO,
                Contract.EncuentroEntry.COLUMN_SEMANA,
                Contract.EncuentroEntry.COLUMN_PERSONAJE1,
                Contract.EncuentroEntry.COLUMN_PERSONAJE2,
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1,
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2
        };

        Cursor cursor = db.query(
                Contract.EncuentroEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<Encuentro> encuentros = new ArrayList<>();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry._ID));
            int numero = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_NUMERO));
            int semanaEncuentro = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_SEMANA));
            String personaje1 = cursor.getString(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PERSONAJE1));
            String personaje2 = cursor.getString(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PERSONAJE2));
            int puntuacion1 = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1));
            int puntuacion2 = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2));

            Encuentro encuentro = new Encuentro(id, numero, semanaEncuentro, personaje1, personaje2, puntuacion1, puntuacion2);
            encuentros.add(encuentro);
        }

        cursor.close();
        db.close();

        return encuentros;
    }

    // Métodos adicionales

    public Personaje obtenerPersonajePorId(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.PersonajeEntry._ID,
                Contract.PersonajeEntry.COLUMN_NOMBRE,
                Contract.PersonajeEntry.COLUMN_TIPO,
                Contract.PersonajeEntry.COLUMN_NIVEL,
                Contract.PersonajeEntry.COLUMN_EXP,
                Contract.PersonajeEntry.COLUMN_IMAGEN
        };

        String selection = Contract.PersonajeEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query(
                Contract.PersonajeEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        Personaje personaje = null;

        if (cursor.moveToFirst()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_NOMBRE));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_TIPO));
            int nivel = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_NIVEL));
            int exp = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_EXP));
            String imagen = cursor.getString(cursor.getColumnIndexOrThrow(Contract.PersonajeEntry.COLUMN_IMAGEN));

            personaje = new Personaje(id, nombre, tipo, nivel, exp, imagen);
        }

        cursor.close();
        db.close();

        return personaje;
    }

    public int actualizarDatosPersonaje(long id, String nuevoNombre, String nuevoTipo, int nuevoNivel, int nuevaExp, String nuevaImagen) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.PersonajeEntry.COLUMN_NOMBRE, nuevoNombre);
        values.put(Contract.PersonajeEntry.COLUMN_TIPO, nuevoTipo);
        values.put(Contract.PersonajeEntry.COLUMN_NIVEL, nuevoNivel);
        values.put(Contract.PersonajeEntry.COLUMN_EXP, nuevaExp);
        values.put(Contract.PersonajeEntry.COLUMN_IMAGEN, nuevaImagen);

        String selection = Contract.PersonajeEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        int count = db.update(
                Contract.PersonajeEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        db.close();

        return count;
    }

    public int eliminarEncuentroPorId(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = Contract.EncuentroEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        int count = db.delete(
                Contract.EncuentroEntry.TABLE_NAME,
                selection,
                selectionArgs);

        db.close();

        return count;
    }

    public List<Encuentro> obtenerEncuentrosPorSemana(int semana) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.EncuentroEntry._ID,
                Contract.EncuentroEntry.COLUMN_NUMERO,
                Contract.EncuentroEntry.COLUMN_SEMANA,
                Contract.EncuentroEntry.COLUMN_PERSONAJE1,
                Contract.EncuentroEntry.COLUMN_PERSONAJE2,
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1,
                Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2
        };

        String selection = Contract.EncuentroEntry.COLUMN_SEMANA + " = ?";
        String[] selectionArgs = { String.valueOf(semana) };

        Cursor cursor = db.query(
                Contract.EncuentroEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        List<Encuentro> encuentros = new ArrayList<>();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry._ID));
            int numero = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_NUMERO));
            int semanaEncuentro = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_SEMANA));
            String personaje1 = cursor.getString(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PERSONAJE1));
            String personaje2 = cursor.getString(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PERSONAJE2));
            int puntuacion1 = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE1));
            int puntuacion2 = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.EncuentroEntry.COLUMN_PUNTUACION_PERSONAJE2));

            Encuentro encuentro = new Encuentro(id, numero, semanaEncuentro, personaje1, personaje2, puntuacion1, puntuacion2);
            encuentros.add(encuentro);
        }

        cursor.close();
        db.close();

        return encuentros;
    }





}

