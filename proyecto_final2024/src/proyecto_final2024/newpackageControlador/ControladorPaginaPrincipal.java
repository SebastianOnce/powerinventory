/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2024.newpackageControlador;

import proyecto_final2024.newpackageVista.VistaPrincipal;
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
    }
    
    public void abrirProveedor(){
        VistaProveedor proveedor = new VistaProveedor();
        vista.getDktPrincipal().add(proveedor);
        controladorProveedor controPro = new controladorProveedor(proveedor);
        controPro.inicarControladorCliente();
    }
}
