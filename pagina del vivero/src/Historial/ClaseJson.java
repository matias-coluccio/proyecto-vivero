package Historial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;

public class ClaseJson {
    public  static ObjectMapper HistorialJson = new ObjectMapper();
    public  File  archivoHistorial=new File("archivoHistorial.json");

    ArrayList<Venta> historial=new ArrayList<>();

    public ClaseJson() {
    }

    public  void guardarEnArchivoHistorial(String ruta) throws IOException {
        HistorialJson.writeValue(new File(ruta), this);
    }

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

    public ArrayList<Venta> getHistorial() {
        return historial;
    }

    public  void Agregar(Venta a) {
        HistorialJson.enable(SerializationFeature.INDENT_OUTPUT);
        historial.add(a);
    }
}
