package CarritoCompra;
/**Biblioteca importante para realizar conexiones y transacciones a través de la red*/
import java.net.*;
/**Biblioteca importante para realizar gestionar las operaciones de entrada y salida*/
import java.io.*;
/**
 * Clase ServidorProductos
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 * La clase servidor productos se compone del uso de Socket's, de esta manera se asegura la conexión a otra computadora
 * Por medio de la misma conexión a internet
 * Se seleccionó el puerto 12500.
 */
public class ServidorProductos {
    /**
     * Se compone de BufferedInputStream y BufferedOutputStream
     * De igual manera mientras el socket no se cierre el servidor recibe los datos en bytes
     * Con la lectura del método readUTF, se escriben luego los datos en <code>datosSalida</code>
     * para la ruta del archivo se hace uso de subString, que inicie desde el directorio de C:\\
     * De esa manera lee correctamente los archivos
     * @see String
     * Mientras no haya más datos que escribir, luego soltará un mensaje que diga "Datos cargados exitosamente"
     * Para luego cerrar los sockets y en su totalidad lo que implique.
     */
    public static void main() {
        ServerSocket server;
        Socket conexion;
        BufferedInputStream datosEntrada;
        BufferedOutputStream datosSalida;
        byte[] datosRecibidos;
        int entrada;
        String rutaArchivo;
        try{
            server = new ServerSocket(12500);
            while(true){
                conexion = server.accept();
                datosRecibidos = new byte[1024];
                datosEntrada = new BufferedInputStream(conexion.getInputStream());
                DataInputStream datosIn = new DataInputStream(conexion.getInputStream());
                rutaArchivo = datosIn.readUTF();
                rutaArchivo = rutaArchivo.substring(rutaArchivo.indexOf('\\')+1,rutaArchivo.length());
                datosSalida = new BufferedOutputStream(new FileOutputStream(rutaArchivo));
                while((entrada = datosEntrada.read(datosRecibidos))!=-1){
                    datosSalida.write(datosRecibidos,0,entrada);
                }
                System.out.println("Datos cargados existosamente");
                datosEntrada.close();
                datosSalida.close();
                datosIn.close();
                server.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
