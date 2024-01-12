/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
        vista.getBtnCREAR().addActionListener(l -> CrearProducto());
        vista.getBtnMODIFICAR().addActionListener(l -> ModificarProducto());
        vista.getBtnELIMINAR().addActionListener(l -> EliminarProducto());
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
                pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta())};
            mTabla.addRow(rowData);
                });
            }
        });
    }

    public void CrearProducto() {
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

        ModeloProducto producto = new ModeloProducto();

        producto.setNombre_producto(nombre_producto);
        producto.setId_proveedor(id_proveedor);
        producto.setDescripcion_producto(descripcion_producto);
        producto.setCantidad_en_bodega(Integer.valueOf(cantidad_en_bodega));
        producto.setDisponibilidad(disponibilidad);
        producto.setId_categoria(id_categoria);
        producto.setPrecio_de_compra(Float.valueOf(precio_de_compra));
        producto.setPrecio_de_venta(Float.valueOf(precio_de_venta));

        if (producto.CrearProducto() == null) {
            JOptionPane.showMessageDialog(vista, "Producto creado exitosamente");
            vaciarFields();
            listaProductos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al crear producto");
        }

    }

    public void ModificarProducto() {
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

        if (producto.modificarProducto() == null) {
            JOptionPane.showMessageDialog(vista, "Producto modificado exitosamente");
            vaciarFields();
            listaProductos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al modificar producto");
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
    }

    public void listaProductos() {
        List<Producto> listap = ModeloProducto.listaProductos();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(pro -> {
            String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getDescripcion_producto(), String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getId_proveedor(),
                pro.getId_categoria(), String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta())};
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

    public void salir(){
        vista.dispose();
    }
}
