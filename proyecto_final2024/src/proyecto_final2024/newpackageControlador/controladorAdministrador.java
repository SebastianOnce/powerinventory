/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import proyecto_final2024.newpackageModelo.ModeloAdministrador;
import proyecto_final2024.newpackageVista.VistaAdministrador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.Administrador;

/**
 *
 * @author elshi
 */
public class controladorAdministrador {

    private VistaAdministrador vista;

    static public String cedula2, id2, nombres2, apellidos2, direccion2, genero2, telefono2, fecha_nacimiento2;
    static public String id_admin2, usuario2, contraseña2;
    static public String idPersonaBuscar;
    private FileInputStream Pep;

    public static String adminBuscar = "";

    public controladorAdministrador(VistaAdministrador vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void iniciaControl() {
        listarAdministrador();

        vista.getTxtBUSCAR().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                adminBuscar = "" + vista.getTxtBUSCAR().getText();
                List<Administrador> miListaAdmin = ModeloAdministrador.administradorBuscado();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
                mTabla.setRowCount(0);
                miListaAdmin.forEach(admin -> {
                    String[] rowData = {
                        admin.getId_administrador(), admin.getCedula(), admin.getNombres(), admin.getApellidos(), admin.getDireccion(), admin.getGenero(), admin.getTelefono(), String.valueOf(admin.getFecha_nacimiento()), admin.getUsuario(), admin.getContraseña()
                    };
                    mTabla.addRow(rowData);
                });
            }
        });

        vista.getjTableAdmin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vista.getjTableAdmin().getSelectedRow();
                id_admin2 = (vista.getjTableAdmin().getValueAt(i, 0).toString());
                cedula2 = (vista.getjTableAdmin().getValueAt(i, 1).toString());
                nombres2 = (vista.getjTableAdmin().getValueAt(i, 2).toString());
                apellidos2 = (vista.getjTableAdmin().getValueAt(i, 3).toString());
                direccion2 = (vista.getjTableAdmin().getValueAt(i, 4).toString());
                genero2 = (vista.getjTableAdmin().getValueAt(i, 5).toString());
                telefono2 = (vista.getjTableAdmin().getValueAt(i, 6).toString());
                fecha_nacimiento2 = (vista.getjTableAdmin().getValueAt(i, 7).toString());
                usuario2 = (vista.getjTableAdmin().getValueAt(i, 8).toString());
                contraseña2 = (vista.getjTableAdmin().getValueAt(i, 9).toString());
            }
        });

        vista.getBtnACTUALIZAR().addActionListener(l -> listarAdministrador());
        vista.getBtnCREAR().addActionListener(l -> abrirDialogo(true));
        vista.getBtnEDITAR().addActionListener(l -> abrirDialogo(false));
        vista.getBtnGuardar().addActionListener(l -> grabarAdministrador());
        vista.getBtnELIMINAR().addActionListener(l -> eliminarAdmin());

    }

    public void listarAdministrador() {

        List<Administrador> miListaAdmin = ModeloAdministrador.listarAdministrador();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
        mTabla.setNumRows(0);
        miListaAdmin.stream().forEach(admin -> {
            String[] rowData = {admin.getId_administrador(), admin.getCedula(), admin.getNombres(), admin.getApellidos(), admin.getDireccion(), admin.getGenero(), admin.getTelefono(), String.valueOf(admin.getFecha_nacimiento()), admin.getUsuario(), admin.getContraseña()};
            mTabla.addRow(rowData);
        });

    }

    private void abrirDialogo(boolean nuevo) {
        limpiarCampos();
        if (nuevo) {
            vista.getjDialog1().setTitle("CREAR NUEVO ADMINISTRADOR");
        } else if (!nuevo) {
            vista.getjDialog1().setTitle("EDITAR PERSONA");
            enviarDatos();
        }
        vista.getjDialog1().setLocationRelativeTo(vista);
        vista.getjDialog1().setSize(600, 600);
        vista.getjDialog1().setVisible(true);
        vista.getjDialog1().setLocationRelativeTo(null);
    }

    public void enviarDatos() {
        try {
            vista.getTxtcedula().setText(cedula2);
            vista.getTxtnombres().setText(nombres2);
            vista.getTxtapellidos().setText(apellidos2);
            vista.getTxtdireccion().setText(direccion2);
            vista.getTxtgenero().setText(genero2);
            vista.getTxttelefono().setText(telefono2);
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
            Date fechaFormat = formatoFecha.parse(fecha_nacimiento2);
            vista.getdtfecha().setDate(fechaFormat);

            vista.getTxtusuario().setText(usuario2);
            vista.getpwContrasena().setText(contraseña2);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(controladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void grabarAdministrador() {
        
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
            String usuario = vista.getTxtusuario().getText();
            String contrasena = vista.getpwContrasena().getText();

            ModeloAdministrador per = new ModeloAdministrador();
            per.setCedula(cedula);
            per.setNombres(nombres);
            per.setApellidos(apellidos);
            per.setDireccion(direccion);
            per.setGenero(genero);
            per.setTelefono(telefono);
            per.setFecha_nacimiento(fecha);
            per.setUsuario(usuario);
            per.setContraseña(contrasena);

            if (per.grabarAdministrador() == null) {
                JOptionPane.showMessageDialog(null, "Cliente creado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear el Cliente");
            }

        } else if (vista.getjDialog1().getTitle().contentEquals("EDITAR PERSONA")) {
            String cedula = vista.getTxtcedula().getText();
            String nombres = vista.getTxtnombres().getText();
            String apellidos = vista.getTxtapellidos().getText();
            String direccion = vista.getTxtdireccion().getText();
            String genero = vista.getTxtgenero().getText();
            String telefono = vista.getTxttelefono().getText();
            java.util.Date fehca = vista.getdtfecha().getDate();;
            long auxfecha_Nacimiento = fehca.getTime();
            java.sql.Date fecha = new java.sql.Date(auxfecha_Nacimiento);
            String usuario = vista.getTxtusuario().getText();
            String contrasena = vista.getpwContrasena().getText();

            ModeloAdministrador per = new ModeloAdministrador();
            per.setCedula(cedula);
            per.setNombres(nombres);
            per.setApellidos(apellidos);
            per.setDireccion(direccion);
            per.setGenero(genero);
            per.setTelefono(telefono);
            per.setFecha_nacimiento(fecha);
            per.setUsuario(usuario);
            per.setContraseña(contrasena);

            if (per.modificarPersona() == null) {
                JOptionPane.showMessageDialog(null, "Administrador modificado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modiciar al administrador");
            }
        }
    }

    public void limpiarCampos() {
            vista.getTxtcedula().setText("");
            vista.getTxtnombres().setText("");
            vista.getTxtapellidos().setText("");
            vista.getTxtdireccion().setText("");
            vista.getTxtgenero().setText("");
            vista.getTxttelefono().setText("");
            vista.getdtfecha().setDate(null);
            vista.getTxtusuario().setText("");
            vista.getpwContrasena().setText("");
    }

    public void eliminarAdmin() {
        ModeloAdministrador admin = new ModeloAdministrador();
        if (admin.eliminarAdministrador()== null) {
            JOptionPane.showMessageDialog(null, "administrador eliminada con exito");
            listarAdministrador();
        } else {
            JOptionPane.showMessageDialog(null, "administrador no eliminada");
        }
    }
}
