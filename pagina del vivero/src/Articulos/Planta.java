
package Articulos;

import java.util.Objects;

public class Planta extends Articulo {
    private String interioroexterior;

    public Planta(String nombreDelArticulo, float precio, int stock, String tipoDeArticulo, int codigo, String interiorOexterior) {
        super(nombreDelArticulo, precio, stock, tipoDeArticulo, codigo);
        this.interioroexterior = interioroexterior;
    }

    public String  getInterioroexterior() {
        return interioroexterior;
    }

    public void setInterioroexterior(String interioroexterior) {
        this.interioroexterior = interioroexterior;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planta planta = (Planta) o;
        return interioroexterior == planta.interioroexterior;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interioroexterior);
    }

    @Override
    public String toString() {
        return "Planta{" +
                "interioroexterior=" + interioroexterior +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", tipoDeArticulo=" + tipoDeArticulo +
                ", codigo=" + codigo +
                "} " ;
    }
}
