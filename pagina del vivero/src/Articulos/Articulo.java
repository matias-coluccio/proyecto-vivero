package Articulos;

import java.util.Objects;

public abstract class Articulo {
    protected String nombreDelArticulo;
    protected double precio;
    protected String descripcion;
    protected int stock;

    public Articulo(String nombreDelArticulo, double precio, String descripcion, int stock) {
        this.nombreDelArticulo = nombreDelArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public Articulo() {
        this.nombreDelArticulo = "";
        this.precio = 0;
        this.descripcion = "";
        this.stock=0;
    }

    public String getNombreDelArticulo() {
        return nombreDelArticulo;
    }

    public void setNombreDelArticulo(String nombreDelArticulo) {
        this.nombreDelArticulo = nombreDelArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSotck() {
        return stock;
    }

    public void setSotck(int sotck) {
        this.stock = sotck;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Double.compare(precio, articulo.precio) == 0 && stock == articulo.stock && Objects.equals(nombreDelArticulo, articulo.nombreDelArticulo) && Objects.equals(descripcion, articulo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreDelArticulo, precio, descripcion, stock);
    }

    @Override
    public String toString() {
        return "Articulos.Articulo{" +
                "nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
    public void borrarDeStock(int cantidadDeSotckAborrar)
    {
        setSotck(getSotck()-cantidadDeSotckAborrar);
    }
}
