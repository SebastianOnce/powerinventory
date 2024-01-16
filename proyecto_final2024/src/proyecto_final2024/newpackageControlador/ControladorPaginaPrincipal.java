/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2024.newpackageControlador;

import proyecto_final2024.newpackageVista.VistaAdministrador;
import proyecto_final2024.newpackageVista.VistaCategoria;
import proyecto_final2024.newpackageVista.VistaCliente;
import proyecto_final2024.newpackageVista.VistaEmpresa;
import proyecto_final2024.newpackageVista.VistaFacrura;
import proyecto_final2024.newpackageVista.VistaPrincipal;
import proyecto_final2024.newpackageVista.VistaProducto;
import proyecto_final2024.newpackageVista.VistaProveedor;

/**
 *
 * @author USER
 */
public class ControladorPaginaPrincipal {
    
    VistaPrincipal vista;

    public ControladorPaginaPrincipal(VistaPrincipal vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setTitle("Power Inventory");
        this.vista.setLocationRelativeTo(null);
    }
    
    public void inicarControladorPrincipal(){
        vista.getBtnProveedores().addActionListener(l->abrirProveedor());
        vista.getBtnAdmin().addActionListener(l->abrirAdmin());
        vista.getBtnEmpresa().addActionListener(l->abrirEmpresas());
        vista.getBtnProducos().addActionListener(l->abrirProductos());
        vista.getBtnCategoria().addActionListener(l->abrirCategoria());
        vista.getBtnFactura().addActionListener(l->abrirFatura());
        vista.getBtnCliente().addActionListener(l->abrirCloente());
    }
    
    public void abrirProveedor(){
        VistaProveedor proveedor = new VistaProveedor();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        controladorProveedor controPro = new controladorProveedor(proveedor);
        controPro.inicarControladorCliente();
    }
    
    public void abrirAdmin(){
        VistaAdministrador proveedor = new VistaAdministrador();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        controladorAdministrador controPro = new controladorAdministrador(proveedor);
        controPro.iniciaControl();
    }
    
    public void abrirEmpresas(){
        VistaEmpresa proveedor = new VistaEmpresa();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        ControladorEmpresas controPro = new ControladorEmpresas(proveedor);
        controPro.inicarControlador();
    }
    
    public void abrirProductos(){
        VistaProducto proveedor = new VistaProducto();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        controladorProducto controPro = new controladorProducto(proveedor);
        controPro.iniciarControl();
    }
    public void abrirCategoria(){
        VistaCategoria proveedor = new VistaCategoria();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        controladorCategoria controPro = new controladorCategoria(proveedor);
        controPro.iniciarcontroladorCategoria();
    }
    public void abrirFatura(){
        VistaFacrura fac = new VistaFacrura();
//        vista.getDktPrincipal().add(proveedor);
//        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        ControladorFactura controPro = new ControladorFactura(fac);
        controPro.inicarControl();
    }
    public void abrirCloente(){
        VistaCliente proveedor = new VistaCliente();
        vista.getDktPrincipal().add(proveedor);
        proveedor.setSize(vista.getDktPrincipal().getSize().width, vista.getDktPrincipal().getSize().height);
        controladorClientes controPro = new controladorClientes(proveedor);
        controPro.iniciaControl();
    }
    
    
}
