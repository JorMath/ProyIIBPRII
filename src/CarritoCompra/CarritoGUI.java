package CarritoCompra;
/**Biblioteca importante para la creacion de interfaz grafica*/
import javax.swing.*;
/**Biblioteca importante para la creacion de una tabla en la interfaz grafica */
import javax.swing.table.DefaultTableModel;
/**Biblioteca importante para tener control visual en la interfaz grafica*/
import java.awt.*;
/**Biblioteca importante para generar eventos en respuesta a las acciones del usuario*/
import java.awt.event.ActionEvent;
/**Biblioteca importante para generar eventos en respuesta a las acciones del usuario*/
import java.awt.event.ActionListener;
/**Biblioteca importante para permitir la escritura en un archivo*/
import java.awt.event.KeyAdapter;
import java.io.FileWriter;
/**Biblioteca importante para manejar las Excepciones de entrada y salida */
import java.io.IOException;
/**Biblioteca importante para imprimir representaciones formateadas de objetos en un flujo de salida de texto*/
import java.io.PrintWriter;


/**
 * Clase CarritoGUI
 * {@inheritDoc}
 * @author Grupo 8 Programacion II GR3SW
 * @since 1 de septiembre de 2022
 * @version 1.0.0.0
 */
public class CarritoGUI extends JDialog {
    /**Campo que almacena en un formato JButton el valor de <code>btnAgregar</code> */
    private JButton btnAgregar;
    /**Campo que almacena en un formato JButton el valor de <code>btnComprar</code> */
    private JButton btnComprar;
    /**Campo que almacena en un formato JButton el valor de <code>btnLimpiarTexto</code> */
    private JButton btnLimpiarTexto;
    /**Campo que almacena en un formato JButton el valor de <code>btnEliminarProducto</code> */
    private JButton btnEliminarProducto;
    /**Campo que almacena en un formato JButton el valor de <code>btnSalir</code> */
    private JButton btnSalir;

    /**Campo que almacena en un formato JLabel el valor de <code>labelCodigo</code> */
    private JLabel labelCodigo;
    /**Campo que almacena en un formato JLabel el valor de <code>labelCantidadProducto</code> */
    private JLabel labelCantidadProducto;
    /**Campo que almacena en un formato JLabel el valor de <code>labelMostradorProducto</code> */
    private JLabel labelMostradorProducto;

    /**Campo que almacena en un formato JTextField el valor de <code>txtFldCodigoProducto</code> */
    private JTextField txtFldCodigoProducto;
    /**Campo que almacena en un formato JTextField el valor de <code>txtFldCantidadProducto</code> */
    private JTextField txtFldCantidadProducto;

    /**Campo que almacena en un formato JPanel el valor de <code>PanelCarrito</code> */
    private JPanel PanelCarrito;
    /**Campo que almacena en un formato JTable el valor de <code>table1</code> */
    private JTable table1;
    /**Campo que almacena en un formato JTextArea el valor de <code>areaProductos</code> */
    private JTextArea areaProductos;
    /**Campo que almacena en un formato JScrollPane el valor de <code>sc</code> */
    private JScrollPane sc;
    /**Campo que almacena en un formato JScrollPane el valor de <code>tabla</code> */
    private JScrollPane tabla;

    /**Campo que almacena en un formato Double el valor de <code>sumaSubtotalPrecios</code> */
    double sumaSubtotalPrecios = 0;
    /**Campo que almacena en un formato Double el valor de <code>sumaIvaPrecios</code> */
    double sumaIvaPrecios = 0;
    /**Campo que almacena en un formato Double el valor de <code>sumaTotalPrecios</code> */
    double sumaTotalPrecios = 0;
    /**Campo que almacena en un formato Double el valor de <code>IVA</code> */
    final double IVA = 0.12;

    /**Campo que almacena en un formato int el valor de <code>validadorCantidad</code> */
    int validadorCantidad = 0;
    /**Campo que almacena en un formato boolean el valor de <code>verificarCodigo</code> */
    boolean verificarCodigo = false;
    /**Campo que almacena en un formato int el valor de <code>cantidadAComprar</code> */
    int cantidadAComprar = 0;
    /**Campo que almacena en un formato int el valor de <code>cantidadARestar</code> */
    int cantidadARestar = 0;

    /**
     * Método que ayuda a crear una tabla de datos que muestra los datos más generales del producto cuando se agrega
     * @see DefaultTableModel
     */
    private void createTable(){
        table1.setModel(new DefaultTableModel(
                null,new String[]{"Codigo", "Nombre", "Cantidad", "Precio", "Total"}
        ));
    }

    /**
     * Método que permite el agregar los productos al textArea, de esta manera el usuario puede observar a tiempo actualizado las existencias del producto
     * a medida que se van agregando. Este no se puede modificar por el usuario. Para evitar que se vea mal el área de texto
     * @see JTextArea
     */
    private void loadInvertar(){
                areaProductos.setText("");
        for (Producto producto:
             Data.productos) {
            areaProductos.append("Productos" + producto + "\n");
            //System.out.println(producto);
        }
    }
    /**
     * Constructor que manera la GUI de <code>CarritoGUI</code>, aquí se configuran distintos métodos para la implementación de la ventana
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
    public CarritoGUI(JFrame parent) {
        super(parent);
        setTitle("Compra");
        setContentPane(PanelCarrito);
        setMinimumSize(new Dimension(1400, 600));
        createTable();
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadInvertar();
        /**
         /**
         * Botón que hace que el programa finalice, simplemente al hacer clic el sistema se detiene
         * @see Exception
         * @see JTextField
         * @see Override
         */
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        /**
         * Se agrega al botón de "Limpiar Texto" en un ActionListener
         * Este borra el texto escrito en txtFldCodigoProducto y txtFldCantidadProducto
         * @see Exception
         * @see JTextField
         * @see Override
         */
        btnLimpiarTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnLimpiarTexto) {
                    txtFldCantidadProducto.setText("");
                    txtFldCodigoProducto.setText("");
                }
            }
        });
        /**
         * Se agrega al botón de "Agregar" en un ActionListener
         * Hace las siguientes validaciones si existe la cantidad ingresada por teclado y el código del producto es
         * correcto coloca el producto en la JTable caso contrario lanzará una Exception para que vuelva a ingresar
         * los datos de manera correcta, finalmente se disminuye la cantidad de productos existentes.
         * Verifica las cantidades ingresadas para cada producto, así como el código, esto haciendo cálculos llama
         * a los setters del producto a venderse, de esta manera igualmente se declaran variables auxiliares que
         * permitan la validación de lo que ingresa el usuario, como su respectiva captura de excepciones
         * @see Exception
         * @see JTextField
         * @see JTable
         * @see Override
         */
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    validadorCantidad = Integer.parseInt(txtFldCantidadProducto.getText());
                    if(validadorCantidad<=0){
                        throw new NumberFormatException();
                    }
                    if(txtFldCodigoProducto.getText().equals("")){
                        throw new NumberFormatException();
                    }
                    for(int i = 0; i< Data.productos.size(); i++){
                        if(txtFldCodigoProducto.getText().equals(Data.productos.get(i).getCodigoProducto())){
                            verificarCodigo = true;
                            cantidadAComprar = validadorCantidad;
                            if(cantidadAComprar> Data.productos.get(i).getCantidadProducto()){
                                throw new NumberFormatException();
                            }
                            else {
                                Data.productos.get(i).setExistenciasProducto(Data.productos.get(i).getCantidadProducto() - cantidadAComprar);
                                sumaSubtotalPrecios = sumaSubtotalPrecios + Data.productos.get(i).getPrecioUnitario() * cantidadAComprar;
                                sumaIvaPrecios = sumaIvaPrecios + Data.productos.get(i).getPrecioUnitario() * cantidadAComprar * IVA;
                                double total = sumaSubtotalPrecios +sumaIvaPrecios;
                                Data.productosVendidos.get(i).setExistenciasProducto(Data.productosVendidos.get(i).getCantidadProducto() + cantidadAComprar);
                                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                                model.addRow(Data.productosVendidos.get(i).prodToArray(cantidadAComprar, total));
                            }
                        }
                    }
                    txtFldCodigoProducto.setText("");
                    txtFldCantidadProducto.setText("");
                    if(!verificarCodigo){
                        txtFldCodigoProducto.setText("");
                        txtFldCantidadProducto.setText("");
                        throw new NumberFormatException();
                    }
                    loadInvertar();
                }catch (NumberFormatException f){
                    JOptionPane.showMessageDialog(null,"Ingrese correctamente todo como se le pide");
                }
            }
        });
        /**
         * Se agrega al botón de "Eliminar" en un ActionListener
         * Hace las siguientes validaciones si existe la cantidad ingresada por teclado y el código del producto es
         * correcto elimina la cantidad del producto en la JTable caso contrario lanzará una Exception para que vuelva a ingresar
         * los datos de manera correcta, finalmente se aumenta la cantidad de productos existentes.
         * Para eliminar el producto se basa en la tabla de igual manera, se van actualizando los productos a tiempo real de que el
         * usuario ingresa datos
         * @see Exception
         * @see JTextField
         * @see JTable
         * @see Override
         */
        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    validadorCantidad = Integer.parseInt(txtFldCantidadProducto.getText());
                    if(validadorCantidad<=0){
                        throw new NumberFormatException();
                    }
                    if(txtFldCodigoProducto.getText().equals("")){
                        throw new NumberFormatException();
                    }
                    for(int i = 0; i< Data.productos.size(); i++){
                        if(txtFldCodigoProducto.getText().equals(Data.productos.get(i).getCodigoProducto())) {
                            verificarCodigo = true;
                            cantidadARestar = validadorCantidad;
                            if (cantidadARestar > Data.productosVendidos.get(i).getCantidadProducto()) {
                                throw new NumberFormatException();
                            } else {
                                sumaSubtotalPrecios = sumaSubtotalPrecios - Data.productos.get(i).getPrecioUnitario()*cantidadARestar;
                                sumaIvaPrecios = sumaIvaPrecios - Data.productos.get(i).getPrecioUnitario()*cantidadARestar * IVA;
                                Data.productos.get(i).setExistenciasProducto(Data.productos.get(i).getCantidadProducto() + cantidadARestar);
                                double total = sumaSubtotalPrecios+sumaIvaPrecios;
                                Data.productosVendidos.get(i).setExistenciasProducto(Data.productosVendidos.get(i).getCantidadProducto()-cantidadARestar);
                                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                                model.addRow(Data.productosVendidos.get(i).prodToArray(Data.productosVendidos.get(i).getCantidadProducto(), total));
                            }
                        }
                    }
                    txtFldCodigoProducto.setText("");
                    txtFldCantidadProducto.setText("");
                    if(!verificarCodigo){
                        txtFldCodigoProducto.setText("");
                        txtFldCantidadProducto.setText("");
                        throw new NumberFormatException();
                    }
                    loadInvertar();
                }catch (NumberFormatException f){
                    JOptionPane.showMessageDialog(null,"Ingresa todos los valores correctamente");
                }
            }
        });
        /**
         * Se agrega al botón de "Emitir Factura" en un ActionListener
         * Se crea un archivo.txt, en este se imprimen los productos agregados junto con el total y nombre del usuario y todos los datos generales
         * de la tienda.
         * Hace una validación, si se agregó mínimo un producto caso contrario lanzará una Exception
         * @see Exception
         * @see FileWriter
         * @see PrintWriter
         * @see Override
         * @see System
         */
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter archivo = null;
                PrintWriter escritor = null;
                String ruta = "C:\\Users\\jorma\\Desktop\\factura.txt";
                try {
                    for (int i = 0; i < Data.productosVendidos.size(); i++) {
                        if (Data.productosVendidos.get(i).getCantidadProducto() == 0) {
                            Data.productosVendidos.remove(i);
                        }
                    }
                    sumaTotalPrecios = sumaSubtotalPrecios + sumaIvaPrecios;
                    if(sumaTotalPrecios==0){
                        throw new IOException();
                    }
                    loadInvertar();
                    archivo = new FileWriter(ruta);
                    escritor = new PrintWriter(archivo);
                    archivo.flush();
                    escritor.println("==========FACTURA==========\n");
                    escritor.println(Data.tiendaGeneral.toString());
                    escritor.println(Data.usuarioTienda.toString());
                    for (int i = 0; i < Data.productosVendidos.size(); i++) {
                        escritor.println(Data.productosVendidos.get(i).toString());
                    }
                    escritor.println("Subtotal: "+sumaSubtotalPrecios);
                    escritor.println("IVA 12%: "+sumaIvaPrecios);
                    escritor.println("Total: "+sumaTotalPrecios);
                    escritor.println("¡Gracias Por su Compra!");
                } catch (IOException f) {
                    JOptionPane.showMessageDialog(null,"Asegúrate de ingresar productos antes de emitir una factura");
                    System.exit(0);
                } finally {
                    try {
                        if (archivo != null) {
                            archivo.close();
                        }
                        if (escritor != null) {
                            escritor.close();
                        }
                        JOptionPane.showMessageDialog(null,"Gracias, Se ha generado una factura!");
                        dispose();
                        System.exit(0);
                    } catch (IOException g) {
                        JOptionPane.showMessageDialog(null,"Error, no se ha generado una factura");
                    }
                }
            }
        });
    }

}

