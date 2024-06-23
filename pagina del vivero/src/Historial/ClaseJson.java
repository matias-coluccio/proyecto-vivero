package Historial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ClaseJson {
    public  static ObjectMapper HistorialJson = new ObjectMapper();
    public  File  archivoHistorial=new File("archivoHistorial.json");

    ArrayList<HistorialMovimientos> historial=new ArrayList<>();

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

    public ArrayList<HistorialMovimientos> getHistorial() {
        return historial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaseJson claseJson = (ClaseJson) o;
        return Objects.equals(archivoHistorial, claseJson.archivoHistorial) && Objects.equals(historial, claseJson.historial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivoHistorial, historial);
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
