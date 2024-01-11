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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static proyecto_final2024.newpackageControlador.controladorProveedor.cedulaC;
import static proyecto_final2024.newpackageControlador.controladorProveedor.cedulaCienteBuscado;
import static proyecto_final2024.newpackageControlador.controladorProveedor.nombresC;
import proyecto_final2024.newpackageModelo.Empresa;
import proyecto_final2024.newpackageModelo.ModeloEmpresa;
import proyecto_final2024.newpackageModelo.ModeloProveedor;
import proyecto_final2024.newpackageModelo.Proveedor;
import proyecto_final2024.newpackageVista.VistaEmpresa;

/**
 *
 * @author USER
 */
public class ControladorEmpresas {
    
    VistaEmpresa vista;

    static public String nombre_empresa, desc_empresa, id;
    static public String codigoBuscar;
    
    public ControladorEmpresas(VistaEmpresa vista) {
        this.vista = vista;
        this.vista.setTitle("Power Inventory Empresas");
        this.vista.setVisible(true);
    }
    
    public void inicarControlador(){
        listaEmpresas();
        vista.getTxtBUSCAR().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                codigoBuscar = "" + vista.getTxtBUSCAR().getText();
                List<Empresa> miListaPro = ModeloEmpresa.buscarEmpre();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
                mTabla.setRowCount(0);
                miListaPro.forEach(admin -> {
                    String[] rowData = {
                        String.valueOf(admin.getId_empresa()), admin.getNombre_empresa(), admin.getDescripcion_empresa()};
                    mTabla.addRow(rowData);
                });
            }
        });
        
        vista.getjTableAdmin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vista.getjTableAdmin().getSelectedRow();
                id = (vista.getjTableAdmin().getValueAt(i, 0).toString());
                nombre_empresa = (vista.getjTableAdmin().getValueAt(i, 1).toString());
                desc_empresa = (vista.getjTableAdmin().getValueAt(i, 2).toString());
            }
        });
        vista.getBtnCREAR().addActionListener(l -> abrirDialogo(true));
        vista.getBtnEDITAR().addActionListener(l -> abrirDialogo(false));
        vista.getBtnGuardar().addActionListener(l -> grabareditarEmpresa());
        vista.getBtnELIMINAR().addActionListener(l -> eliminarEmpre());
    }
    
    private void abrirDialogo(boolean nuevo) {
        lipiar();
        if (nuevo) {
            vista.getjDialog1().setTitle("Crear nueva empresa");
        } else if (!nuevo) {
            vista.getjDialog1().setTitle("Editar empresa");
            enviarDatos();
        }
        vista.getjDialog1().setLocationRelativeTo(vista);
        vista.getjDialog1().setSize(600, 600);
        vista.getjDialog1().setVisible(true);
        vista.getjDialog1().setLocationRelativeTo(null);
    }

    public void grabareditarEmpresa() {

        if (vista.getjDialog1().getTitle().contentEquals("Crear nueva empresa")) {
            String nombreEm = vista.getTxtNombreEm().getText();
            String des = vista.getTxtDs().getText();

            ModeloEmpresa per = new ModeloEmpresa();
            per.setNombre_empresa(nombreEm);
            per.setDescripcion_empresa(des);

            if (per.grabarEmpre()== null) {
                JOptionPane.showMessageDialog(null, "Proveedor creado con exito");
                listaEmpresas();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear al proveedor");
            }

        } else if (vista.getjDialog1().getTitle().contentEquals("Editar empresa")) {
            String nombreEm = vista.getTxtNombreEm().getText();
            String des = vista.getTxtDs().getText();

            ModeloEmpresa per = new ModeloEmpresa();
            per.setNombre_empresa(nombreEm);
            per.setDescripcion_empresa(des);

            if (per.modificarEmpre()== null) {
                JOptionPane.showMessageDialog(null, "Proveedor modificado con exito");
                listaEmpresas();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar al proveedor");
            }
        }
    }
    
    public void listaEmpresas() {

        List<Empresa> miListaAdmin = ModeloEmpresa.listarEmpre();
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
        mTabla.setNumRows(0);
        miListaAdmin.stream().forEach(admin -> {
            String[] rowData = {String.valueOf(admin.getId_empresa()), admin.getNombre_empresa(), admin.getDescripcion_empresa()};
            mTabla.addRow(rowData);
        });
    }
    
    public void eliminarEmpre() {
        ModeloEmpresa pro= new ModeloEmpresa();
        if (pro.eliminarEmpre()== null ) {
            JOptionPane.showMessageDialog(null, "Empresa eliminada con exito");
            listaEmpresas();
        } else {
            JOptionPane.showMessageDialog(null, "Empresa no eliminada");
        }
    }
    
    public void enviarDatos() {
            vista.getTxtNombreEm().setText(nombre_empresa);
            vista.getTxtDs().setText(desc_empresa);
        }
    public void lipiar() {
            vista.getTxtNombreEm().setText("");
            vista.getTxtDs().setText("");
        }
}
