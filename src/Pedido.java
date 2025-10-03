import java.io.Serializable;

public class Pedido implements Serializable {
    //Indico la versión porque es necesaria para poder recuperar los datos
    private static final Long SerialVersionUID = 1234L;

    private int id;
    private int clienteId;
    private String producto;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(int id, int clienteId, String producto, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //    Es necesario sobreescribir para poder escribir los objetos en formato CSV
    @Override
    public String toString() {
        return String.format("%d,%d,%s,%d\n", id, clienteId, producto, cantidad);
    }
}
