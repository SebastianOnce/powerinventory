/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2024.newpackageControlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.ModeloFactura;
import proyecto_final2024.newpackageModelo.Producto;
import proyecto_final2024.newpackageModelo.Proveedor;
import static proyecto_final2024.newpackageControlador.controladorProveedor.cedulaCienteBuscado;
import proyecto_final2024.newpackageModelo.Conexion;
import proyecto_final2024.newpackageModelo.ModeloLogin;
import proyecto_final2024.newpackageVista.VistaFacrura;

/**
 *
 * @author USER
 */
public class ControladorFactura {

    VistaFacrura vista;

    static public String cedigo, nombre, apellido, cedula;
    static public String codigobarras, nombreProducto, precio, cantidad;
    static public String codigoBuscar, idFactura;
    public static int idproductoV, cantidadProductosV;

    public Socket s;
    public ServerSocket ssk;
    public InputStreamReader isr;
    public BufferedReader br;
    public String mensaje;

    public ControladorFactura(VistaFacrura vista) {
        this.vista = vista;
        this.vista.setVisible(true);
    }

    public void inicarControl() {
        listarProveedores();
        leercodigodeBarras();
        vista.getTxtcodigoFactura().setText(ModeloFactura.generarCodigoFacrura());
        vista.getTxtnombreAdmin().setText(ControladorLogin.usuariosaux);
        vista.getTxtcodigoAdmin().setText(ControladorLogin.id);
        
        vista.getTxtcodigoproducto().addActionListener(l -> obtenerProduto());
        vista.getBtnAbrirProductos().addActionListener(l -> buscarProductos());
        vista.getBtnbuscarcliente().addActionListener(l -> buscarClientes());
        vista.getBtnAceptarbCLIENTE().addActionListener(l -> enviarDatosCliente());
        vista.getBtnaceptarProductos().addActionListener(l -> enviarcodigoProducto());
        vista.getBtnanadir().addActionListener(l -> añadirProductos());
        vista.getQuitar().addActionListener(l -> eliminarproducto());
        vista.getBtnguardar().addActionListener(l -> crearEncabeszado());

    }

    public void buscarClientes() {
        listarProveedores();
        vista.getjDialogClientes().setLocationRelativeTo(vista);
        vista.getjDialogClientes().setSize(600, 600);
        vista.getjDialogClientes().setVisible(true);
        vista.getjDialogClientes().setLocationRelativeTo(null);
        vista.getTbClientes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vista.getTbClientes().getSelectedRow();
                cedigo = (vista.getTbClientes().getValueAt(i, 0).toString());
                nombre = (vista.getTbClientes().getValueAt(i, 1).toString());
                apellido = (vista.getTbClientes().getValueAt(i, 2).toString());
                cedula = (vista.getTbClientes().getValueAt(i, 3).toString());
            }
        });
        vista.getTxtfiltroClientes().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                cedulaCienteBuscado = "" + vista.getTxtfiltroClientes().getText();
                List<Proveedor> miListaPro = ModeloFactura.ProveedorBuscadp();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getTbClientes().getModel();
                mTabla.setRowCount(0);
                miListaPro.forEach(admin -> {
                    String[] rowData = {
                        admin.getId_proveedor(), admin.getNombres(), admin.getApellidos(), admin.getCedula()
                    };
                    mTabla.addRow(rowData);
                });
            }
        });
    }

    public void buscarProductos() {
        listarProductos();
        vista.getjDialogProductos().setLocationRelativeTo(vista);
        vista.getjDialogProductos().setSize(600, 600);
        vista.getjDialogProductos().setVisible(true);
        vista.getjDialogProductos().setLocationRelativeTo(null);
        vista.getTbProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vista.getTbProductos().getSelectedRow();
                codigobarras = (vista.getTbProductos().getValueAt(i, 0).toString());
                nombreProducto = (vista.getTbProductos().getValueAt(i, 1).toString());
                precio = (vista.getTbProductos().getValueAt(i, 2).toString());
                cantidad = (vista.getTbProductos().getValueAt(i, 3).toString());
            }
        });
        vista.getTxtfiltrarProducto().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                codigoBuscar = "" + vista.getTxtfiltrarProducto().getText();
                List<Producto> miListaPro = ModeloFactura.BuscarProducto();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getTbProductos().getModel();
                mTabla.setRowCount(0);
                miListaPro.stream().forEach(admin -> {
                    String[] rowData = {admin.getId_producto(), admin.getNombre_producto(), String.valueOf(admin.getCantidad_en_bodega()), String.valueOf(admin.getPrecio_de_venta())};
                    mTabla.addRow(rowData);
                });
            }
        });
    }

    public void listarProveedores() {

        List<Proveedor> miListaPro = ModeloFactura.listarProveedor();
        DefaultTableModel mTabla = (DefaultTableModel) vista.getTbClientes().getModel();
        mTabla.setRowCount(0);
        miListaPro.stream().forEach(admin -> {
            String[] rowData = {admin.getId_proveedor(), admin.getNombres(), admin.getApellidos(), admin.getCedula()};
            mTabla.addRow(rowData);
        });
    }

    public void listarProductos() {

        List<Producto> miListaPro = ModeloFactura.listaProductos();
        DefaultTableModel mTabla = (DefaultTableModel) vista.getTbProductos().getModel();
        mTabla.setRowCount(0);
        miListaPro.stream().forEach(admin -> {
            String[] rowData = {admin.getId_producto(), admin.getNombre_producto(), String.valueOf(admin.getCantidad_en_bodega()), String.valueOf(admin.getPrecio_de_venta())};
            mTabla.addRow(rowData);
        });
    }

    public void enviarDatosCliente() {
        vista.getTxtcodigocliente().setText(cedigo);
        vista.getTxtnombrecliente().setText(nombre);
        vista.getTxtapellidocliente().setText(apellido);
        vista.getTxtcedulacliente().setText(cedula);
        vista.getjDialogClientes().dispose();
    }

    public void enviarcodigoProducto() {
        vista.getTxtcodigoproducto().setText(codigobarras);
        vista.getjDialogProductos().dispose();
    }

    public void obtenerProduto() {
        ModeloFactura.BuscarProducto(vista.getTxtcodigoproducto().getText());
        vista.getLblNombreProducto().setText(ModeloFactura.nombre);
    }

    public void añadirProductos() {
        ModeloFactura.MandarProducto(vista.getTxtcodigoproducto().getText());
        DefaultTableModel mTabla = (DefaultTableModel) vista.getTbdetallefactura().getModel();
        mTabla.addRow(new Object[]{
            ModeloFactura.codigobarras,
            ModeloFactura.nombre,
            ModeloFactura.precio * Integer.parseInt(vista.getTxtcantidadproducto().getText()),
            vista.getTxtcantidadproducto().getText()
        });
        vista.getTbdetallefactura().setModel(mTabla);
        totales();
    }

    public void eliminarproducto() {
        DefaultTableModel mTabla = (DefaultTableModel) vista.getTbdetallefactura().getModel();
        int fila = vista.getTbdetallefactura().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Selecione un producto para eliminar");
        } else {
            mTabla.removeRow(fila);
        }
        totales();
        int canfilas = vista.getTbdetallefactura().getRowCount();
        if(canfilas == 0){
            vista.getTxtTotal().setText("");
        }
    }

    public void leercodigodeBarras() {
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
                    if (vista.getTxtcodigoproducto().getText().equals("")) {
                        vista.getTxtcodigoproducto().setText(mensaje);
                        codigoBuscar = vista.getTxtcodigoproducto().getText();
                    } else {
                        vista.getTxtcodigoproducto().setText("");
                        vista.getTxtcodigoproducto().setText(mensaje);

                        codigoBuscar = vista.getTxtcodigoproducto().getText();
                    }
                    System.out.println("salio");
                }

            } catch (IOException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        }).start();
    }

    public void totales() {
        int canfilas = vista.getTbdetallefactura().getRowCount();
        int sumatotal = 0;
        for (int i = 0; i < canfilas; i++) {
            if (!vista.getTbdetallefactura().getValueAt(i, 3).equals("")) {
                sumatotal += Integer.parseInt(vista.getTbdetallefactura().getValueAt(i, 3).toString());
                System.out.println(sumatotal);
            }
            vista.getTxtTotal().setText(String.valueOf(sumatotal));
        }
    }
    
    public void crearEncabeszado(){
            idFactura= vista.getTxtcodigoFactura().getText();
            String idCliente = vista.getTxtcedulacliente().getText();
            String idadmin = vista.getTxtcodigoAdmin().getText();
            Date fecha = vista.getDtFecha().getDate();
            long auxFecha = fecha.getTime();
            java.sql.Date fechaFinal = new java.sql.Date(auxFecha);
            String estado = vista.getLblEstado().getText();

            ModeloFactura fac = new ModeloFactura();
            fac.setIdFctura(idFactura);
            fac.setIdCliente(idCliente);
            fac.setIdAdministrador(idadmin);
            fac.setFechaFactura(fechaFinal);
            fac.setEstado(estado);

            if (fac.grabarEncabezadoFacura()== null) {
                JOptionPane.showMessageDialog(null, "Cabezera creada con exito");
                guardarDetalleFactura();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear al proveedor");
            }
    }
    public static Integer cantidadProductos;
    
    
    public static float precioproductosV;
    
    public void guardarDetalleFactura(){
        ModeloFactura fac = new ModeloFactura();
        cantidadProductos = vista.getTbdetallefactura().getRowCount();
        
        for (int i = 0; i < vista.getTbdetallefactura().getRowCount(); i++) {
            idproductoV = Integer.parseInt(vista.getTbdetallefactura().getValueAt(i, 0).toString());
            cantidadProductosV = Integer.parseInt(vista.getTbdetallefactura().getValueAt(i, 3).toString());
            precioproductosV = Float.valueOf(vista.getTbdetallefactura().getValueAt(i, 2).toString());
            if (fac.grabarDetalleFacura()== null) {
                JOptionPane.showMessageDialog(null, "Detalle creado con exito");
               
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear el detalle");
            }
        }
        
    }
    
}
