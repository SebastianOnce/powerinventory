/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.ModeloProducto;
import proyecto_final2024.newpackageModelo.Producto;
import proyecto_final2024.newpackageVista.VistaProducto;

/**
 *
 * @author elshi
 */
public class controladorProducto {

    private ModeloProducto modelo;
    private VistaProducto vista;

    public controladorProducto(ModeloProducto modelo, VistaProducto vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        
    }

    public void iniciarControl() {
        vista.getBtnCREAR().addActionListener(l -> CrearProducto());
        vista.getBtnMODIFICAR().addActionListener(l -> ModificarProducto());
        vista.getBtnELIMINAR().addActionListener(l -> EliminarProducto());
    }

    public void CrearProducto() {
        String disp = "";
        if (vista.getChbdisponibilidad().isSelected()) {
            disp = "si";
        } else {
            disp = "no";
        }
        String nombre_producto = vista.getTxtnombre().getText();
        String codigo_del_proveedor = vista.getCbcodigoproveedor().getSelectedItem().toString();
        String descripcion_producto = vista.getTxtdescripcion().getText();
        String cantidad_en_bodega = vista.getTxtcantidadbodega().getText();
        String disponibilidad = disp;
        String ruc_proveedor = vista.getCbRucproveedor().toString();
        String id_categoria = vista.getCbcategoria().getSelectedItem().toString();
        String precio_de_compra = vista.getTxtpreciocompra().getText();
        String precio_de_venta = vista.getTxtprecioVenta().getText();

        ModeloProducto producto = new ModeloProducto();

        producto.setNombre_producto(nombre_producto);
        producto.setCodigo_del_proveedor(codigo_del_proveedor);
        producto.setDescripcion_producto(descripcion_producto);
        producto.setCantidad_en_bodega(Integer.valueOf(cantidad_en_bodega));
        producto.setDisponibilidad(disponibilidad);
        producto.setRuc_proveedor(ruc_proveedor);
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
        int i = vista.getTblproductos().getSelectedRow();
        if (i >= 0) {
            boolean disp = false;
            if ((vista.getTblproductos().getValueAt(i, 5).toString()).equals("si")) { // if necesario para determinar si el check box debe seleccionarse o no
                disp = true;
            }
            vista.getTxtcodigoproducto().setText(vista.getTblproductos().getValueAt(i, 0).toString());
            vista.getTxtnombre().setText(vista.getTblproductos().getValueAt(i, 1).toString());
            vista.getCbcodigoproveedor().setSelectedItem(vista.getTblproductos().getValueAt(i, 2).toString());
            vista.getTxtdescripcion().setText(vista.getTblproductos().getValueAt(i, 3).toString());
            vista.getTxtcantidadbodega().setText(vista.getTblproductos().getValueAt(i, 4).toString());
            vista.getChbdisponibilidad().setSelected(disp);
            vista.getCbRucproveedor().setSelectedItem(vista.getTblproductos().getValueAt(i, 6).toString());
            vista.getCbcategoria().setSelectedItem(vista.getTblproductos().getValueAt(i, 7).toString());
            vista.getTxtpreciocompra().setText(vista.getTblproductos().getValueAt(i, 8).toString());
            vista.getTxtprecioVenta().setText(vista.getTblproductos().getValueAt(i, 9).toString());

            ModeloProducto producto = new ModeloProducto();

            producto.setNombre_producto(vista.getTxtnombre().getText());
            producto.setCodigo_del_proveedor(vista.getCbcodigoproveedor().getSelectedItem().toString());
            producto.setDescripcion_producto(vista.getTxtdescripcion().getText());
            producto.setCantidad_en_bodega(Integer.valueOf(vista.getTxtcantidadbodega().getText()));
            producto.setRuc_proveedor(vista.getCbRucproveedor().getSelectedItem().toString());
            producto.setId_categoria(vista.getCbcategoria().getSelectedItem().toString());
            producto.setPrecio_de_compra(Float.valueOf(vista.getTxtpreciocompra().getText()));
            producto.setPrecio_de_venta(Float.valueOf(vista.getTxtprecioVenta().getText()));

            if (producto.modificarProducto() == null) {
                JOptionPane.showMessageDialog(vista, "Producto modificado exitosamente");
                vaciarFields();
                listaProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al modificar producto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Primero elige una fila");
        }
    }

    public void EliminarProducto() {
        int i = vista.getTblproductos().getSelectedRow();;
        if (i >= 0) {
            String id = vista.getTblproductos().getValueAt(i, 0).toString();
            ModeloProducto producto = new ModeloProducto();
            producto.setId_producto(id);
            if (producto.eliminarProducto() == null) {
//                vista.getDlgPersona().setVisible(false);
                JOptionPane.showMessageDialog(vista, "Producto eliminado exitosamente");
                listaProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al eliminar producto");
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
        vista.getCbRucproveedor().setSelectedIndex(0);
        vista.getCbcategoria().setSelectedIndex(0);
        vista.getTxtpreciocompra().setText("");
        vista.getTxtprecioVenta().setText("");
    }
    
    public void listaProductos(){
        List<Producto> listap = ModeloProducto.listaProductos();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getTblproductos().getModel();
        mTabla.setNumRows(0);//limpio la tabla
        listap.stream().forEach(pro -> {
            String[] rowData = {pro.getId_producto(), pro.getNombre_producto(), pro.getCodigo_del_proveedor(), String.valueOf(pro.getDescripcion_producto()),
                String.valueOf(pro.getCantidad_en_bodega()), pro.getDisponibilidad(), pro.getRuc_proveedor(), pro.getRuc_proveedor(), pro.getId_categoria(),
                String.valueOf(pro.getPrecio_de_compra()), String.valueOf(pro.getPrecio_de_venta())};
            mTabla.addRow(rowData);
        });
    }

}
