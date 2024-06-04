import Articulos.*;
import Clientes.*;

import java.util.ArrayList;

public class Venta {
    ArrayList<Articulo> articulos;
    Cliente cliente;
    double total;

    public Venta(Cliente cliente, ArrayList<Articulo> articulos) {
        this.cliente = cliente;
        this.articulos = articulos;
    ////acomodamos funcion
        total = SumadePrecioArticulos(articulos) -(total * 0.10);


    }
    /// TODO
    public Venta(ArrayList<Articulo> articulos) {
        this.articulos=articulos;
        total=SumadePrecioArticulos(articulos);
    }
    public double SumadePrecioArticulos(ArrayList<Articulo> articulos)
        {
            double total=0;
            for(Articulo i:articulos)
            {

                 total+= i.getPrecio();
            }
            return total;
        }


}
