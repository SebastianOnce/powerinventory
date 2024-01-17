package proyecto_final2024.newpackageControlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.Conexion;
import proyecto_final2024.newpackageModelo.ModeloProducto;
import proyecto_final2024.newpackageModelo.Producto;
import proyecto_final2024.newpackageVista.VistaProducto;

/**
 *
 * @author elshi
 *///
public class controladorProducto {

    private VistaProducto vista;
    static public String id_categ;
    static public String codigoBuscar;

    public Socket s;
    public ServerSocket ssk;
    public InputStreamReader isr;
    public BufferedReader br;
    public String mensaje;

    public controladorProducto(VistaProducto vista) {
        this.vista = vista;
        vista.setVisible(true);
        this.vista.setBorder(null);
        this.vista.setLocation(0, -23);
        ModeloProducto.cargarBoxes(vista);
        
    }

    public void iniciarControl() {
        listaProductos();
        vista.getTxtcodigoproducto().setEditable(false);
        vista.getBtnCREAR().addActionListener(l -> abrirDialogo(true));
        vista.getBtnMODIFICAR().addActionListener(l -> abrirDialogo(false));
        vista.getBtnELIMINAR().addActionListener(l -> EliminarProducto());
        vista.getBtnGuardar().addActionListener(l -> CrearModificarProducto());
        vista.getBtnBUSCAR().addActionListener(l -> buscarProducto());
        vista.getBtnSalir().addActionListener(l -> salir());
        vista.getTblproductos().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                llenarCampos();
            }
        });

        vista.getTxtBUSCAR().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                codigoBuscar = "" + vista.getTxtBUSCAR().getText();
                List<Producto> miListaPro = ModeloProducto.BuscarProducto();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
                mTabla.setRowCount(0);
                miListaPro.forEach(pro -> {
                    String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getDescripcion_producto(), String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getId_proveedor(),
                        pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta()), pro.getCodigo_barras()};
                    mTabla.addRow(rowData);
                });
            }
        });
        leercodigodeBarras(true);
    }

    private void abrirDialogo(boolean nuevo) {
//        lipiar();
        if (nuevo) {
            vista.getjDialog1().setTitle("Crear nuevo producto");
        } else if (!nuevo) {
            vista.getjDialog1().setTitle("Editar producto");
            llenarCampos();
        }
        vista.getjDialog1().setLocationRelativeTo(vista);
        vista.getjDialog1().setSize(600, 600);
        vista.getjDialog1().setVisible(true);
        vista.getjDialog1().setLocationRelativeTo(null);
    }

    public void CrearModificarProducto() {
        if (vista.getjDialog1().getTitle().contentEquals("Crear nuevo producto")) {
            String disp = "";
            if (vista.getChbdisponibilidad().isSelected()) {
                disp = "si";
            } else {
                disp = "no";
            }
            String nombre_producto = vista.getTxtnombre().getText();
            String id_proveedor = vista.getCbcodigoproveedor().getSelectedItem().toString().split("-", 2)[0];
            String descripcion_producto = vista.getTxtdescripcion().getText();
            String cantidad_en_bodega = vista.getTxtcantidadbodega().getText();
            String disponibilidad = disp;
            String id_categoria = vista.getCbcategoria().getSelectedItem().toString().split("-", 2)[0];;
            String precio_de_compra = vista.getTxtpreciocompra().getText();
            String precio_de_venta = vista.getTxtprecioVenta().getText();
            String codigoBarras = vista.getTxtcodigobarras().getText();

            ModeloProducto producto = new ModeloProducto();

            producto.setNombre_producto(nombre_producto);
            producto.setId_proveedor(id_proveedor);
            producto.setDescripcion_producto(descripcion_producto);
            producto.setCantidad_en_bodega(Integer.valueOf(cantidad_en_bodega));
            producto.setDisponibilidad(disponibilidad);
            producto.setId_categoria(id_categoria);
            producto.setPrecio_de_compra(Float.valueOf(precio_de_compra));
            producto.setPrecio_de_venta(Float.valueOf(precio_de_venta));
            producto.setCodigo_barras(codigoBarras);

            if (producto.CrearProducto() == null) {
                JOptionPane.showMessageDialog(vista, "Producto creado exitosamente");
                vaciarFields();
                listaProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al crear producto");
            }
        } else if (vista.getjDialog1().getTitle().contentEquals("Editar producto")) {
            String disp = "";
            if (vista.getChbdisponibilidad().isSelected()) {
                disp = "si";
            } else {
                disp = "no";
            }
            String id_producto = vista.getTxtcodigoproducto().getText();
            String nombre_producto = vista.getTxtnombre().getText();
            String id_proveedor = vista.getCbcodigoproveedor().getSelectedItem().toString().split("-", 2)[0];
            String descripcion_producto = vista.getTxtdescripcion().getText();
            String cantidad_en_bodega = vista.getTxtcantidadbodega().getText();
            String disponibilidad = disp;
            String id_categoria = vista.getCbcategoria().getSelectedItem().toString().split("-", 2)[0];;
            String precio_de_compra = vista.getTxtpreciocompra().getText();
            String precio_de_venta = vista.getTxtprecioVenta().getText();
            String codigoBarras = vista.getTxtcodigobarras().getText();

            ModeloProducto producto = new ModeloProducto();

            producto.setId_producto(id_producto);
            producto.setNombre_producto(nombre_producto);
            producto.setId_proveedor(id_proveedor);
            producto.setDescripcion_producto(descripcion_producto);
            producto.setCantidad_en_bodega(Integer.valueOf(cantidad_en_bodega));
            producto.setDisponibilidad(disponibilidad);
            producto.setId_categoria(id_categoria);
            producto.setPrecio_de_compra(Float.valueOf(precio_de_compra));
            producto.setPrecio_de_venta(Float.valueOf(precio_de_venta));
             producto.setCodigo_barras(codigoBarras);

            if (producto.modificarProducto() == null) {
                JOptionPane.showMessageDialog(vista, "Producto modificado exitosamente");
                vaciarFields();
                listaProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar producto");
            }
        }

    }

    public void EliminarProducto() {
        int i = vista.getTblproductos().getSelectedRow();;
        if (i >= 0) {
            String id = vista.getTblproductos().getValueAt(i, 0).toString();
            ModeloProducto producto = new ModeloProducto();
            producto.setId_producto(id);
            int opcion = JOptionPane.showConfirmDialog(vista,
                    "¿Estás seguro que deseas eliminar este producto?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                if (producto.eliminarProducto() == null) {
                    JOptionPane.showMessageDialog(vista, "Producto eliminado exitosamente");
                    listaProductos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar producto");
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Primero elige una fila");
        }
    }

    public void vaciarFields() {
        vista.getTxtcodigoproducto().setText("");
        vista.getTxtnombre().setText("");
        vista.getCbcodigoproveedor().setSelectedIndex(0);
        vista.getTxtdescripcion().setText("");
        vista.getTxtcantidadbodega().setText("");
        vista.getChbdisponibilidad().setSelected(false);
        vista.getCbcategoria().setSelectedIndex(0);
        vista.getTxtpreciocompra().setText("");
        vista.getTxtprecioVenta().setText("");
        vista.getTxtcodigobarras().setText("");
    }

    public void listaProductos() {
        List<Producto> listap = ModeloProducto.listaProductos();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(pro -> {
            String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getDescripcion_producto(), String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getId_proveedor(),
                pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta()), pro.getCodigo_barras()};
            mTabla.addRow(rowData);
        });
    }

    public void llenarCampos() {
        int i = vista.getTblproductos().getSelectedRow();
        if (i >= 0) {
            boolean disp = false;
            if ((vista.getTblproductos().getValueAt(i, 4).toString()).equals("si")) { // if necesario para determinar si el check box debe seleccionarse o no
                disp = true;
            }
            vista.getTxtcodigoproducto().setText(vista.getTblproductos().getValueAt(i, 0).toString());
            vista.getTxtnombre().setText(vista.getTblproductos().getValueAt(i, 1).toString());
            vista.getCbcodigoproveedor().setSelectedItem(vista.getTblproductos().getValueAt(i, 5).toString());
            vista.getTxtdescripcion().setText(vista.getTblproductos().getValueAt(i, 2).toString());
            vista.getTxtcantidadbodega().setText(vista.getTblproductos().getValueAt(i, 3).toString());
            vista.getChbdisponibilidad().setSelected(disp);
            vista.getCbcategoria().setSelectedItem(vista.getTblproductos().getValueAt(i, 6).toString());
            vista.getTxtpreciocompra().setText(vista.getTblproductos().getValueAt(i, 7).toString());
            vista.getTxtprecioVenta().setText(vista.getTblproductos().getValueAt(i, 8).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Primero elige una fila");
        }

    }

    private void actualizarTabla(List<Producto> productos) {
        DefaultTableModel mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
        mTabla.setNumRows(0); // Limpiar la tabla

        productos.forEach(pro -> {
            String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getDescripcion_producto(),
                String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getId_proveedor(),
                pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta())};
            mTabla.addRow(rowData);
        });
    }

    public void buscarProducto() {
        codigoBuscar = vista.getTxtBUSCAR().getText();
        List<Producto> listap = ModeloProducto.BuscarProducto();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(pro -> {
            String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getDescripcion_producto(), String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getId_proveedor(),
                pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta()),pro.getCodigo_barras()};
            mTabla.addRow(rowData);
        });
    }
    
    public void leercodigodeBarras(Boolean activo) {
        if (activo == true) {
            vaciarFields();
            new Thread(() -> {
            try {
                System.out.println("entro");
                ssk = new ServerSocket(8000);

                while (true) {
                    s = ssk.accept();
                    isr = new InputStreamReader(s.getInputStream());
                    br = new BufferedReader(isr);
                    mensaje = br.readLine();

                    System.out.println(mensaje);
                    if (vista.getTxtBUSCAR().getText().equals("")) {
                        vista.getTxtBUSCAR().setText(mensaje);
                        codigoBuscar = vista.getTxtBUSCAR().getText();
                    } else if(!vista.getTxtBUSCAR().getText().equals("")){
                        vista.getTxtBUSCAR().setText("");
                        vista.getTxtBUSCAR().setText(mensaje);
                        codigoBuscar = vista.getTxtBUSCAR().getText();
                    }
                    if(vista.getjDialog1().getTitle().contentEquals("Editar producto")) {
                         vista.getTxtcodigobarras().setText(mensaje);
                    }else if (vista.getjDialog1().getTitle().contentEquals("Crear nuevo producto")) {
                        vista.getTxtcodigobarras().setText(mensaje);
                    }
                    System.out.println("salio");
                }

            } catch (IOException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        }).start();
        }
    }
    
    public void salir(){
        leercodigodeBarras(false);
        vista.dispose();
    }
}
