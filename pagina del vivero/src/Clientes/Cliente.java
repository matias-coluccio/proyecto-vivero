package Clientes;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private String categoria;
    private int dni;


    public Cliente(String nombre, String apellido, String categoria, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.dni = dni;

    }
    public Cliente()
    {
        this("", "", null, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && categoria == cliente.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, categoria, dni);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", categoria=" + categoria +
                ", dni=" + dni +
                '}';
    }

}
