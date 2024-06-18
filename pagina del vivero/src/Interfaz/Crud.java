package Interfaz;

import Excepciones.ExceptionDNI;

public interface Crud<T> {
    void agregar(T dato)throws ExceptionDNI;
    void eliminar(T dato);
    void modificar(T dato);
    String  listar();
     T buscar(T dato);
}
