package CarritoCompra;
/**Biblioteca importante para permitir que los objetos sean serializables */
import java.io.Serializable;
/**
 * Clase Producto
 * @author Grupo Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class Producto implements Serializable {
    /**Campo que almacena en un formato String el valor de <code>nombreProducto</code> */
    private String nombreProducto;
    /**Campo que almacena en un formato String el valor de <code>codigoProducto</code> */
    private String codigoProducto;
    /**Campo que almacena en un formato String el valor de <code>tipoProducto</code> */
    private String tipoProducto;
    /**Campo que almacena en un formato String el valor de <code>precioUnitario</code> */
    private double precioUnitario;
    /**Campo que almacena en un formato String el valor de <code>existenciasProducto</code> */
    private int existenciasProducto;

    /**
     * Constructor que inicia los valores para el objeto <code>Producto</code>
     * @param  nombreProducto inicia el valor de <code>nombreProducto</code>
     * @param  codigoProducto inicia el valor de <code>codigoProducto</code>
     * @param  tipoProducto inicia el valor de <code>tipoProducto</code>
     * @param  precioUnitario inicia el valor de <code>precioUnitario</code>
     * @param  cantidadProducto inicia el valor de <code>cantidadProducto</code>
     */
    public Producto(String nombreProducto, String codigoProducto, String tipoProducto, double precioUnitario, int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.tipoProducto = tipoProducto;
        this.precioUnitario = precioUnitario;
        this.existenciasProducto = cantidadProducto;
    }

    /**
     * Función que permite obtener el valor de <code>nombreProducto</code>
     * @return El valor de <code>nombreProducto</code>
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Función que permite modificar el valor de <code>nombreProducto</code>
     * @param nombreProducto modificado desde el ingreso del Usuario
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Función que permite obtener el valor de <code>codigoProducto</code>
     * @return El valor de <code>codigoProducto</code>
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Función que permite modificar el valor de <code>codigoProducto</code>
     * @param codigoProducto modificado desde el ingreso del Usuario
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * Función que permite obtener el valor de <code>tipoProduct</code>
     * @return El valor de <code>tipoProduct</code>
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Función que permite modificar el valor de <code>tipoProducto</code>
     * @param tipoProducto modificado desde el ingreso del Usuario
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Función que permite obtener el valor de <code>precioUnitario</code>
     * @return El valor de <code>precioUnitario</code>
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Función que permite modificar el valor de <code>precioUnitario</code>
     * @param precioUnitario modificado desde el ingreso del Usuario
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Función que permite obtener el valor de <code>existenciasProducto</code>
     * @return El valor de <code>existenciasProducto</code>
     */
    public int getCantidadProducto() {
        return existenciasProducto;
    }

    /**
     * Función que permite modificar el valor de <code>existenciasProducto</code>
     * @param existenciasProducto modificado desde el ingreso del Usuario
     */
    public void setExistenciasProducto(int existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    /**
     * Método que permite en un String almacenar los valores de cada producto
     * @param cant guarda la cantidad que se ingresa por el usuario
     * @param total guarda el total de ese producto en específico para luego mostrarlo en una tabla
     * @return un arreglo de String
     */
    public String[] prodToArray(int cant, double total){
        return new String[]{codigoProducto, nombreProducto, String.valueOf(cant), String.valueOf(precioUnitario*existenciasProducto), String.valueOf(total)};
    }

    /**
     * Imprime el tipo de objeto específico de <code>Producto</code>
     * @return un String del objeto con sus especificaciones
     */
    public String toString(){
        return "Nombre: "+this.nombreProducto + " Codigo: "+codigoProducto+" Tipo: "+this.tipoProducto+" Precio: "+this.precioUnitario
        +" Cantidad: "+this.existenciasProducto;
    }

}
