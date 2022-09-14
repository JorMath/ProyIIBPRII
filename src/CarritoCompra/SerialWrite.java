package CarritoCompra;
/**Biblioteca importante para manejar las Excepciones al intentar abrir un archivo */
import java.io.FileNotFoundException;
/**Biblioteca importante para manejar el flujo de salida de un archivo */
import java.io.FileOutputStream;
/**Biblioteca importante para manejar las Excepciones de entrada y salida */
import java.io.IOException;
/**Biblioteca importante para permitir la escritura de datos  */
import java.io.ObjectOutputStream;
/**Biblioteca importante para el manejo de ArrayList */
import java.util.ArrayList;

/**
 * Clase SerialWrite, en donde se crean objetos de todas las otras clases y se interactúan con ellas
 * Esta clase se creó de inicio en el proyecto simplemente para escribir en un archivo de texto los objetos
 * de la clase <code>Producto</code>, de tal manera que luego de su escritura, no se volvió a usar.
 * @see Producto
 * @see java.io.Serializable
 * @see FileOutputStream
 * @see ObjectOutputStream
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class SerialWrite {
    /**
     * * Se crean unos productos definidos por sus características, luego se almacenan en un ArrayList de productos
     *  * Estos a su vez al guardarse, simplemente se escribe el ArrayList, se capturan las excepciones necesarias, y se cierra
     *  * El FileOutputStream y el ObjectOutputStream
     * @param args se reciben los argumentos para el funcionamiento de esta aplicación
     */
    public static void main(String[] args) {

        String ruta = "productos.txt";
        FileOutputStream fileOutput = null;
        ObjectOutputStream objectOutput = null;

        Producto producto1;
        Producto producto2;
        Producto producto3;
        Producto producto4;
        Producto producto5;

        ArrayList<Producto> listaProductos;

        try {
            fileOutput = new FileOutputStream(ruta);
            objectOutput = new ObjectOutputStream(fileOutput);
            producto1 = new Producto("Yogurt Toni", "p01", "Lacteos", 0.75, 50);
            producto2 = new Producto("Converse Zapatos", "p02", "Calzado", 55, 20);
            producto3 = new Producto("Silla de oficina", "p03", "Hogar", 120.99, 25);
            producto4 = new Producto("Celular Xiaomi 128GB", "p04", "Tecnología", 180, 15);
            producto5 = new Producto("Sillon-Sofá Negro", "p05", "Hogar", 322.95, 5);
            listaProductos = new ArrayList<>();
            listaProductos.add(producto1);
            listaProductos.add(producto2);
            listaProductos.add(producto3);
            listaProductos.add(producto4);
            listaProductos.add(producto5);
            objectOutput.writeObject(listaProductos);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                if(fileOutput!=null){
                    fileOutput.close();
                }
                if(objectOutput!=null){
                    objectOutput.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
