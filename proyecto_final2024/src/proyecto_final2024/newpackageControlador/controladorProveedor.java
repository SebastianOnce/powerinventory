/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.Administrador;
import proyecto_final2024.newpackageModelo.ModeloAdministrador;
import proyecto_final2024.newpackageModelo.ModeloProveedor;
import proyecto_final2024.newpackageModelo.Proveedor;
import proyecto_final2024.newpackageVista.VistaProveedor;

/**
 *
 * @author elshi
 */
public class controladorProveedor {
    
    
    VistaProveedor vista;

    public controladorProveedor(VistaProveedor vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setTitle("Power Inventori Proveedor");
    }
    
    public void inicarControladorCliente(){
        listarProveedores();
        vista.getBtnCREAR().addActionListener(l->abrirDialogo(true));
        vista.getBtnGuardar().addActionListener(l->grabarProveedor());
    }
    
    private void abrirDialogo(boolean nuevo) {
//        limpiarCampos();
        if (nuevo) {
            vista.getjDialog1().setTitle("CREAR NUEVO ADMINISTRADOR");
        } else if (!nuevo) {
            vista.getjDialog1().setTitle("EDITAR PERSONA");
//            enviarDatos();
        }
        vista.getjDialog1().setLocationRelativeTo(vista);
        vista.getjDialog1().setSize(600, 600);
        vista.getjDialog1().setVisible(true);
        vista.getjDialog1().setLocationRelativeTo(null);
    }
    
    public void grabarProveedor() {
        
        if (vista.getjDialog1().getTitle().contentEquals("CREAR NUEVO ADMINISTRADOR")) {
            String cedula = vista.getTxtcedula().getText();
            String nombres = vista.getTxtnombres().getText();
            String apellidos = vista.getTxtapellidos().getText();
            String direccion = vista.getTxtdireccion().getText();
            String genero = vista.getTxtgenero().getText();
            String telefono = vista.getTxttelefono().getText();
            java.util.Date fehca = vista.getdtfecha().getDate();;
            long auxfecha_Nacimiento = fehca.getTime();
            java.sql.Date fecha = new java.sql.Date(auxfecha_Nacimiento);
            String idEmpresa = vista.getCmbIdEmpresa().getSelectedItem().toString();

            ModeloProveedor per = new ModeloProveedor();
            per.setCedula(cedula);
            per.setNombres(nombres);
            per.setApellidos(apellidos);
            per.setDireccion(direccion);
            per.setGenero(genero);
            per.setTelefono(telefono);
            per.setFecha_nacimiento(fecha);
            per.setId_empresa(idEmpresa);

            if (per.grabarAdministrador() == null) {
                JOptionPane.showMessageDialog(null, "Proveedor creado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear el Cliente");
            }

//        } else if (vista.getjDialog1().getTitle().contentEquals("EDITAR PERSONA")) {
//            String cedula = vista.getTxtcedula().getText();
//            String nombres = vista.getTxtnombres().getText();
//            String apellidos = vista.getTxtapellidos().getText();
//            String direccion = vista.getTxtdireccion().getText();
//            String genero = vista.getTxtgenero().getText();
//            String telefono = vista.getTxttelefono().getText();
//            java.util.Date fehca = vista.getdtfecha().getDate();;
//            long auxfecha_Nacimiento = fehca.getTime();
//            java.sql.Date fecha = new java.sql.Date(auxfecha_Nacimiento);
//            String usuario = vista.getTxtusuario().getText();
//            String contrasena = vista.getpwContrasena().getText();
//
//            ModeloAdministrador per = new ModeloAdministrador();
//            per.setCedula(cedula);
//            per.setNombres(nombres);
//            per.setApellidos(apellidos);
//            per.setDireccion(direccion);
//            per.setGenero(genero);
//            per.setTelefono(telefono);
//            per.setFecha_nacimiento(fecha);
//            per.setUsuario(usuario);
//            per.setContraseña(contrasena);
//
//            if (per.modificarPersona() == null) {
//                JOptionPane.showMessageDialog(null, "Administrador modificado con exito");
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo modiciar al administrador");
//            }
        }
    }
    
    public void listarProveedores() {

        List<Proveedor> miListaAdmin = ModeloProveedor.listarProveedor();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
        mTabla.setNumRows(0);
        miListaAdmin.stream().forEach(admin -> {
            String[] rowData = {admin.getId_proveedor(), admin.getCedula(), admin.getNombres(), admin.getApellidos(), admin.getDireccion(), admin.getGenero(), admin.getTelefono(), String.valueOf(admin.getFecha_nacimiento()), admin.getId_empresa()};
            mTabla.addRow(rowData);
        });

    }
}
