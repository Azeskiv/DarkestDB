package com.example.darkestdb;

public class Personaje {

        private long id;
        private String nombre;
        private String tipo;
        private int nivel;
        private int experiencia;
        private String imagen;

        public Personaje(long id, String nombre, String tipo, int nivel, int experiencia, String imagen) {
            this.id = id;
            this.nombre = nombre;
            this.tipo = tipo;
            this.nivel = nivel;
            this.experiencia = experiencia;
            this.imagen = imagen;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}



