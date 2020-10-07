package com.company.Domain;

import com.company.Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.Model.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import static com.company.App.Main.*;

import static com.company.App.Main.*;

public class CapaDatos {

    static public List<Usuario> usersList = new ArrayList<>();
    static public List<Vuelo> vuelosList = new ArrayList<>();
    static public List<Gold> avionGoldList = new ArrayList<>();
    static public List<Silver> avionSilverList = new ArrayList<>();
    static public List<Bronze> avionBronzeList = new ArrayList<>();


    //-----------funciones para subir y bajar del archivo

    //users
    public static void uploadUsers() {
        try {
            File file = new File(PATH_USUARIOS);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, usersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadUsers() {
        try
        {
            File file = new File(PATH_USUARIOS);
            ObjectMapper mapper = new ObjectMapper();
            Usuario[] users = mapper.readValue(file, Usuario[].class);
            List<Usuario> listUsuario = new ArrayList();
            for(Usuario user:users) {
                listUsuario.add(user);
            }

            CapaDatos.setUsersList(listUsuario);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void agregarUsuario(Usuario user){
        usersList.add(user);
    }

    //vuelos
    public static void uploadVuelos() {
        try {
            File file = new File(PATH_VUELOS);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, vuelosList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadVuelos() {
        try
        {
            File file = new File(PATH_VUELOS);
            ObjectMapper mapper = new ObjectMapper();
            Vuelo[] vuelos = mapper.readValue(file, Vuelo[].class);
            List<Vuelo> listVuelos = new ArrayList();
            for(Vuelo vuelo:vuelos) {
                listVuelos.add(vuelo);

            }
            CapaDatos.setVuelosList(listVuelos);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void agregarVuelo(Vuelo vuelo){
        vuelosList.add(vuelo);
    }

    //aviones gold
    public static void uploadAvionesGold() {
        try {
            File file = new File(PATH_AVIONES_GOLD);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, avionGoldList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadAvionesGold() {
        try
        {
            File file = new File(PATH_AVIONES_GOLD);
            ObjectMapper mapper = new ObjectMapper();
            Gold[] avionesGold = mapper.readValue(file, Gold[].class);
            List<Gold> golds = new ArrayList();
            for(Gold avion:avionesGold) {
                golds.add(avion);
            }
            CapaDatos.setAvionGoldList(golds);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void agregarAvionGold(Gold goldAvion){
        avionGoldList.add(goldAvion);
    }

    //aviones silver
    public static void uploadAvionesSilver() {
        try {
            File file = new File(PATH_AVIONES_SILVER);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, avionSilverList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadAvionesSilver() {
        try
        {
            File file = new File(PATH_AVIONES_SILVER);
            ObjectMapper mapper = new ObjectMapper();
            Silver[] avionesSilver = mapper.readValue(file, Silver[].class);
            List<Silver> silvers = new ArrayList();
            for(Silver avion:avionesSilver) {
                silvers.add(avion);
            }
            CapaDatos.setAvionSilverList(silvers);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void agregarAvionSilver(Silver silverAvion){
        avionSilverList.add(silverAvion);
    }

    //aviones bronze
    public static void uploadAvionesBronze() {
        try {
            File file = new File(PATH_AVIONES_BRONZE);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, avionBronzeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadAvionesBronze() {
        try
        {
            File file = new File(PATH_AVIONES_BRONZE);
            ObjectMapper mapper = new ObjectMapper();
            Bronze[] avionesBronze = mapper.readValue(file, Bronze[].class);
            List<Bronze> bronzes = new ArrayList();
            for(Bronze avion:avionesBronze) {
                bronzes.add(avion);

            }
            CapaDatos.setAvionBronzeList(bronzes);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void agregarAvionBronze(Bronze bronzeAvion){
        avionBronzeList.add(bronzeAvion);
    }




    //---------------GETTERS Y SETTERS

    //g y s de silver

    public static List<Silver> getAvionSilverList() {
        return avionSilverList;
    }

    public static void setAvionSilverList(List<Silver> avionSilverList) {
        CapaDatos.avionSilverList = avionSilverList;
    }

    //g y s de bronze

    public static List<Bronze> getAvionBronzeList() {
        return avionBronzeList;
    }

    public static void setAvionBronzeList(List<Bronze> avionBronzeList) {
        CapaDatos.avionBronzeList = avionBronzeList;
    }

    //g y s de gold

    public static void setAvionGoldList(List<Gold> avionGoldList) {
        CapaDatos.avionGoldList = avionGoldList;
    }

    public static List<Gold> getAvionGoldList() {
        return avionGoldList;
    }

    //g y s de users

    public static List<Usuario> getUsersList() {
        return usersList;
    }

    public static void  setUsersList(List<Usuario> usersList) { CapaDatos.usersList = usersList; }

    //g y s de vuelos

    public static List<Vuelo> getVuelosList() {
        return vuelosList;
    }

    public static void setVuelosList(List<Vuelo> vuelosList) { CapaDatos.vuelosList = vuelosList; }













}
