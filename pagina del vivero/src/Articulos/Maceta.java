package Articulos;

import java.util.Objects;
import Enum.TipoDeArticulo;

public class Maceta extends Articulo {
    /// lo hago String para poder poenr ..x..x..
    private String MedidaDeLaMaceta;
    /// platico, fibrocemento,blum,etc;
    private String mateiralDeLaMaceta;

    public Maceta(String descripcion, String nombreDelArticulo, float precio, int stock, TipoDeArticulo tipoDeArticulo, String mateiralDeLaMaceta, String medidaDeLaMaceta) {
        super(descripcion, nombreDelArticulo, precio, stock, TipoDeArticulo.Maceta);
        this.mateiralDeLaMaceta = mateiralDeLaMaceta;
        MedidaDeLaMaceta = medidaDeLaMaceta;
    }

    public String getMedidaDeLaMaceta() {
        return MedidaDeLaMaceta;
    }

    public void setMedidaDeLaMaceta(String medidaDeLaMaceta) {
        MedidaDeLaMaceta = medidaDeLaMaceta;
    }

    public String getMateiralDeLaMaceta() {
        return mateiralDeLaMaceta;
    }

    public void setMateiralDeLaMaceta(String mateiralDeLaMaceta) {
        this.mateiralDeLaMaceta = mateiralDeLaMaceta;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Maceta maceta = (Maceta) o;
        return Objects.equals(MedidaDeLaMaceta, maceta.MedidaDeLaMaceta) && Objects.equals(mateiralDeLaMaceta, maceta.mateiralDeLaMaceta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MedidaDeLaMaceta, mateiralDeLaMaceta);
    }

    @Override
    public String toString() {
        return "Articulos.Maceta{" +
                "MedidaDeLaMaceta='" + MedidaDeLaMaceta + '\'' +
                ", mateiralDeLaMaceta='" + mateiralDeLaMaceta + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
}
