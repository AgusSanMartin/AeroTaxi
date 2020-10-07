package com.company.Model;
import java.io.Serializable;

import java.io.Serializable;

public class Bronze extends Avion implements Serializable {

    public Bronze(){}

    public Bronze(int capacidadCombustible, int costoKM, int capacidadPasajeros, int velMax, Propulsion propulsion) {
        this.setCapacidadCombustible(capacidadCombustible);
        this.setCostoKM(costoKM);
        this.setCapacidadPasajeros(capacidadPasajeros);
        this.setVelMax(velMax);
        this.setPropulsion(propulsion);
        this.type = "Bronze";
    }

    @Override
    public String toString() {
        return super.toString() + "Bronce";
    }

}
