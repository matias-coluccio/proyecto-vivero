package Excepciones;

import Articulos.Articulo;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;

import java.util.Map;
//Clase abstracta ya que al ser sus dos metodos estaticos no tendria sentido la posibilidad de instanciarla
public abstract class ValidadorException {
    //Validar dnis duplicados en nuestro archivo
    public static void ValidadDNI(int dni, Map dato) throws ExceptionDNI
    {
            if(dato.containsKey(dni))
            {
                throw new ExceptionDNI("Este DNI ya ha sido ingresado");
            }
    }
    //Validar codigos duplicados en nuestro archivo
    public static void ValidadCodigo(int id, Map dato) throws ExceptionCodigoDuplicado
    {
        if(dato.containsKey(id))
        {
            throw new ExceptionCodigoDuplicado("Ya hay un articulo con ese codigo");
        }
    }
}
