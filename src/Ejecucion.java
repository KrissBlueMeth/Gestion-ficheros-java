import java.io.*;
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

      //  exportarCliente("src/resources/escritura_cliente.csv", listaClientes);
       // exportarPedido("src/resources/escritura_pedido.csv", listaPedidos);
        escribirObjeto("src/resources/objetos.dat", listaClientes);


//
    }


    public static void exportarCliente(String path, ArrayList<Cliente> listaClientes) {
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));//con true cada vez que "piso", anexo
            printWriter.println("id, nombre, email");
            for (Cliente cli : listaClientes) {
                printWriter.println(cli);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public static void exportarPedido(String path, ArrayList<Pedido> listaPedidos){
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true)); //con true cada vez que "piso", anexo
            printWriter.println("id, clienteId, producto, cantidad");
            for(Pedido ped : listaPedidos) {
                printWriter.println(ped);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert printWriter != null;
            printWriter.close();
        }


    }

    //serializacion: flujo de objetos -> dat guarda el OBJETO
    //Con la <T> que es el genérico, adapto el metodo para usarlo con cualquier clase

    public static <T> void escribirObjeto(String path, ArrayList<T> listaObjetos){
//        ESTA ES LA OTRA MANERA DE ESCRIBIRLO, CON EL FLUJO EN LA MISMA LINEA
//        File file = new File(path);
//        ObjectOutputStream oos = null;
//
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream(file));

        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            for (T objeto : listaObjetos){
                oos.writeObject(objeto);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");;
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        }finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }


}
