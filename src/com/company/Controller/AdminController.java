package com.company.Controller;

import com.company.App.Admin;

import com.company.Domain.CapaDatos;
import com.company.MVC.Controller;
import com.company.Model.Usuario;
import com.company.Model.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminController implements Controller {

    private final Admin admin;

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    public boolean execute(String command) {
        switch (command){
            case "1":
                //lista de todos los vuelos programados para una fecha dada

                LocalDate fecha = ingresarFecha();              //la fecha en la que se deben listar los vuelos
                CapaDatos.downloadVuelos();                     //se trae la lista de vuelos guardada
                List<Vuelo> vuelos = CapaDatos.getVuelosList();

                        //aqui se devuelve una lista con todos los vuelos de la lista principal en la fecha seleccionada
                //y se almacena en la lista vuelosEnFecha
                List<Vuelo> vuelosEnFecha = vuelos.stream()
                                            .filter(vuelo -> vuelo.isOn(fecha))
                                            .collect(Collectors.toList());

                //luego se muestra un mensaje de que no hay vuelos o se muestran los vuelos
                mostrarVuelosEnFecha(vuelosEnFecha, fecha);
                return true;
                //break?

            case "2":
                //lista de clientes, indicando datos personales, categoría más alta de vuelo contratada
                // y total de gastos en vuelos

                /*si se muestran todos los clientes ordenados por apellido habría que ordenarlos quizá
                antes de subirlos a la lista. Si se los muestra ordenados por id, directamente se los lee
                como están en la lista*/
                CapaDatos.downloadUsers();
                List<Usuario> clientes = CapaDatos.getUsersList();



                //sort'em?

                mostrarDatosDeClientes(clientes);


                return true;

            default: break;
        }
        return false;
    }

    public LocalDate ingresarFecha(){
        LocalDate fecha = null;

        Scanner sc = new Scanner(System.in);

        System.out.print("\ningrese año (aaaa): ");     //toda esta parte es tentativa, podría hacerse
        int año = sc.nextInt();                         //con solo un input con el formato adecuado
        System.out.print("\ningrese mes (mm): ");
        int mes = sc.nextInt();
        System.out.print("\ningrese dia (dd) : ");
        int dia = sc.nextInt();

        //validar fecha

        try{
            fecha = LocalDate.of(año, mes, dia);
        }catch(Exception e){
            e.getStackTrace();
            System.out.print("Fecha incorrecta, vuelva a intentarlo\n");
            ingresarFecha();
        }
        return fecha;   //solo debe llegar aca cuando la fecha ingresada sea la correcta
    }

    public void mostrarVuelo(Vuelo vuelo){
        System.out.print("Fecha y hora: " + vuelo.getDateTime());
        System.out.print("Usuario: " + vuelo.getUsuarioNombre());
        //TODO: System.out.print("Avion: " + vuelo.getAvion().toString());  //probablemente esto no ande bien
        System.out.print("Ciudad de origen: " + vuelo.getCiudadOrigen());
        System.out.print("Ciudad de destino: " + vuelo.getCiudadDestino());
        //System.out.print("Costo: " + vuelo.getCosto());
    }

    public void mostrarCliente(Usuario cliente){
        System.out.println("Apellido y nombre: " + cliente.getApellido() + ", " + cliente.getNombre());
        System.out.println("DNI: " + cliente.getDni());
        System.out.println("Edad: " + cliente.getEdad());
        System.out.println("User: " + cliente.getUser());
        System.out.println("Categoría máxima de vuelo contratado: " + categoriaMaxVuelo(cliente));
        System.out.println("Total gastado por el cliente: " + totalGastado(cliente));
    }

    private String categoriaMaxVuelo(Usuario cliente){
        String categoriaMaxima = null;

        List<Vuelo> vuelos = obtenerListaDeVuelos();

        for(Vuelo vuelo : vuelos){
            if(vuelo.getUsuario().getUser().equals(cliente.getUser())){
                if(vuelo.getAvion().getType().equals("Gold"))
                    categoriaMaxima = "Gold";
                else if(vuelo.getAvion().getType().equals("Silver")){
                    categoriaMaxima = "Silver";
                }else{
                    categoriaMaxima = "Bronze";
                }
            }
        }

        return categoriaMaxima;
    }

    private String totalGastado(Usuario cliente){

        List<Vuelo> vuelos = obtenerListaDeVuelos();
        float costo = 0;

        for(Vuelo vuelo : vuelos){
            if(vuelo.getUsuario().getUser().equals(cliente.getUser()))
                costo += vuelo.getCosto();
        }

        return String.valueOf(costo);
    }

    private List<Vuelo> obtenerListaDeVuelos(){
        CapaDatos.downloadVuelos();
        return CapaDatos.getVuelosList();
    }

    private void mostrarVuelosEnFecha(List<Vuelo> vuelosEnFecha, LocalDate fecha){
        if(vuelosEnFecha.isEmpty()){
            System.out.print("No hay vuelos en la fecha seleccionada");
        }else{
            System.out.print("LISTA DE VUELOS EN LA FECHA " + fecha + "\n\n");
            for(Vuelo vuelo : vuelosEnFecha){
                mostrarVuelo(vuelo);
            }
        }
    }

    private void mostrarDatosDeClientes(List<Usuario> clientes){
        if(clientes.isEmpty()){
            System.out.print("No hay clientes para mostrar");
        }else{
            System.out.print("LISTA DE CLIENTES\n\n");
            for(Usuario cliente : clientes){
                mostrarCliente(cliente);
            }
        }
    }
}
