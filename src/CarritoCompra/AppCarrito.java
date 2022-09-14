package CarritoCompra;
/**Biblioteca importante para obtener bytes de entrada de un archivo */
import java.io.FileInputStream;
/**Biblioteca importante para manejar las Excepciones al intentar abrir un archivo */
import java.io.FileNotFoundException;
/**Biblioteca importante para manejar las Excepciones de entrada y salida */
import java.io.IOException;
/**Biblioteca importante para permitir la escritura de datos  */
import java.io.ObjectInputStream;
/**Biblioteca importante para el manejo de ArrayList */
import java.util.ArrayList;

/**
 * Clase AppCarrito, la clase Main principal que ayudará a que se ejecute la totalidad del programa, se compone de la clase <code>ServidorProductos</code>
 * @see ServidorProductos
 * @see SerialWrite
 * @see Data
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class AppCarrito {
    /**
     *  Se crea una ruta para guardar los objetos traidos de la otra PC, se crean FileInput y ObjectInput que servirán para leerlos
     *   Se atrapan todas las excepciones necesarias y finalmente tanto el FileInput como ObjectInput se cierran
     *   Se otorgan los valores de los objetos almacenados gracias a la clase <code>SerialWrite</code>
     *   Se los almacena nuevamente en un arrayList de Productos, y estos Productos pasan a formar parte del Arraylist de tipo
     *   static de <code>Data</code>
     * @param args se reciben los argumentos para el Main del programa
     */
    public static void main(String[] args) {
        ServidorProductos.main();
        String ruta = "productos.txt";
        ArrayList<Producto> listaProductos = null;
        FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;
        try{
            fileInput = new FileInputStream(ruta);
            objectInput = new ObjectInputStream(fileInput);
            listaProductos = (ArrayList<Producto>) objectInput.readObject();
            Data.productos = listaProductos;
            agregarProductosAVender();
        }catch(FileNotFoundException e){
            System.out.println("file" + e.getMessage());
        }catch (IOException e){
            System.out.println("IO" + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Class" + e.getMessage());
        }finally {
            try{
                if(fileInput!=null){
                    fileInput.close();
                }
                if(objectInput!=null){
                    objectInput.close();
                }
                System.out.println(Data.productos);
                UsuarioGUI ventanaUsuarioGUI = new UsuarioGUI(null);
                ventanaUsuarioGUI.setVisible(true);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Función agregarProductosAVender, esta funcion agrega a <code>Data.productosVendidos</code> los productos que se van
     * a vender, en este caso como es un ArrayList, se agregan estos cinco productos definidos
     * @see ArrayList
     */
    public static void agregarProductosAVender(){
        Data.productosVendidos.add(Data.productoVendido1);
        Data.productosVendidos.add(Data.productoVendido2);
        Data.productosVendidos.add(Data.productoVendido3);
        Data.productosVendidos.add(Data.productoVendido4);
        Data.productosVendidos.add(Data.productoVendido5);
    }

}
