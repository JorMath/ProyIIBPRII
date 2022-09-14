package CarritoCompra;
/**
 * Biblioteca importante para el manejo de ArrayList
 */
import java.util.ArrayList;
/**
 * Clase Bodega
 * @author Grupo 08 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */

public class Bodega {
    /**
     * ArrayList de productos los cuales se almacenan en <code>Bodega</code>
     */
    ArrayList<Producto> productosBodega = new ArrayList<>();

    /**
     * Constructor que inicia los valores para el objeto <code>Bodega</code>
     * @param productosBodega inicia el valor de <code>productosBodega</code>
     */
    public Bodega(ArrayList<Producto> productosBodega) {
        this.productosBodega = productosBodega;
    }

    /**
     * Función que permite obtener el valor de <code>productosBodega</code>
     * @return El valor de <code>productosBodega</code>
     */
    public ArrayList<Producto> getProductosBodega() {
        return productosBodega;
    }

    /**
     * Función que permite modificar el valor de <code>productosBodega</code>
     * @param productosBodega modificado desde el ingreso del Usuario
     */

    public void setProductosBodega(ArrayList<Producto> productosBodega) {
        this.productosBodega = productosBodega;
    }
}
