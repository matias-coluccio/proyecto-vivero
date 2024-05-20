import java.util.Objects;

public abstract class Articulo {
    protected String nombreDelArticulo;
    protected float precio;
    protected String descripcion;
    protected int sotck;

    public Articulo(String nombreDelArticulo, float precio, String descripcion, int sotck) {
        this.nombreDelArticulo = nombreDelArticulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.sotck = sotck;
    }

    public Articulo() {
        this.nombreDelArticulo = "";
        this.precio = 0;
        this.descripcion = "";
        this.sotck=0;
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
        return sotck;
    }

    public void setSotck(int sotck) {
        this.sotck = sotck;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Float.compare(precio, articulo.precio) == 0 && sotck == articulo.sotck && Objects.equals(nombreDelArticulo, articulo.nombreDelArticulo) && Objects.equals(descripcion, articulo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreDelArticulo, precio, descripcion, sotck);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "nombreDelArticulo='" + nombreDelArticulo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", sotck=" + sotck +
                '}';
    }
    public void borrarDeStock(int cantidadDeSotckAborrar)
    {
        setSotck(getSotck()-cantidadDeSotckAborrar);
    }
}
