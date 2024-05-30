import Articulos.*;
import Clientes.*;

import java.util.ArrayList;

public class Venta {
    ArrayList<Articulo> articulos;
    Cliente cliente;
    int total;

    public Venta(Cliente cliente, ArrayList<Articulo> articulos) {
        this.cliente = cliente;
        this.articulos=articulos;
        /// esto no sabemos si va
        if(cliente)
        {

        }
        else if(cliente)
        total=SumadePrecioArticulos(articulos);
        total=total *0,10;

    }
    /// TODO
    public Venta(ArrayList<Articulo> articulos) {
        this.articulos=articulos;
        total=SumadePrecioArticulos(articulos);
    }
    public int SumadePrecioArticulos(ArrayList<Articulo> articulos)
        {
            int total=0;
            for(Articulo i:articulos)
            {

                 total+= i.getPrecio();
            }
            return total;
        }
        public boolean EsSocio()

}
