
package Articulos;

import Enum.interiorOexterior;
import Enum.TipoDeArticulo;

import java.util.Objects;

public class Planta extends Articulo {
    private interiorOexterior interioroexterior;

    public Planta(String nombreDelArticulo, float precio, int stock, int codigo, interiorOexterior interioroexterior) {
        super(nombreDelArticulo, precio, stock, TipoDeArticulo.Planta, codigo);
        this.interioroexterior = interioroexterior;

    }

    public interiorOexterior getInterioroexterior() {
        return interioroexterior;
    }

    public void setInterioroexterior(interiorOexterior interioroexterior) {
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
