/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final2024;

import proyecto_final2024.newpackageControlador.ControladorPaginaPrincipal;
import proyecto_final2024.newpackageControlador.controladorProducto;
import proyecto_final2024.newpackageModelo.ModeloProducto;
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
  
        VistaPrincipal vista = new VistaPrincipal();
       ControladorPaginaPrincipal control = new ControladorPaginaPrincipal(vista);
       control.inicarControladorPrincipal();
       
        VistaProducto vista1=new VistaProducto();
        ModeloProducto modelo1=new ModeloProducto();
       controladorProducto controlp=new controladorProducto(modelo1, vista1);
       controlp.iniciarControl();
    }
    
}
