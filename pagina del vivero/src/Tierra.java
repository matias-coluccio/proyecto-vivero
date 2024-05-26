import java.util.Objects;

public class Tierra extends Articulo{
   // el tamanio de la tierra se mide en dm3
    private String tamanio;

    public Tierra(String nombreDelArticulo, float precio, String descripcion, int stock, String tamanio) {
        super(nombreDelArticulo, precio, descripcion, stock);
        this.tamanio = tamanio;
    }

    public Tierra() {
        super();
        this.tamanio = "";
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
        return "Tierra{" +
                "tamanio='" + tamanio + '\'' +
                ", nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + stock +
                '}';
    }
}
