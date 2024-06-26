package Historial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

//Clase que maneja el historial de movimientos del vivero
public class ClaseJson {
    public  static ObjectMapper HistorialJson = new ObjectMapper();
    //el primer file para recuperar datos de mis json venta y el segundo de mis compras
    public  File  archivoHistorialVentas=new File("archivoHistorialVenta.json");
    public  File  archivoHistorialCompras=new File("archivoHistorialCompra.json");

    //Arraylist que guarda los movimientos
    ArrayList<HistorialMovimientos> historial=new ArrayList<>();

    //Constructor por defecto
    public ClaseJson() {
    }

    //Guardar en el historial
    public  void guardarEnArchivoHistorial(String ruta) throws IOException {
        HistorialJson.writeValue(new File(ruta), this);
    }
    //Recuperar desde el json
    public static ClaseJson cargarDesdeArchivoHistorial(String ruta) throws IOException {
        return HistorialJson.readValue(new File(ruta), ClaseJson.class);
    }

    // Métodos para convertir a JSON y desde JSON
    public String convertirAJsonHistorial() throws IOException {
        return HistorialJson.writeValueAsString(this);
    }

    public static ClaseJson desdeJsonHistorial(String jsonString) throws IOException {
        return HistorialJson.readValue(jsonString, ClaseJson.class);
    }

    public ArrayList<HistorialMovimientos> getHistorial() {
        return historial;
    }

    //Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaseJson claseJson = (ClaseJson) o;
        return Objects.equals(archivoHistorialVentas, claseJson.archivoHistorialVentas) && Objects.equals(archivoHistorialCompras, claseJson.archivoHistorialCompras) && Objects.equals(historial, claseJson.historial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivoHistorialVentas, archivoHistorialCompras, historial);
    }

    public String listar()
    {
        return historial.toString();
    }

    public  void Agregar(HistorialMovimientos a) {
        HistorialJson.enable(SerializationFeature.INDENT_OUTPUT);
        historial.add(a);
    }
}
