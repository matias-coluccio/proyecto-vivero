package Vivero;

import Articulos.Articulo;
import Clientes.Cliente;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;
import Excepciones.ValidadorException;
import Interfaz.Crud;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Vivero implements Crud {
    HashMap<Integer, Cliente> clientes;
    HashMap<String, LinkedList<Articulo>> Articulos;
    static ObjectMapper viveroJson = new ObjectMapper();
    File archivoVivero = new File("archivoVivero.json");

    public Vivero() {
        clientes = new HashMap<>();
        Articulos = new HashMap<>();
    }



    @Override
    public void agregar(Object dato) throws ExceptionDNI {
        if (dato instanceof Cliente) {
            try {
                ValidadorException.ValidadDNI(((Cliente) dato).getDni(), clientes);
                clientes.put(((Cliente) dato).getDni(), (Cliente) dato);
            } catch (ExceptionDNI e) {
                System.out.println(e.getMessage());
                throw e;
            }
        } else if (dato instanceof Articulo) {
            try {
                ValidadorException.ValidadCodigo((Articulo) dato, Articulos);
                LinkedList<Articulo> cargados = Articulos.get(dato.getClass().getName());
                if (cargados == null) {
                    cargados = new LinkedList<>();
                }
                cargados.add((Articulo) dato);
                Articulos.put(((Articulo) dato).getClass().getName(), cargados);
            } catch (ExceptionCodigoDuplicado e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Object buscar(Object dato) {
        if (clientes.containsKey(dato)) {
            return clientes.get(dato);
        }
        // Implementar búsqueda de Artículos si es necesario
        return false;
    }

    @Override
    public void eliminar(Object dato) {
        if (dato instanceof Integer && clientes.containsKey(dato)) {
            clientes.remove(dato);
        } else if (dato instanceof String && Articulos.containsKey(dato)) {
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
    public void guardarEnArchivo(String ruta) throws IOException {
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


