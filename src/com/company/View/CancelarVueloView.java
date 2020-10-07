package com.company.View;

import com.company.App.Admin;
import com.company.App.CancelarVuelo;
import com.company.Controller.AdminController;
import com.company.Controller.CancelarVueloController;
import com.company.MVC.View;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class CancelarVueloView implements View {

    private CancelarVuelo cancelarVuelo;
    private CancelarVueloController cancelarVueloController;
    private static String titulo= "CANCELAR VUELO";
    //private static String op1= "Administración de Aviones"
    //private static String op2= "Salidas del Sistema ";
    public CancelarVueloView(CancelarVuelo cancelarVuelo, CancelarVueloController cancelarVueloController) {
        this.cancelarVuelo = cancelarVuelo;
        this.cancelarVueloController = cancelarVueloController;
        cancelarVuelo.addView(this);
    }

    public void modelChanged() {
        show();
    }

    public void show() {
        System.out.print(titulo + "\n\n");    //estos son todos los datos que se necesitan
        int canc = show(cancelarVuelo.getVuelo());
        cancelo(canc);

    }

    private int show(ArrayList<String> vuelo) {
        for (String dato: vuelo) {
            System.out.printf(" %s", dato);
        }
        return vuelo.size();
    }

    public void cancelo(int canc){

    }


}
