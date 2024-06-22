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

public class Vivero implements Crud {
    HashMap<Integer, Cliente> clientes;
    HashMap<Integer, Articulo> Articulos;
   public  static ObjectMapper viveroJson = new ObjectMapper();
    public  File  archivoVivero=new File("archivo.json");
    public Vivero() {
        clientes = new HashMap<>();
        Articulos = new HashMap<>();
    }


    @Override
    public void agregar(Object dato)throws ExceptionDNI, ExceptionCodigoDuplicado {
        if (dato instanceof Cliente) {
            try {
                ValidadorException.ValidadDNI(((Cliente) dato).getDni(), clientes);
                viveroJson.enable(SerializationFeature.INDENT_OUTPUT);
                clientes.put(((Cliente) dato).getDni(), (Cliente) dato);
            } catch (ExceptionDNI e) {
                System.out.println(e.getMessage());
                throw  e;
            }
        } else if (dato instanceof Articulo) {
            try {
                ValidadorException.ValidadCodigo(((Articulo) dato).getCodigo(), Articulos);
                viveroJson.enable(SerializationFeature.INDENT_OUTPUT);
                Articulos.put(((Articulo) dato).getCodigo(), (Articulo) dato);
            } catch (ExceptionCodigoDuplicado e) {
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


    public Object buscarDni(Object dato) {
        if (clientes.containsKey(dato)) {
            return clientes.get(dato);
        }
        return false;
    }

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

    @Override
    public void modificar(Object dato) {
        // Implementar lógica de modificación según sea necesario
    }

    @Override
    public String listar() {
        return "Clientes: " + clientes.toString() + "\nArtículos: " + Articulos.toString();
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


