package Excepciones;

import Articulos.Articulo;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;

import java.util.Map;

public class ValidadorException {
    public static void ValidadDNI(int dni, Map dato) throws ExceptionDNI
    {
            if(dato.containsKey(dni))
            {
                throw new ExceptionDNI("Este DNI ya ha sido ingresado");
            }
    }
    public static void ValidadCodigo(Articulo dato1, Map dato) throws ExceptionCodigoDuplicado
    {
        if(dato.containsValue(dato1))
        {
            throw new ExceptionCodigoDuplicado("Ya hay un articulo con ese codigo");
        }
    }
}
