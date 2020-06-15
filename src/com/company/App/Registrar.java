package com.company.App;

import com.company.Domain.Fecha;
import com.company.MVC.Model;
import com.company.Model.Usuario;

import java.util.ArrayList;

public class Registrar extends Model {

    private ArrayList userAregistrar = new ArrayList();

    public Registrar() {

    }

    public ArrayList getUserAregistrar() { return userAregistrar; }

    public void setUserAregistrar(ArrayList userAregistrar) { this.userAregistrar = userAregistrar; }

    public void agregarDato(String dato){
        userAregistrar.add(dato);
        changed();
    }
}
