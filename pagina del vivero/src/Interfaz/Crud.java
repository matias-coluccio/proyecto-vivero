package Interfaz;

import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;

public interface Crud<T> {
    void agregar(T dato)throws ExceptionDNI, ExceptionCodigoDuplicado;
    void eliminar(T dato);
    void modificar(T dato);
    String  listar();
}
