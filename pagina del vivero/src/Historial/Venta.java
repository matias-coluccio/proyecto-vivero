package Historial;

import java.util.Objects;

public class Venta {
    private int codigo;
    private String nombre;
    private int precio_un;
    private int precio_total;
    private int cant;
    public static int ID_venta=0;

    public Venta(int codigo, int cant, int precio_total, int precio_un, String nombre) {
        this.codigo = codigo;
        this.cant = cant;
        this.precio_total = precio_total;
        this.precio_un = precio_un;
        this.nombre = nombre;
        ID_venta++;
    }

    public Venta() {

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

    public int getPrecio_un() {
        return precio_un;
    }

    public void setPrecio_un(int precio_un) {
        this.precio_un = precio_un;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
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
        Venta venta = (Venta) o;
        return codigo == venta.codigo && precio_un == venta.precio_un && precio_total == venta.precio_total && cant == venta.cant && Objects.equals(nombre, venta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio_un, precio_total, cant);
    }

    @Override
    public String toString() {
        return "Historial.Venta{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio_un=" + precio_un +
                ", precio_total=" + precio_total +
                ", cant=" + cant +
                '}';
    }
}
