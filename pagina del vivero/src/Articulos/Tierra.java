package Articulos;

import java.util.Objects;
import Enum.TipoDeArticulo;

public class Tierra extends Articulo {
   // el tamanio de la tierra se mide en dm3
    private String tamanio;

    public Tierra(String descripcion, String nombreDelArticulo, float precio, int stock, TipoDeArticulo tipoDeArticulo, String tamanio) {
        super(descripcion, nombreDelArticulo, precio, stock, TipoDeArticulo.Tierra);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tierra tierra = (Tierra) o;
        return Objects.equals(tamanio, tierra.tamanio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamanio);
    }

    @Override
    public String toString() {
        return "Articulos.Tierra{" +
                "tamanio='" + tamanio + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
}
