package com.company.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class Vuelo implements Serializable {
    private LocalDateTime dateTime;
    private Usuario usuario;
    private int acompañantes;
    private Avion avion;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private float costo;

    public Vuelo(){}

    public Vuelo(LocalDateTime dateTime, Usuario usuario, int acompañantes, Avion avion, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.usuario = usuario;
        this.dateTime = dateTime;
        this.acompañantes = acompañantes;
        this.avion = avion;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        //this.costo = calcularCosto();
    }

    public float getCosto() {
        return costo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalTime getHora() {
        return dateTime.toLocalTime();
    }

    public String getUsuarioNombre() { return usuario.getNombre(); }

    public int getAcompañantes() {
        return acompañantes;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public Avion getAvion() {
        return avion;
    }

    public String getUser(){
        return this.getUsuario().getUser();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isOn(LocalDate date) {
        return dateTime.toLocalDate().equals(date);
    }

    public int calcularPasajeros(){
        int pasaj = getAcompañantes() + 1; // La suma del ingreso de acompañantes que el usuario señalo y este mismo.
        return pasaj;
    }
}
