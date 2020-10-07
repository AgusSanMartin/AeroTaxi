package com.company.Controller;

import com.company.App.ContratarVuelo;
import com.company.MVC.Controller;
import com.company.Model.*;
import com.company.Domain.CapaDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContratarVueloController implements Controller {
    private List<Vuelo> vuelos = new ArrayList<>();
    private static final int ciudades[][] = {{0,0,650},{0,1,1400},{0,2,950},{1,0,1190},{1,1,1050},{3,0,2100}};
    private int origen;
    private int destino;
    private ContratarVuelo contratarVuelo;

    public ContratarVueloController(ContratarVuelo contratarVuelo) {
        this.contratarVuelo = contratarVuelo;
    }

    //en este punto debe seguirse una serie de pasos:
    //1 - elegir fecha
    //2 - se debe elegir origen, no hay aviones?
    //3 - elegir destino
    //4 - elegir si se viaja con acompañantes, excedistes?
    //5 - elegir aviones disponibles
    //6 - finalmente, mostrar y confirmar vuelo

    public boolean execute(String command) {
        LocalDate fechaElegida = LocalDate.parse(command, DateTimeFormatter.ofPattern("mm/dd/yyyy"));
        if(contratarVuelo.getFechaElegida()==null) {
            if (DateTimeFormatter.ofPattern("mm/dd/yyyy").equals(DateTimeFormatter.ofPattern(command))) {
                contratarVuelo.setFechaElegida(fechaElegida);
                return true;
            }
        }

        else if(contratarVuelo.getCiudadOrigen()==null){
            switch (command){
                case "1": contratarVuelo.setCiudadOrigen("Bs_As");
                break;

                case "2": contratarVuelo.setCiudadOrigen("Cordoba");
                break;

                case "3": contratarVuelo.setCiudadOrigen("Montevideo");
                break;

                case "4": contratarVuelo.setCiudadOrigen("Santiago");
                break;
            }
            return true;
        }

        else if(contratarVuelo.getCiudadDestino()==null){
            switch (command){
                case "1": contratarVuelo.setCiudadDestino("Bs_As");
                    break;

                case "2": contratarVuelo.setCiudadDestino("Cordoba");
                    break;

                case "3": contratarVuelo.setCiudadDestino("Montevideo");
                    break;

                case "4": contratarVuelo.setCiudadDestino("Santiago");
                    break;
            }
            return true;
        }

        else if(contratarVuelo.getAcompañantes()==0){
            int acompañantes = Integer.parseInt(command);
            contratarVuelo.setAcompañantes(acompañantes);
            return true;
        }

        else if(contratarVuelo.getAvionDisponible()==null){

        }



        return false;
    }

    public void add(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    }

    public double calcularCosto(Vuelo vuelo){
        //(Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo de avión)
        double costo_final = 1;
        double costo_km = 1;// costo por km del avion elegido
        double cant_km = 1;// km de distancia entre las ciudades
        double cant_pas = 1;// numero de viajeros
        double tarifa = 1;

        cant_pas = vuelo.calcularPasajeros();

        tarifa = descubrirTarifa(vuelo);

        costo_km = vuelo.getAvion().getCostoKM();

        cant_km = descubrirCiudadOrigenYDestino(vuelo);

        System.out.println("Costo por km: " + costo_km);
        System.out.println("Cantidad de km: " + cant_km);
        System.out.println("Cantidad de pasajeros: " + cant_pas);
        System.out.println("Tarifa: " + tarifa);

        costo_final = (cant_km * costo_km) + (cant_pas * 3500) + tarifa;

        return costo_final;
    }

    public double descubrirTarifa(Vuelo vuelo){
        double tarifa=2;

        if(vuelo.getAvion() instanceof Bronze){
            tarifa = 3000;
        }
        else if(vuelo.getAvion() instanceof Silver){
            tarifa = 4000;
        }
        else if(vuelo.getAvion() instanceof Gold){
            tarifa = 6000;
        }

        return tarifa;
    }

    public double descubrirCiudadOrigenYDestino(Vuelo vuelo){
        double cant_km=2;

        if(((vuelo.getCiudadOrigen() == Ciudad.Bs_As) && (vuelo.getCiudadDestino() == Ciudad.Cordoba)) || ((vuelo.getCiudadOrigen() == Ciudad.Cordoba) && (vuelo.getCiudadDestino() == Ciudad.Bs_As)))
            cant_km = 695;
        else if(((vuelo.getCiudadOrigen() == Ciudad.Bs_As) && (vuelo.getCiudadDestino() == Ciudad.Santiago)) || ((vuelo.getCiudadOrigen() == Ciudad.Santiago) && (vuelo.getCiudadDestino() == Ciudad.Bs_As)))
            cant_km = 1400;
        else if(((vuelo.getCiudadOrigen() == Ciudad.Bs_As) && (vuelo.getCiudadDestino() == Ciudad.Montevideo)) || ((vuelo.getCiudadOrigen() == Ciudad.Montevideo) && (vuelo.getCiudadDestino() == Ciudad.Bs_As)))
            cant_km = 950;
        else if(((vuelo.getCiudadOrigen() == Ciudad.Montevideo) && (vuelo.getCiudadDestino() == Ciudad.Cordoba)) || ((vuelo.getCiudadOrigen() == Ciudad.Cordoba) && (vuelo.getCiudadDestino() == Ciudad.Montevideo)))
            cant_km = 1190;
        else if(((vuelo.getCiudadOrigen() == Ciudad.Santiago) && (vuelo.getCiudadDestino() == Ciudad.Cordoba)) || ((vuelo.getCiudadOrigen() == Ciudad.Cordoba) && (vuelo.getCiudadDestino() == Ciudad.Santiago)))
            cant_km = 1050;
        else if(((vuelo.getCiudadOrigen() == Ciudad.Montevideo) && (vuelo.getCiudadDestino() == Ciudad.Santiago)) || ((vuelo.getCiudadOrigen() == Ciudad.Santiago) && (vuelo.getCiudadDestino() == Ciudad.Montevideo)))
            cant_km = 2100;

        return cant_km;
    }

    public List<Vuelo> on(LocalDate date) {
        return vuelos.stream()
                .filter(vuelo -> vuelo.isOn(date))
                .collect(Collectors.toList());
    }
}
