/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final2024;

import proyecto_final2024.newpackageControlador.ControladorPaginaPrincipal;
import proyecto_final2024.newpackageVista.VistaPrincipal;

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
    }
    
}
