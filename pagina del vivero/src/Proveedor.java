import java.util.Objects;

public class Proveedor {
    private String nombre;
    private String RazonSocial;
    private long cuit;
    private int cuentaCte;
    private String categoria;

    public Proveedor(String nombre, String razonSocial, long cuit, int cuentaCte, String categoria) {
        this.nombre = nombre;
        RazonSocial = razonSocial;
        this.cuit = cuit;
        this.cuentaCte = cuentaCte;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public int getCuentaCte() {
        return cuentaCte;
    }

    public void setCuentaCte(int cuentaCte) {
        this.cuentaCte = cuentaCte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return cuit == proveedor.cuit && cuentaCte == proveedor.cuentaCte && Objects.equals(nombre, proveedor.nombre) && Objects.equals(RazonSocial, proveedor.RazonSocial) && categoria == proveedor.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, RazonSocial, cuit, cuentaCte, categoria);
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", RazonSocial='" + RazonSocial + '\'' +
                ", cuit=" + cuit +
                ", cuentaCte=" + cuentaCte +
                ", categoria=" + categoria +
                '}';
    }
}
