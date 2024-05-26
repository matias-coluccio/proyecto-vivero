
package Articulos;

import Enum.interiorOexterior;

import java.util.Objects;

public class Planta extends Articulo {
    private interiorOexterior interioroexterior;
    private String cuidados;

    public Planta(String nombreDelArticulo, float precio, String descripcion, int stock, interiorOexterior interioroexterior, String cuidados) {
        super(nombreDelArticulo, precio, descripcion, stock);
        this.interioroexterior = interioroexterior;
        this.cuidados = cuidados;
    }

    public Planta() {
        super();
        this.interioroexterior=null;
        this.cuidados="";
    }

    public interiorOexterior getInterioroexterior() {
        return interioroexterior;
    }

    public void setInterioroexterior(interiorOexterior interioroexterior) {
        this.interioroexterior = interioroexterior;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planta planta = (Planta) o;
        return interioroexterior == planta.interioroexterior && Objects.equals(cuidados, planta.cuidados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interioroexterior, cuidados);
    }

    @Override
    public String toString() {
        return "Articulos.Planta{" +
                "interioroexterior=" + interioroexterior +
                ", cuidados='" + cuidados + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
}
