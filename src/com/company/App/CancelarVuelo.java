package com.company.App;

import com.company.MVC.Model;
import com.company.Model.Vuelo;

import java.util.ArrayList;

public class CancelarVuelo extends Model {


    ArrayList<String> vuelo;

    public CancelarVuelo() {
        this.vuelo = new ArrayList<>();
    }

    public ArrayList<String> getVuelo() {
        return vuelo;
    }
}
