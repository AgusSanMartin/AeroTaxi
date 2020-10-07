package com.company.View;

import com.company.App.Admin;
import com.company.App.ContratarVuelo;
import com.company.Controller.AdminController;
import com.company.Controller.ContratarVueloController;
import com.company.MVC.View;
import com.company.Domain.CapaDatos;
import com.company.Model.Avion;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class ContratarVueloView implements View {

    Scanner sc = new Scanner(System.in);
    private ContratarVuelo contratarVuelo;
    private ContratarVueloController contratarVueloController;
    private static String titulo= "CONTRATAR VUELO";
    private static String op1= "Elegir fecha(ingresando dd/mm/aaaa) : ";
    private static String op2= "Elegir Ciudad Origen: 1.BS_As 2.Cordoba 3.Montevideo 4.Santiago ";
    private static String op3= "Elegir Ciudad Destino: 1.BS_As 2.Cordoba 3.Montevideo 4.Santiago ";
    private static String op4= "Cuantos acompañantes píensa llevar: ";
    private static String op5= "Elegir Avion Disponible: ";
    public ContratarVueloView(ContratarVuelo contratarVuelo, ContratarVueloController contratarVueloController) {
        this.contratarVuelo = contratarVuelo;
        this.contratarVueloController = contratarVueloController;
        contratarVuelo.addView(this);
    }

    public void modelChanged() {
        show();
    }

    public void show() {
        System.out.print(titulo + "\n\n");    //estos son todos los datos que se necesitan
        int con = show(contratarVuelo.getVueloAregistrar());
        contrato(con);

        //Preguntar si hay aviones disponibles, luego los que tienen mas capacidad de pasajeros que acompañantes. Luego mostrar los aviones disponibles.
        //en este punto debe seguirse una serie de pasos:
        //1 - elegir fecha
        //2 - se debe elegir origen
        //3 - elegir destino
        //4 - elegir si se viaja con acompañantes o no
        //5 - elegir aviones disponibles
        //6 - finalmente, mostrar y confirmar vuelo
    }

    private int show(ArrayList<String> vueloAregistrar) {
        for (String dato: vueloAregistrar) {
            System.out.printf(" %s", dato);
        }
        return vueloAregistrar.size();
    }


    public void contrato(int con){
        switch (con){
            case 0:
                ingresarFecha();
                break;
            case 1:
                ingresarOrigen();
                break;
            case 2:
                ingresarDestino();
                break;
            case 3:
                ingresarAcompañantes();
                break;
            case 4:
                ingresarAvion();
                break;
            default: break;
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public void ingresarFecha(){
        System.out.print(titulo + "\n\n" + op1);
        String fecha = sc.next();
        try{
            contratarVueloController.execute(fecha);
            System.out.println("Se ha ingresado la fecha.");
        }catch (Exception e){
            System.out.println("Has ingresado mal la fecha vuelve a intentarlo");
            contratarVuelo.setFechaElegida(null);
            ingresarFecha();
        }
    }

    public void ingresarOrigen(){
        System.out.println("\n\n" + op2);
        String origen = sc.next();
        try{
            contratarVueloController.execute(origen);
            System.out.println("Se ha ingresado la ciudad de origen.");
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }


    public void ingresarDestino(){
        System.out.println("\n\n" + op3);
        String destino = sc.next();
        try{
            contratarVueloController.execute(destino);
            System.out.println("Se ha ingresado la ciudad de destino.");
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        if(contratarVuelo.getCiudadOrigen().equals(contratarVuelo.getCiudadDestino())){
            contratarVuelo.setCiudadDestino(null);
            System.out.println("Pero ingresastes la misma ciudad que el origen");
            ingresarDestino();
        }
    }

    public void ingresarAcompañantes(){
        System.out.println("\n\n" + op4);
        String acompañante = sc.nextLine();
        if(isInteger(acompañante)) {
            try {
                contratarVueloController.execute(acompañante);
                System.out.println("Se han ingresado la cantidad de acompañantes.");
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }

    }

    public void ingresarAvion(){
     //   for (Avion avion : CapaDatos.getAvionList(String acompañante)) {
            // if(avion.getCapacidadPasajeros() >= acompañante){ //acompañante es un String
            // if(!avion.isOn()){
         //   System.out.println(avion.toString());
            // elige la clase del vuelo
            //}
            //}
       // }
    }


  /*  public void show(arreglo de ciudades){

    }
*/
    private void askForCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            do {
                command = scanner.nextLine();
            } while (!contratarVueloController.execute(command));
        }
    }

    public void mostrarCosto(){
        //System.out.println("El costo total de su vuelo es de $" + contratarVueloController.calcularCosto(vuelo));
    }

}
