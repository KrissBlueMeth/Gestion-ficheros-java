import java.util.ArrayList;

public class Ejecución {
    static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan Pérez", "Juanperez@gmail.com"));
        clientes.add(new Cliente(2, "Ana Martinez", "Anamartinez@gmail.com"));
        clientes.add(new Cliente(3, "Eva Goma", "Evagoma@gmail.com"));

        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(001, 1, "Camiseta negra", 2));
        pedidos.add(new Pedido(002, 2, "Vaquero azul", 5));
        pedidos.add(new Pedido(003, 2, "Zapatos deportivos", 2));
        pedidos.add(new Pedido(004, 3, "Chaqueta marron", 3));
        pedidos.add(new Pedido(005, 3, "Pañuelo", 1));


//        Aquí irán las llamadas a los métodos
    }
}
