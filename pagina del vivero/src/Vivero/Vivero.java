package Vivero;

import Articulos.Articulo;
import Clientes.Cliente;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;
import Excepciones.ValidadorException;
import java.util.HashMap;
import java.util.LinkedList;
import Interfaz.Crud;




public class Vivero implements Crud {
        HashMap<Integer, Cliente> clientes;
        HashMap<String, LinkedList<Articulo>> Articulos;

        public Vivero() {
            clientes = new HashMap<>();
            Articulos = new HashMap<>();
        }

        @Override
        public void agregar(Object dato)throws ExceptionDNI {

            if (dato instanceof Cliente) {
                try {
                    ValidadorException.ValidadDNI(((Cliente) dato).getDni(), clientes);
                    clientes.put(((Cliente) dato).getDni(), (Cliente) dato);
                } catch (ExceptionDNI e) {

                    System.out.println(e.getMessage());
                    throw  e;
                }
            } else if (dato instanceof Articulo) {
                try {
                    ValidadorException.ValidadCodigo((Articulo) dato, Articulos);
                    LinkedList<Articulo> cargados = Articulos.get(dato.getClass().getName());
                    if (cargados == null) {
                        cargados = new LinkedList<>();
                    }
                    cargados.add((Articulo) dato);
                    Articulos.put(((Articulo) dato).getClass().getName(), cargados);
                } catch (ExceptionCodigoDuplicado e) {
                    System.out.println(e.getMessage());
                }
            }


        }

    @Override
    public Object buscar(Object dato) {

            Cliente aux;
            if(clientes.containsKey(dato)) {
                aux = clientes.get(dato);
                return aux;
            }
            /*
            else if(Articulos.containsKey(((Articulo) dato)))
            {
                Articulo aux1;
                LinkedList<Articulo> list=new LinkedList<>();
                list=Articulos.get(((Articulo) dato).getTipoDeArticulo());
                for(Articulo i : list)
                {
                    if(i.getCodigo()==((Articulo) dato).getCodigo())
                    {
                        aux1=i;
                        return aux1;
                    }
                }
            }
            */

        return false;
    }

        @Override
        public void eliminar(Object dato) {
            if (dato instanceof Articulo) {
                Articulos.remove(dato.getClass(), dato);
            } else if (dato instanceof Cliente) {
                clientes.remove(((Cliente) dato).getDni(), dato);
            }
        }

        @Override
        public void modificar(Object dato) {

        }

        @Override
        public String listar() {
            return clientes.toString() + Articulos.toString();
        }
    }


