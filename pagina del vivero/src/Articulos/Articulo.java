package Articulos;

import java.util.Objects;

public class Articulo {
    // Atributos del artículo
    protected String nombreDelArticulo;
    protected float precio;
    protected int stock;
    protected String tipoDeArticulo;
    protected int codigo;

    // Constructor que inicializa todos los atributos del artículo
    public Articulo(String nombreDelArticulo, float precio, int stock, String tipoDeArticulo, int codigo) {
        this.codigo = codigo;
        this.nombreDelArticulo = nombreDelArticulo;
        this.precio = precio;
        this.stock = stock;
        this.tipoDeArticulo = tipoDeArticulo;
    }

    // Constructor por defecto
    public Articulo() {
    }

    // Métodos getter y setter para acceder y modificar los atributos del artículo

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipoDeArticulo() {
        return tipoDeArticulo;
    }

    public void setTipoDeArticulo(String tipoDeArticulo) {
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

    // Método equals para comparar dos artículos en base a sus atributos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si los objetos son iguales, retorna true
        if (o == null || getClass() != o.getClass()) return false; // Si el objeto es nulo o de otra clase, retorna false
        Articulo articulo = (Articulo) o;
        // Compara todos los atributos relevantes para determinar si los artículos son iguales
        return Float.compare(precio, articulo.precio) == 0 &&
                stock == articulo.stock &&
                codigo == articulo.codigo &&
                Objects.equals(nombreDelArticulo, articulo.nombreDelArticulo) &&
                tipoDeArticulo == articulo.tipoDeArticulo;
    }

    // Método hashCode para proporcionar un código hash único para el artículo
    @Override
    public int hashCode() {
        return Objects.hash(nombreDelArticulo, precio, stock, tipoDeArticulo, codigo);
    }

    // Método toString para proporcionar una representación en cadena del artículo
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