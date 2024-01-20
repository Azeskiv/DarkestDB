package com.example.darkestdb;

public class Encuentro {
    private long id;
    private int numero;
    private int semana;
    private String personaje1;
    private String personaje2;
    private int puntuacion1;
    private int puntuacion2;

    public Encuentro(long id, int numero, int semana, String personaje1, String personaje2, int puntuacion1, int puntuacion2) {
        this.id = id;
        this.numero = numero;
        this.semana = semana;
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        this.puntuacion1 = puntuacion1;
        this.puntuacion2 = puntuacion2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public String getPersonaje1() {
        return personaje1;
    }

    public void setPersonaje1(String personaje1) {
        this.personaje1 = personaje1;
    }

    public String getPersonaje2() {
        return personaje2;
    }

    public void setPersonaje2(String personaje2) {
        this.personaje2 = personaje2;
    }

    public int getPuntuacion1() {
        return puntuacion1;
    }

    public void setPuntuacion1(int puntuacion1) {
        this.puntuacion1 = puntuacion1;
    }

    public int getPuntuacion2() {
        return puntuacion2;
    }

    public void setPuntuacion2(int puntuacion2) {
        this.puntuacion2 = puntuacion2;
    }
}