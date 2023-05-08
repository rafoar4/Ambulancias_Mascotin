package com.example.ambulanciasmascotin.models;

public class Mascota {
    String nombre_mascota;
    String genero;
    String nombre_duenho;
    String DNI;
    String descripcion;

    String origen;
    String destino;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Mascota(){};

    public Mascota(String nombre_mascota, String genero, String nombre_duenho, String DNI, String descripcion, String origen,String destino) {
        this.nombre_mascota = nombre_mascota;
        this.genero = genero;
        this.nombre_duenho = nombre_duenho;
        this.DNI = DNI;
        this.descripcion = descripcion;
        this.origen = origen;
        this.destino = destino;

    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre_duenho() {
        return nombre_duenho;
    }

    public void setNombre_duenho(String nombre_duenho) {
        this.nombre_duenho = nombre_duenho;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
