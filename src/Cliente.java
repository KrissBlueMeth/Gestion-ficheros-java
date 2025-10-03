import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final Long SerialVersionUID = 1234L;

    private int id;
    private String nombre;
    private String email;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    Es necesario sobreescribir para poder escribir los objetos en formato CSV
    @Override
    public String toString() {
        return String.format("%d,%s,%s\n", id, nombre, email);
    }


}
