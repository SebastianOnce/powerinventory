/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.io.FileInputStream;
import proyecto_final2024.newpackageModelo.ModeloAdministrador;
import proyecto_final2024.newpackageVista.VistaAdministrador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.Administrador;

/**
 *
 * @author elshi
 */
public class controladorAdministrador {
    
    private ModeloAdministrador modelo;
    private VistaAdministrador vista;
    
    static public String cedula2,id2,nombres2,apellidos2,direccion2,genero2,telefono2,fecha_nacimiento2;
    static public String id_admin2,usuario2,contraseña2;
    static public String idPersonaBuscar;
    private FileInputStream Pep;

    public controladorAdministrador() {
    }
    
    public controladorAdministrador(ModeloAdministrador modelo, VistaAdministrador vista){
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void iniciaControl(){
        
        vista.getBtnACTUALIZAR().addActionListener(l -> listarAdministrador());
        vista.getBtnELIMINAR().addActionListener(l -> el);
        
        
    }
    
    public void listarAdministrador(){
        
        List<Administrador> miListaAdmin = ModeloAdministrador.listarAdministrador();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
        mTabla.setNumRows(0);
        miListaAdmin.stream().forEach(admin -> {
            String[] rowData = {admin.getId_administrador(), admin.getUsuario(), admin.getContraseña() };
            mTabla.addRow(rowData);
        });
        
    }
    
    private void abrirDialogo(boolean nuevo){
        limpiarCampos();
        if (nuevo) {
            vista.getjDialog1().setTitle("CREAR NUEVO ADMINISTRADOR");
        }else if (!nuevo) {
            vista.getjDialog1().setTitle("EDITAR PERSONA");
            enviarDatos();
        }
        vista.getjDialog1().setLocationRelativeTo(vista);
        vista.getjDialog1().setSize(500, 400);
        vista.getjDialog1().setVisible(true);
        vista.getjDialog1().setLocationRelativeTo(null);
    }
    
    public void enviarDatos(){
        vista.getTxtusuario().setText(usuario2);
        vista.getjPasswordFieldcontra().setText(contraseña2);
        vista.getTxtcedula().setText(cedula2);

    }
    
    public void grabarAdministrador(){
        
        if (vista.getjDialog1().getTitle().contentEquals("")) {
            
        }
    }
    
    
}
