package Articulos;

import java.util.Objects;
import Enum.TipoDeArticulo;

public class Agroquimico extends Articulo {
    private String cantidadDelEnvase;
    private String tipoDeAgroquimico;

    public Agroquimico(String descripcion, String nombreDelArticulo, float precio, int stock, TipoDeArticulo tipoDeArticulo, String cantidadDelEnvase, String tipoDeAgroquimico) {
        super(descripcion, nombreDelArticulo, precio, stock, TipoDeArticulo.Agroquimico);
        this.cantidadDelEnvase = cantidadDelEnvase;
        this.tipoDeAgroquimico = tipoDeAgroquimico;
    }

    public String getCantidadDelEnvase() {
        return cantidadDelEnvase;
    }

    public void setCantidadDelEnvase(String cantidadDelEnvase) {
        this.cantidadDelEnvase = cantidadDelEnvase;
    }

    public String getTipoDeAgroquimico() {
        return tipoDeAgroquimico;
    }

    public void setTipoDeAgroquimico(String tipoDeAgroquimico) {
        this.tipoDeAgroquimico = tipoDeAgroquimico;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Agroquimico that = (Agroquimico) o;
        return Objects.equals(cantidadDelEnvase, that.cantidadDelEnvase) && Objects.equals(tipoDeAgroquimico, that.tipoDeAgroquimico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cantidadDelEnvase, tipoDeAgroquimico);
    }

    @Override
    public String toString() {
        return "Articulos.Agroquimico{" +
                "cantidadDelEnvase='" + cantidadDelEnvase + '\'' +
                ", tipoDeAgroquimico='" + tipoDeAgroquimico + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
}
