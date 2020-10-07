package com.company.Model;
import java.io.Serializable;

import java.io.Serializable;

public abstract class Avion implements Serializable {

    private int capacidadCombustible;
    private int costoKM;
    private int capacidadPasajeros;
    private int velMax;
    Propulsion propulsion;
    protected String type;

    public String getType() {
        return type;
    }

    public int getCapacidadCombustible() { return capacidadCombustible; }

    public void setCapacidadCombustible(int capacidadCombustible) { this.capacidadCombustible = capacidadCombustible; }

    public int getCostoKM() { return costoKM; }

    public void setCostoKM(int costoKM) { this.costoKM = costoKM; }

    public int getCapacidadPasajeros() { return capacidadPasajeros; }

    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }

    public int getVelMax() { return velMax; }

    public void setVelMax(int velMax) { this.velMax = velMax; }

    public Propulsion getPropulsion() { return propulsion; }

    public void setPropulsion(Propulsion propulsion) { this.propulsion = propulsion; }

    @Override
    public String toString() {
        return "Este avion tiene una capacidad de " + capacidadPasajeros + ", una velocidad maxima de " + velMax + "km por hora y una cantidad de " + capacidadCombustible + " combustible. Su categoria es: ";
    }
}
