/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final2024;

import proyecto_final2024.newpackageControlador.ControladorEmpresas;
import proyecto_final2024.newpackageControlador.ControladorPaginaPrincipal;
import proyecto_final2024.newpackageControlador.controladorAdministrador;
import proyecto_final2024.newpackageControlador.controladorProducto;
import proyecto_final2024.newpackageModelo.ModeloProducto;
import proyecto_final2024.newpackageVista.VistaAdministrador;
import proyecto_final2024.newpackageVista.VistaEmpresa;
import proyecto_final2024.newpackageVista.VistaPrincipal;
import proyecto_final2024.newpackageVista.VistaProducto;

/**
 *
 * @author elshi
 */
public class Proyecto_final2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//  
//         VistaEmpresa vista = new VistaEmpresa();
//       ControladorEmpresas control = new ControladorEmpresas(vista);
//       control.inicarControlador();
       
        VistaProducto vista = new VistaProducto();
       controladorProducto control = new controladorProducto(vista);
       control.iniciarControl();
//  
//        VistaPrincipal vista = new VistaPrincipal();
//       ControladorPaginaPrincipal control = new ControladorPaginaPrincipal(vista);
//       control.inicarControladorPrincipal();
//       
//        VistaAdministrador vista = new VistaAdministrador();
//       controladorAdministrador control = new controladorAdministrador(vista);
//       control.iniciaControl();
    }
    
}
