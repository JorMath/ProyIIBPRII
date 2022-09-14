package CarritoCompra;
/**Biblioteca importante para el manejo de ArrayList */
import java.util.ArrayList;

/**
 * Clase Data se crean los ArrayList de productos y mientras se va agregando los productos se creará el ArrayList de productosVendidos
 * Se crea un nuevo usuarioTienda, bodegaTienda y tiendaGeneral
 * @author Grupo Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class Data {
    /**
     * ArrayList de tipo static Producto que almacena el valor en una lista de <code>Producto</code>
     * @see Producto
     */
    static ArrayList<Producto> productos = new ArrayList<>();
    /**
     * Producto 1 que se almacena en la lista
     */
    static Producto productoVendido1 = new Producto("Yogurt Toni", "p01", "Lacteos", 0.75, 0);
    /**
     * Producto 2 que se almacena en la lista
     */
    static Producto productoVendido2 = new Producto("Converse Zapatos", "p02", "Calzado", 55, 0);
    /**
     * Producto 3 que se almacena en la lista
     */
    static Producto productoVendido3 = new Producto("Silla de oficina", "p03", "Hogar", 120.99, 0);
    /**
     * Producto 4 que se almacena en la lista
     */
    static Producto productoVendido4 = new Producto("Celular Xiaomi 128GB", "p04", "Tecnología", 180, 0);
    /**
     * Producto 5 que se almacena en la lista
     */
    static Producto productoVendido5 = new Producto("Sillon-Sofá Negro", "p05", "Hogar", 322.95, 0);
    /**
     * Productos vendidos que se almacena en otro ArrayList que permite las ventas totales
     */
    static ArrayList<Producto> productosVendidos = new ArrayList<>();
    /**
     * Creación del Usuario para la tienda de la clase <code>Usuario</code>
     */

    static Usuario usuarioTienda = new Usuario();
    /**
     * Creación de una bodega la cual contiene la lista de productos que van a venderse
     */
    static Bodega bodegaTienda = new Bodega(productos);
    /**
     * Creación de una tienda, la clase más general <code>Tienda</code>
     * @see Tienda
     */
    static Tienda tiendaGeneral = new Tienda(bodegaTienda,usuarioTienda);
}