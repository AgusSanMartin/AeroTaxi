package com.company.Model;

public class Bronze extends Avion{

    public Bronze(int capacidadCombustible, int costoKM, int capacidadPasajeros, int velMax, int tarifa, Propulsion propulsion, boolean vueloProgramado) {
        this.setCapacidadCombustible(capacidadCombustible);
        this.setCostoKM(costoKM);
        this.setCapacidadPasajeros(capacidadPasajeros);
        this.setVelMax(velMax);
        this.setTarifa(tarifa);
        this.setPropulsion(propulsion);
        this.setVueloProgramado(vueloProgramado);
    }
}
