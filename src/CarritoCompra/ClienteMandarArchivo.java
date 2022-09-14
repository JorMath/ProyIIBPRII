package CarritoCompra;
/**
 * Librería importante para establecer conexiones con sockets
 */

import java.net.*;
/**
 * Librería importante para establecer el manejo de archivos
 */

import java.io.*;

/**
 * Clase ClienteMandarArchivos
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class ClienteMandarArchivo {
    /**
     * Recibe un archivo en un directorio, en este caso simplemente en el disco C: de la computadora 2
     * Mediante uso del socket con el host de IPV4 y el puerto 12500 permite establecer una conexión correcta del socket
     * Para la conexión con el host revisar la terminal de Windows e ingresar el comando "ipconfig", encontrar la dirección iPv4 para configurar para otra pc
     * Al momento de sacar la información de la pc 2, se manda la información en un arreglo de bytes, hasta que no exista más contenido
     * Finalmente los sockets, los BufferedInputStream se cierran y se capturan las excepciones necesarias
     * @see DataInputStream
     * @see Socket
     * @see BufferedInputStream
     * @see BufferedOutputStream
     * @see IOException
     * @param args recibe lo anteriormente mencionado
     */
    public static void main(String[] args) {
        DataInputStream input;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        final String nombreArchivo = "C:\\productos.txt";
        try{
            final File archivo = new File(nombreArchivo);
            //para funcionar en otras pc's debe cambiarse el host
            Socket socketCliente = new Socket("192.168.1.3",12500);
            bis = new BufferedInputStream(new FileInputStream(archivo));
            bos = new BufferedOutputStream(socketCliente.getOutputStream());

            DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
            dos.writeUTF(archivo.getName());

            byteArray = new byte[8192];
            while((in = bis.read(byteArray))!=-1){
                bos.write(byteArray,0,in);
            }
            bis.close();
            bos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
