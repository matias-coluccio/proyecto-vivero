import Clientes.Cliente;
import Enum.Categoria;
import Interfaz.GUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Vivero vivero=new Vivero();
        Cliente cliente=new Cliente("Gian", "Fernandez", Categoria.ResponsableInscripto, 46348819);
        vivero.agregar(cliente);
        String lista=vivero.listar();
        System.out.println(lista);
        GUI gui= new GUI();
        gui.setVisible(true);
    }
}