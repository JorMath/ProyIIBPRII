package CarritoCompra;
/**Biblioteca importante para la creacion de interfaz grafica*/
import javax.swing.*;
/**Biblioteca importante para tener control visual en la interfaz grafica*/
import java.awt.*;
/**Biblioteca importante para generar eventos en respuesta a las acciones del usuario*/
import java.awt.event.ActionEvent;
/**Biblioteca importante para generar eventos en respuesta a las acciones del usuario*/
import java.awt.event.ActionListener;
/**Biblioteca importante  para hacer coincidir secuencias de caracteres con patrones especificados por expresiones regulares*/
import java.util.regex.*;
/**Biblioteca importante para generar eventos de teclado en respuesta a las acciones del usuario*/
import java.awt.event.KeyAdapter;
/**Biblioteca importante para generar eventos de teclado en respuesta a las acciones del usuario*/
import java.awt.event.KeyEvent;

/**
 * Clase UsuarioGui
 * {@inheritDoc}
 * @author Grupo Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class UsuarioGUI extends JDialog {
    /**Campo que almacena en un formato JTextField el valor de <code>textFieldNombre</code> */
    private JTextField textFieldNombre;
    /**Campo que almacena en un formato JTextField el valor de <code>textFieldCorreoElectronico</code> */
    private JTextField textFieldCorreoElectronico;
    /**Campo que almacena en un formato JTextField el valor de <code>textFielTelefono</code> */
    private JTextField textFielTelefono;
    /**Campo que almacena en un formato JTextField el valor de <code>textFieldCedula</code> */
    private JTextField textFieldCedula;

    /**Campo que almacena en un formato JButton el valor de <code>btnIrAlCarrito</code> */
    private JButton btnIrAlCarrito;
    /**Campo que almacena en un formato JButton el valor de <code>btnCancelar</code> */
    private JButton btnCancelar;
    /**Campo que almacena en un formato JPanel el valor de <code>registroPanel</code> */
    private JPanel registroPanel;
    /**Campo que almacena en un String un nombre de la GUI de forma temporal*/

    String nombre = "";
    /**Campo que almacena en un String un correo de la GUI de forma temporal*/
    String correo = "";
    /**Campo que almacena en un String un celular de la GUI de forma temporal*/
    String celular = "";
    /**Campo que almacena en un String una cédula de identidad de la GUI de forma temporal*/
    String cedula = "";

    /**
     * Constructor que manera la GUI de <code>UsuarioGUI</code>, aquí se configuran distintos métodos para la implementación de la ventana
     * Y que sea amigable con el usuario
     * @param parent el contenedor que almacena todas las configuraciones
     * @see Frame
     * @see JFrame
     * @see JTextField
     * @see JDialog
     * @see JButton
     * @see JTextArea
     * @see ActionListener
     * @see KeyAdapter
     */
    public UsuarioGUI(JFrame parent) {
        super(parent);
        setTitle("Ventana Cliente");
        setContentPane(registroPanel);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /**
         * Se agrega al botón de "Agregar al Carrito" un ActionListener
         * Recibe el texto de la GUI para el nombre y se almacena, si los textos están vacíos y sin llenar,
         *  lanzará una excepción, luego se comprueba el email y la cédula que cumpla con ciertos requisitos
         *  si no se cumplen, entonces lanza de nuevo excepciones, si cumple, se asignan a los setter de <code>usuarioTienda</code>
         *  los valores correspondientes, y se abre la siguiente ventana, que es <code>CarritoGUI</code>
         * @see Exception
         * @see JTextField
         * @see Override
         */
        btnIrAlCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nombre = textFieldNombre.getText();
                    cedula = textFieldCedula.getText();
                    correo = textFieldCorreoElectronico.getText();
                    celular = textFielTelefono.getText();
                    if (nombre.equals("") || cedula.equals("") || correo.equals("") || celular.equals("")) {
                        throw new Exception();
                    }
                    else {
                        if(!valida(textFieldCedula.getText())){
                            throw new Exception();
                        }
                        if(!emailValidacion(textFieldCorreoElectronico.getText())){
                            throw new Exception();
                        }
                        else {
                            Data.usuarioTienda.setNombre(nombre);
                            Data.usuarioTienda.setCedula(cedula);
                            Data.usuarioTienda.setCorreoElectronico(correo);
                            Data.usuarioTienda.setNumTelf(celular);
                            CarritoGUI carritoGUI = new CarritoGUI(null);
                            carritoGUI.setVisible(true);
                        }
                    }
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "Ingresa correctamente los datos, estos se validan");
                }
            }
        });
        /**
         * Botón que hace que el programa finalice, simplemente al hacer clic el sistema se detiene
         * @see Override
         * @see System
         */
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        /**
         * TextField que contiene un KeyListener, este permite simplemente escribir solo números y no letras, y escribir un
         * texto de números de longitud máxima de un número de teléfono
         * @see KeyEvent
         * @see KeyAdapter
         */
        textFielTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char num = e.getKeyChar();
                if(num<'0' || num >'9') e.consume();

                if(textFielTelefono.getText().length() >=10) {
                    e.consume();
                }
            }
        });
        /**
         * TextField que contiene un KeyListener, este permite que al nombre se pueda escribir simplemente letras,
         * nada de números y también permite escribir espacios
         * @see KeyEvent
         * @see KeyAdapter
         */
        textFieldNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char tecla;
                tecla = e.getKeyChar();
                if(!Character.isLetter(tecla)&&tecla!= KeyEvent.VK_SPACE&&tecla!=KeyEvent.VK_SPACE){
                    e.consume();
                }
            }
        });
    }

    /**
     * Método que verifica la cédula ecuatoriana mediante matemática modular
     * @param cedula Recibe como parámetro un String de cédula de Identidad de la GUI
     * @return <ul>
     *     <li> true si la cédula es ecuatoriana y se escribe correctamente</li>
     *     <li> false si la cédula no es ecuatoriana </li>
     *     </ul>
     */
    public static boolean valida (String cedula){
        int suma = 0;
        if (cedula.length() == 9) {
            return false;
        } else {
            int a[] = new int[cedula.length() / 2];
            int b[] = new int[(cedula.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < cedula.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(cedula.charAt(c)));
                c = c + 2;
                if (i < (cedula.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(cedula.charAt(d)));
                    d = d + 2;
                }
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1))))
                return true;
            else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Método que ayuda a validar una dirección de correo electrónico
     * @param correoElectronico recibe de la GUI un String para validar un correo electrónico
     * @return <ul>
     *     <li>true si cumple con la expresión regular de un correo electrónico, es decir, cadena de texto, un arroba, un punto
     *     y la dirección</li>
     *     <li>false si no cumple con la expresión regular y no encuentra coincidencias</li>
     *     </ul>
     * @see java.util.regex.Pattern
     * @see java.util.regex.Matcher
     */
    public static boolean emailValidacion(String correoElectronico){
        String regex = "^(.+)@(.+)$";
        Pattern patron = Pattern.compile(regex);
        Matcher coincidencia = patron.matcher(correoElectronico);
        return coincidencia.matches();
    }

}
