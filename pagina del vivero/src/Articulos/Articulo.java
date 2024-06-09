package Articulos;

import java.util.Objects;
import Enum.TipoDeArticulo;

public class Articulo {
    protected String nombreDelArticulo;
    protected float precio;
    protected String descripcion;
    protected int stock;
    protected TipoDeArticulo tipoDeArticulo;

    public Articulo(String descripcion, String nombreDelArticulo, float precio, int stock, TipoDeArticulo tipoDeArticulo) {
        this.descripcion = descripcion;
        this.nombreDelArticulo = nombreDelArticulo;
        this.precio = precio;
        this.stock = stock;
        this.tipoDeArticulo = tipoDeArticulo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TipoDeArticulo getTipoDeArticulo() {
        return tipoDeArticulo;
    }

    public void setTipoDeArticulo(TipoDeArticulo tipoDeArticulo) {
        this.tipoDeArticulo = tipoDeArticulo;
    }

    public String getNombreDelArticulo() {
        return nombreDelArticulo;
    }

    public void setNombreDelArticulo(String nombreDelArticulo) {
        this.nombreDelArticulo = nombreDelArticulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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
        return Float.compare(precio, articulo.precio) == 0 && stock == articulo.stock && Objects.equals(nombreDelArticulo, articulo.nombreDelArticulo) && Objects.equals(descripcion, articulo.descripcion) && tipoDeArticulo == articulo.tipoDeArticulo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreDelArticulo, precio, descripcion, stock, tipoDeArticulo);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "descripcion='" + descripcion + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", tipoDeArticulo=" + tipoDeArticulo +
                '}';
    }

    public void borrarDeStock(int cantidadDeSotckAborrar)
    {
        setSotck(getSotck()-cantidadDeSotckAborrar);
    }
}
