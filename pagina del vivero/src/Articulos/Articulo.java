package Articulos;

import java.util.Objects;
import Enum.TipoDeArticulo;

public class Articulo {
    protected String nombreDelArticulo;
    protected float precio;
    protected int stock;
    protected TipoDeArticulo tipoDeArticulo;
    protected int codigo;

    public Articulo(String nombreDelArticulo, float precio, int stock, TipoDeArticulo tipoDeArticulo, int codigo) {
        this.codigo=codigo;
        this.nombreDelArticulo = nombreDelArticulo;
        this.precio = precio;
        this.stock = stock;
        this.tipoDeArticulo = tipoDeArticulo;
    }

    public Articulo() {
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {



        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Float.compare(precio, articulo.precio) == 0 && stock == articulo.stock && codigo == articulo.codigo && Objects.equals(nombreDelArticulo, articulo.nombreDelArticulo) && tipoDeArticulo == articulo.tipoDeArticulo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreDelArticulo, precio, stock, tipoDeArticulo, codigo);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", tipoDeArticulo=" + tipoDeArticulo +
                ", codigo=" + codigo +
                '}';
    }
}
