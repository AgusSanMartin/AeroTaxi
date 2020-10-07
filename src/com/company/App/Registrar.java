package com.company.App;

import com.company.Domain.Fecha;
import com.company.MVC.Model;
import com.company.Model.Usuario;

import java.util.ArrayList;

public class Registrar extends Model {

    private ArrayList<String> userAregistrar;

    public Registrar() {
        this.userAregistrar = new ArrayList<>();
    }

    public ArrayList getUserAregistrar() { return userAregistrar; }

    public void agregarDato(String dato){
        userAregistrar.add(dato);
        changed();
    }
}
