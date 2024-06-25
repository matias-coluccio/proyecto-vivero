package Vivero;

import Articulos.Articulo;
import Clientes.Cliente;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;
import Excepciones.ValidadorException;
import Interfaz.Crud;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

//
//Clase que maneja todos los elementos de mi vivero, tanto articulos como clientes
public class Vivero implements Crud {
    //Coleccion que maneja los clientes, la clave es el DNI y el valor el objeto
    HashMap<Integer, Cliente> clientes;
    //Coleccion que maneja los articulos, la clave es el ID y el valor el objeto
    HashMap<Integer, Articulo> Articulos;
    //viveroJson utilizado para el funcionamiento del json
   public  static ObjectMapper viveroJson = new ObjectMapper();
   //archivo vivero es mi archivo general del vivero
    public  File  archivoVivero=new File("archivo.json");

    //Constructor
    public Vivero() {
        clientes = new HashMap<>();
        Articulos = new HashMap<>();
    }

//Overrides metodos de CRUD
    @Override
    public void agregar(Object dato)throws ExceptionDNI, ExceptionCodigoDuplicado {
        //If para detectar si el objeto es cliente o articulo
        if (dato instanceof Cliente) {
            try {
                //Valido un posible DNI duplicado
                ValidadorException.ValidadDNI(((Cliente) dato).getDni(), clientes);
                viveroJson.enable(SerializationFeature.INDENT_OUTPUT);
                //Guardo el objeto en el hashMap
                clientes.put(((Cliente) dato).getDni(), (Cliente) dato);
            } catch (ExceptionDNI e) {
                //Atrapo la excepcion y lanzo  nuevamente
                System.out.println(e.getMessage());
                throw  e;
            }
        } else if (dato instanceof Articulo) {
            try {
                //Valido un posible ID duplicado
                ValidadorException.ValidadCodigo(((Articulo) dato).getCodigo(), Articulos);
                viveroJson.enable(SerializationFeature.INDENT_OUTPUT);
                //Guardo el objeto en el hashMap
                Articulos.put(((Articulo) dato).getCodigo(), (Articulo) dato);
            } catch (ExceptionCodigoDuplicado e) {
                //Atrapo la excepcion y lanzo  nuevamente
                System.out.println(e.getMessage());
                throw e;
            }
        }

    }


    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }


    public void setClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Integer, Articulo> getArticulos() {
        return Articulos;
    }

//BuscarPorDni ya que ambos ID Y DNI son enteros y pueden compartir el mismo numero
    public Object buscarDni(Object dato) {
        if (clientes.containsKey(dato)) {
            return clientes.get(dato);
        }
        return false;
    }
    //BuscarPorID ya que ambos ID Y DNI son enteros y pueden compartir el mismo numero
    public Object buscarCodigo(Object dato) {
        if (Articulos.containsKey(dato)) {
            return Articulos.get(dato);
        }
        return false;
    }


    @Override
    public void eliminar(Object dato) {
        if (dato instanceof Integer && clientes.containsKey(dato)) {
            clientes.remove(dato);
        } else if (dato instanceof Integer && Articulos.containsKey(dato)) {
            Articulos.remove(dato);
        }
    }


    // Métodos para trabajar con JSON
    public  void guardarEnArchivo(String ruta) throws IOException {
        viveroJson.writeValue(new File(ruta), this);
    }

    public static Vivero cargarDesdeArchivo(String ruta) throws IOException {
        return viveroJson.readValue(new File(ruta), Vivero.class);
    }

    // Métodos para convertir a JSON y desde JSON
    public String convertirAJson() throws IOException {
        return viveroJson.writeValueAsString(this);
    }

    public static Vivero desdeJson(String jsonString) throws IOException {
        return viveroJson.readValue(jsonString, Vivero.class);
    }
}


