package Interfaz;

import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;

//Interfaz generica para manejar mis articulos y clientes
public interface Crud<T> {
    void agregar(T dato)throws ExceptionDNI, ExceptionCodigoDuplicado;
    void eliminar(T dato);
}
