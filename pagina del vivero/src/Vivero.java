import Articulos.Articulo;
import Clientes.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Vivero implements Crud{
    HashMap<Integer, Cliente> clientes;
    HashMap<String, LinkedList<Articulo>  > Articulos;

    public Vivero() {
        clientes=new HashMap<>();
        Articulos=new HashMap<>();
    }

    @Override
    public void agregar(Object dato) {

        if(dato instanceof Cliente)
        {

               clientes.put(((Cliente) dato).getDni(), (Cliente) dato);



        }
        else if( dato instanceof Articulo)
            {
               LinkedList<Articulo> cargados=Articulos.get(dato.getClass());
               cargados.add((Articulo) dato);
                Articulos.put(((Articulo) dato).getClass().getName(),  cargados );
            }
    }

    @Override
    public void eliminar(Object dato) {
        if(dato instanceof Articulo)
            {
                Articulos.remove(dato.getClass(), dato);
            }
        else if(dato instanceof Cliente)
            {
                clientes.remove(((Cliente) dato).getDni(), dato);
            }
    }

    @Override
    public void modificar(Object dato) {

    }

    @Override
    public String listar() {
        return clientes.toString() ;
    }
}
