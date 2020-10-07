package com.company.App;

import com.company.MVC.Model;
import com.company.Model.Ciudad;
import com.company.Model.Usuario;
import com.company.Model.Vuelo;
import com.company.Model.Avion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratarVuelo extends Model{

    LocalDate fechaElegida;
    String ciudadOrigen;
    String ciudadDestino;
    int acompañantes;
    String avionDisponible;
    ArrayList<String> vueloAregistrar;
    String[] arrCiudad = {"Bs_As","Cordoba","Montevideo","Santiago"};//cada ciudad tiene 1 avion de cada clase para usarse cada dia.

    public ContratarVuelo() {
        this.fechaElegida=null;
        this.ciudadOrigen=null;
        this.ciudadDestino=null;
        this.acompañantes=0;
        this.avionDisponible=null;
        this.vueloAregistrar = new ArrayList<>();
    }
    public void setFechaElegida(LocalDate fechaElegida) {
        this.fechaElegida = fechaElegida;
        changed();
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
        changed();
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
        changed();
    }

    public void setAcompañantes(int acompañantes) {
        this.acompañantes = acompañantes;
        changed();
    }

    public void setAvionDisponible(String avionDisponible) {
        this.avionDisponible = avionDisponible;
        changed();
    }

    public ArrayList<String> getVueloAregistrar() {
        return vueloAregistrar;
    }

    public void setVueloAregistrar(ArrayList<String> vueloAregistrar) {
        this.vueloAregistrar = vueloAregistrar;
    }

    public String getAvionDisponible() {
        return avionDisponible;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public LocalDate getFechaElegida() {
        return fechaElegida;
    }

    public int getAcompañantes() {
        return acompañantes;
    }

}
