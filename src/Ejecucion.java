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

        // exportarCliente("src/resources/escritura_cliente.csv", listaClientes);
        // exportarPedido("src/resources/escritura_pedido.csv", listaPedidos);
        // escribirObjeto("src/resources/objetos.dat", listaClientes);
        // leerObjeto("src/resources/objetos.dat", Cliente.class);


        //PRUEBA DE LOS METODOS DE REPASO

        // importarSiExiste("src/resources/noexiste.dat");

        ArrayList<Cliente> clientesImportados = importarSiExiste("src/resources/objetos.dat");

        if (clientesImportados != null) {

            System.out.println("**** USUARIOS IMPORTADOS ****");
            for (Cliente cliente : clientesImportados) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("NOMBRE: " + cliente.getNombre());
                System.out.println("EMAIL: " + cliente.getEmail());
            }
            System.out.println("Total de usuarios: " + clientesImportados.size());
        } else {
            System.out.println("No se pudo importar usuarios");
        }

        guardarAlCerrar("src/resources/objetos.dat", listaClientes);


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

    public static void exportarPedido(String path, ArrayList<Pedido> listaPedidos) {
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true)); //con true cada vez que "piso", anexo
            printWriter.println("id, clienteId, producto, cantidad");
            for (Pedido ped : listaPedidos) {
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

    public static <T> void escribirObjeto(String path, ArrayList<T> listaObjetos) {
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

            for (T objeto : listaObjetos) {
                oos.writeObject(objeto);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
            ;
        } catch (IOException e) {
            System.out.println("No tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }


    public static <T> ArrayList<T> leerObjeto(String path, Class<T> clase) {
        ArrayList<T> listaObjetos = new ArrayList<T>();
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        System.out.println("Leyendo archivo: " + path);
        System.out.println("Archivo existe: " + file.exists());
        System.out.println("Tamaño del archivo: " + file.length() + " bytes");

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            int contador = 0;

            while (true) {
                try {
                    T objeto = (T) ois.readObject();
                    listaObjetos.add(objeto);
                    contador++;
                    System.out.println("Objeto " + contador + " leído: " + objeto.toString());
                } catch (EOFException e) {
                    System.out.println("Fin del archivo. Total objetos leídos: " + contador);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no se encuentra");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error en la clase de lectura: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

        System.out.println("Total objetos en lista: " + listaObjetos.size());
        return listaObjetos;
    }


//    EJERCICIOS DE REPASO PROPUESTOS QUE NO SERÁN EVALUABLES EN LA PRÁCTICA:

    // En el programa, SOLO SI EL FICHERO EXISTE, importar en un arraylist todos los usuarios del mismo

    public static <T> ArrayList<T> importarSiExiste(String path) {
        ArrayList<T> listaobjetos = new ArrayList<>();
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        if (!file.exists()) {
            System.out.println("El fichero no existe. Fin de programa");
            return null;
        } else {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                int contador = 0;

                while (true) {
                    try {
                        T objeto = (T) ois.readObject();
                        listaobjetos.add(objeto);
                        contador++;
                        System.out.println("Objeto " + contador + " leído");

                    } catch (EOFException e) {
                        System.out.println("Fin del archivo. Total: " + contador + " objetos");
                        break;
                    } catch (IOException e) {
                        System.out.println("Error de Entrada/Salida: " + e.getMessage());
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error: Clase no encontrada");
                        break;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Error, el fichero no se encuentra");
            } catch (IOException e) {
                System.out.println("No tienes permisos de lectura");
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return listaobjetos;
    }


//    Si el programa cierra, SI EXISTE EL FICHERO, anexa informacion
//    Si el programa cierra, SI NO EXISTE EL FICHERO, lo crea y guarda informacion

    public static <T> void guardarAlCerrar(String path, ArrayList<T> datos) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;


        if (file.exists()) {
            System.out.println("El archivo existe. Anexando nueva información...");

            ArrayList<T> datosExistentes = importarSiExiste(path);

            if (datosExistentes != null) {
                datosExistentes.addAll(datos); //addAll() es un metodo de ArrayList que añade TODOS los elementos de una colección a otra colección.
            } else {
                datosExistentes = new ArrayList<>(datos);
            }

            escribirObjeto(path, datosExistentes);
            System.out.println("Información anexada con éxito");

        } else {
            System.out.println("Archivo no existe - Creando... Guardando...");
            escribirObjeto(path, datos);
            System.out.println("Archivo creado con " + datos.size() + " objetos");
        }


    }


}
