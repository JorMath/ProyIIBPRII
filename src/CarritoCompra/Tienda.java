package CarritoCompra;
/**
 * Clase Tienda
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */

public class Tienda {
    /**Campo que almacena en un formato String el valor de <code>nombreTienda</code> */
    private String nombreTienda;
    /**Campo que almacena en un formato String el valor de <code>direccionTienda</code> */
    private String direccionTienda;
    /**Campo que almacena en un formato String el valor de <code>nombreTienda</code> */
    private String numTelfTienda;
    /**Campo que almacena en un tipo Bodega el valor de <code>bodegaTienda</code> */
    private Bodega bodegaTienda;
    /**Campo que almacena en un tipo Usuario el valor de <code>usuarioTienda</code> */
    private Usuario usuarioTienda;

    /**
     * Constructor que inicia los valores para el objeto <code>Tienda</code>
     * @param  bodegaTienda inicia el valor de <code>bodegaTienda</code>
     * @param  usuarioTienda inicia el valor de <code>usuarioTienda</code>
     */
    public Tienda(Bodega bodegaTienda, Usuario usuarioTienda) {
        this.nombreTienda = "SuperMarket CCP";
        this.direccionTienda = "Escuela Politécnica Nacional";
        this.numTelfTienda = "0982390699";
        this.bodegaTienda = bodegaTienda;
        this.usuarioTienda = usuarioTienda;
    }

    /**
     * Función que permite obtener el valor de <code>nombreTienda</code>
     * @return El valor de <code>nombreTienda</code>
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * Función que permite modificar el valor de <code>nombreTienda</code>
     * @param nombreTienda modificado desde el ingreso del Usuario
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    /**
     * Función que permite obtener el valor de <code>direccionTienda</code>
     * @return El valor de <code>direccionTienda</code>
     */
    public String getDireccionTienda() {
        return direccionTienda;
    }

    /**
     * Función que permite modificar el valor de <code>direccionTienda</code>
     * @param direccionTienda modificado desde el ingreso del Usuario
     */
    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    /**
     * Función que permite obtener el valor de <code>numTelfTienda</code>
     * @return El valor de <code>numTelfTienda</code>
     */
    public String getNumTelfTienda() {
        return numTelfTienda;
    }

    /**
     * Función que permite modificar el valor de <code>numTelfTienda</code>
     * @param numTelfTienda modificado desde el ingreso del Usuario
     */
    public void setNumTelfTienda(String numTelfTienda) {
        this.numTelfTienda = numTelfTienda;
    }

    /**
     * Función que permite obtener el valor de <code>bodegaTienda</code>
     * @return El valor de <code>bodegaTienda</code>
     */
    public Bodega getBodegaTienda() {
        return bodegaTienda;
    }

    /**
     * Función que permite modificar el valor de <code>bodegaTienda</code>
     * @param bodegaTienda modificado desde el ingreso del Usuario
     */
    public void setBodegaTienda(Bodega bodegaTienda) {
        this.bodegaTienda = bodegaTienda;
    }

    /**
     * Función que permite obtener el valor de <code>usuarioTienda</code>
     * @return El valor de <code>usuarioTienda</code>
     */
    public Usuario getUsuarioTienda() {
        return usuarioTienda;
    }

    /**
     * Función que permite modificar el valor de <code>usuarioTienda</code>
     * @param usuarioTienda modificado desde el ingreso del Usuario
     */
    public void setUsuarioTienda(Usuario usuarioTienda) {
        this.usuarioTienda = usuarioTienda;
    }


    /**
     * Imprime el tipo de objeto específico de <code>Tienda</code>
     * @return un String del objeto con sus especificaciones
     */
    public String toString(){
        return this.nombreTienda + "\n"+this.direccionTienda+"\n"+this.numTelfTienda+"\n";
    }
}
