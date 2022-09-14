package CarritoCompra;
/**
 * Clase Tienda
 * @author Grupo Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */

public class Usuario {
    /**Campo que almacena en un formato String el valor de <code>nombre</code> */
    private String nombre;
    /**Campo que almacena en un formato String el valor de <code>numTelf</code> */
    private String numTelf;
    /**Campo que almacena en un formato String el valor de <code>cedula</code> */
    private String cedula;
    /**Campo que almacena en un formato String el valor de <code>correoElectronico</code> */
    private String correoElectronico;

    /**
     * Constructor que inicia los valores para el objeto <code>Usuario</code>
     */
    public Usuario() {
        this.nombre = nombre;
        this.numTelf = numTelf;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Función que permite obtener el valor de <code>nombre</code>
     * @return El valor de <code>nombre</code>
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Función que permite modificar el valor de <code>nombre</code>
     * @param nombre modificado desde el ingreso del Usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Función que permite obtener el valor de <code>numTelf</code>
     * @return El valor de <code>numTelf</code>
     */
    public String getNumTelf() {
        return numTelf;
    }

    /**
     * Función que permite modificar el valor de <code>numTelf</code>
     * @param numTelf modificado desde el ingreso del Usuario
     */
    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }

    /**
     * Función que permite obtener el valor de <code>cedulaa</code>
     * @return El valor de <code>cedula</code>
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Función que permite modificar el valor de <code>cedula</code>
     * @param cedula modificado desde el ingreso del Usuario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Función que permite obtener el valor de <code>correoElectronico</code>
     * @return El valor de <code>correoElectronico</code>
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Función que permite modificar el valor de <code>correoElectronico</code>
     * @param correoElectronico modificado desde el ingreso del Usuario
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Imprime el tipo de objeto específico de <code>Usuario</code>
     * @return un String del objeto con sus especificaciones
     */
    public String toString(){
        return "Nombre: "+this.nombre+" Cédula: "+this.cedula +" Correo: "+this.correoElectronico +" Número de teléfono: "+this.numTelf;
    }
}
