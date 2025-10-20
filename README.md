# 📂 Java I/O: Gestión de Clientes y Pedidos ☕

Este proyecto, desarrollado para la asignatura de **Acceso a Datos**, es una demostración práctica del manejo de ficheros en Java, centrándose en la serialización de objetos y la exportación a formato CSV.

---

### 💻 Tecnologías Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

---

### ✨ Funcionalidades

El programa principal (`Ejecucion.java`) demuestra un conjunto de utilidades para la persistencia de datos, incluyendo dos métodos principales de exportación:

* **Exportación a `.dat` (Serialización de Objetos):** Guarda una copia binaria exacta de los objetos (como `Cliente`) en un fichero `.dat`. Este proceso, conocido como serialización, permite "congelar" el estado de un objeto para recuperarlo intacto más tarde.

* **Exportación a `.csv` (Fichero de Texto):** Convierte las listas de objetos `Cliente` y `Pedido` a un formato de texto plano separado por comas, ideal para ser importado en hojas de cálculo como Excel.

* **Lectura Inteligente:** Incluye métodos para leer (`deserializar`) los ficheros `.dat` y reconstruir los objetos en memoria, comprobando primero si el fichero existe.

* **Persistencia con Anexión:** Implementa una lógica (`guardarAlCerrar`) que comprueba si el fichero `.dat` ya existe. Si existe, anexa la nueva información a los datos ya guardados; si no, lo crea desde cero.

---

### 💡 Conceptos Clave Aplicados

Este proyecto se centra en los siguientes conceptos de Acceso a Datos en Java:

#### 1. **Serialización de Objetos (`ObjectOutputStream` / `ObjectInputStream`)**
Es el concepto principal del proyecto. La serialización es el proceso de "congelar" el estado de un objeto y convertirlo en una secuencia de bytes para poder guardarlo en un fichero.
* `ObjectOutputStream`: Escribe los objetos "congelados" en un fichero (`.dat`).
* `ObjectInputStream`: Lee la secuencia de bytes del fichero y "descongela" los objetos, reconstruyéndolos en memoria.

#### 2. **Exportación a Ficheros de Texto (`PrintWriter` y `FileWriter`)**
Para la exportación a `.csv`, se utilizan flujos de caracteres. `PrintWriter` es una herramienta muy cómoda que permite escribir texto formateado (usando `println()`) de manera eficiente en un fichero.

#### 3. **Manejo de Ficheros y Rutas (`File`)**
La clase `File` se utiliza para interactuar con el sistema de archivos. En este proyecto es clave para:
* Crear una referencia a un fichero a partir de una ruta (`String path`).
* Comprobar si un fichero ya existe (`file.exists()`) para decidir si se debe crear o anexar información.

#### 4. **Uso de Genéricos (`<T>`)**
Los métodos de lectura y escritura de objetos (`escribirObjeto`, `leerObjeto`, etc.) están diseñados con genéricos (`<T>`). Esto los convierte en herramientas **reutilizables**, capaces de trabajar con cualquier tipo de objeto (`Cliente`, `Pedido`, etc.) sin necesidad de reescribir el código.

---

### 🚀 Cómo Ejecutar el Proyecto

1.  Clona el repositorio y ábrelo en un IDE de Java como IntelliJ IDEA o Eclipse.
2.  El programa está diseñado para trabajar con una estructura de carpetas `src/resources/`. Asegúrate de que esta ruta existe dentro de tu proyecto.
3.  Ejecuta el método `main` de la clase `Ejecucion.java`.
4.  Al ejecutarse, el programa:
    * Intentará leer el fichero `src/resources/objetos.dat`.
    * Mostrará los objetos leídos por consola.
    * Al final, guardará (o anexará) una nueva lista de clientes en ese mismo fichero.
