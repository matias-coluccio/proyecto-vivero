package Historial;

import java.time.LocalDate;
import java.util.Objects;

public class HistorialMovimientos {
    private int codigo;
    private String nombre;
    private float precio_un;
    private float precio_total;
    private int cant;
    private  String fechaActual;


    public HistorialMovimientos(int codigo, int cant, float precio_total, float precio_un, String nombre) {
        this.codigo = codigo;
        this.cant = cant;
        this.precio_total = precio_total;
        this.precio_un = precio_un;
        this.nombre = nombre;
        this.fechaActual=LocalDate.now().toString();
    }

    public HistorialMovimientos() {
        this.fechaActual=LocalDate.now().toString();
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_un() {
        return precio_un;
    }

    public void setPrecio_un(Float precio_un) {
        this.precio_un = precio_un;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialMovimientos that = (HistorialMovimientos) o;
        return codigo == that.codigo && Float.compare(precio_un, that.precio_un) == 0 && Float.compare(precio_total, that.precio_total) == 0 && cant == that.cant && Objects.equals(nombre, that.nombre) && Objects.equals(fechaActual, that.fechaActual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio_un, precio_total, cant, fechaActual);
    }

    @Override
    public String toString() {
        return "HistorialMovimientos{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio_un=" + precio_un +
                ", precio_total=" + precio_total +
                ", cant=" + cant +
                ", fechaActual='" + fechaActual + '\'' +
                '}';
    }
}
