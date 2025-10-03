import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Ejecucion {
    static void main(String[] args) {

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1, "Juan Pérez", "Juanperez@gmail.com"));
        listaClientes.add(new Cliente(2, "Ana Martinez", "Anamartinez@gmail.com"));
        listaClientes.add(new Cliente(3, "Eva Goma", "Evagoma@gmail.com"));

        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedido(11, 1, "Camiseta negra", 2));
        listaPedidos.add(new Pedido(22, 2, "Vaquero azul", 5));
        listaPedidos.add(new Pedido(33, 2, "Zapatos deportivos", 2));
        listaPedidos.add(new Pedido(44, 3, "Chaqueta marron", 3));
        listaPedidos.add(new Pedido(55, 3, "Pañuelo", 1));

        exportarCliente("src/resources/escritura_cliente.csv", listaClientes);

//
    }


    public static void exportarCliente(String path, ArrayList<Cliente> listaClientes){
        File file = new File(path);
        PrintWriter printWriter= null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("id, nombre, email");
            for (Cliente cli: listaClientes){
                printWriter.println(cli);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                printWriter.close();
            }catch(NullPointerException e){
                System.out.println("Error en el cerrado");
            }
        }



    }
}
