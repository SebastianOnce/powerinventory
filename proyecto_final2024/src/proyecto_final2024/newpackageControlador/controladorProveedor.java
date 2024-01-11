/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final2024.newpackageControlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final2024.newpackageModelo.Empresa;
import proyecto_final2024.newpackageModelo.ModeloProveedor;
import proyecto_final2024.newpackageModelo.Proveedor;
import proyecto_final2024.newpackageVista.VistaProveedor;

/**
 *
 * @author elshi
 */
public class controladorProveedor {

    VistaProveedor vista;

    static public String cedulaC, nombresC, apellidosC, direccionC, generoC, telefonoC, fecha_nacimientoC;
    static public String empresa, idProveedor;
    static public String cedulaCienteBuscado;

    public controladorProveedor(VistaProveedor vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setTitle("Power Inventori Proveedor");
    }

    public void inicarControladorCliente() {
        listaEmpresas();
        listarProveedores();
        vista.getTxtBUSCAR().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                cedulaCienteBuscado = "" + vista.getTxtBUSCAR().getText();
                List<Proveedor> miListaPro = ModeloProveedor.ProveedorBuscadp();
                DefaultTableModel mTabla = (DefaultTableModel) vista.getjTableAdmin().getModel();
                mTabla.setRowCount(0);
                miListaPro.forEach(admin -> {
                    String[] rowData = {
                        admin.getId_proveedor(), admin.getCedula(), admin.getNombres(), admin.getApellidos(), admin.getDireccion(), admin.getGenero(), admin.getTelefono(), String.valueOf(admin.getFecha_nacimiento()), admin.getId_empresa()
                    };
                    mTabla.addRow(rowData);
                });
            }
        });
        vista.getjTableAdmin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = vista.getjTableAdmin().getSelectedRow();
                idProveedor = (vista.getjTableAdmin().getValueAt(i, 0).toString());
                cedulaC = (vista.getjTableAdmin().getValueAt(i, 1).toString());
                nombresC = (vista.getjTableAdmin().getValueAt(i, 2).toString());
                apellidosC = (vista.getjTableAdmin().getValueAt(i, 3).toString());
                direccionC = (vista.getjTableAdmin().getValueAt(i, 4).toString());
                generoC = (vista.getjTableAdmin().getValueAt(i, 5).toString());
                telefonoC = (vista.getjTableAdmin().getValueAt(i, 6).toString());
                fecha_nacimientoC = (vista.getjTableAdmin().getValueAt(i, 7).toString());
                empresa = (vista.getjTableAdmin().getValueAt(i, 8).toString());
            }
        });
        vista.getBtnCREAR().addActionListener(l -> abrirDialogo(true));
        vista.getBtnEDITAR().addActionListener(l -> abrirDialogo(false));
        vista.getBtnGuardar().addActionListener(l -> grabarProveedor());
        vista.getBtnELIMINAR().addActionListener(l -> eliminarPro());
    }

    private void abrirDialogo(boolean nuevo) {
//        limpiarCampos();
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
            int codigo = 0;
            List<Empresa> listaEmpresas = ModeloProveedor.llenarEmpresas();
            for (int i = 0; i < listaEmpresas.size(); i++) {
                if (listaEmpresas.get(i).getNombre_empresa().equals(idEmpresa)) {
                    codigo = listaEmpresas.get(i).getId_empresa();
                    System.out.println(codigo);
                    i = listaEmpresas.size();
                }
            }

            ModeloProveedor per = new ModeloProveedor();
            per.setCedula(cedula);
            per.setNombres(nombres);
            per.setApellidos(apellidos);
            per.setDireccion(direccion);
            per.setGenero(genero);
            per.setTelefono(telefono);
            per.setFecha_nacimiento(fecha);
            per.setId_empresa(String.valueOf(codigo));

            if (per.grabarAdministrador() == null) {
                JOptionPane.showMessageDialog(null, "Proveedor creado con exito");
                listarProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo crear al proveedor");
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
            String idEmpresa = vista.getCmbIdEmpresa().getSelectedItem().toString();
            int codigo = 0;
            List<Empresa> listaEmpresas = ModeloProveedor.llenarEmpresas();
            for (int i = 0; i < listaEmpresas.size(); i++) {
                if (listaEmpresas.get(i).getNombre_empresa().equals(idEmpresa)) {
                    codigo = listaEmpresas.get(i).getId_empresa();
                    System.out.println(codigo);
                    i = listaEmpresas.size();
                }
            }
            
            ModeloProveedor per = new ModeloProveedor();
            per.setCedula(cedula);
            per.setNombres(nombres);
            per.setApellidos(apellidos);
            per.setDireccion(direccion);
            per.setGenero(genero);
            per.setTelefono(telefono);
            per.setFecha_nacimiento(fecha);
            per.setId_empresa(String.valueOf(codigo));

            if (per.modificarProveedor() == null) {
                JOptionPane.showMessageDialog(null, "Proveedor modificado con exito");
                listarProveedores();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar al proveedor");
            }
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

    public void listaEmpresas() {
        List<Empresa> listaEmpresas = ModeloProveedor.llenarEmpresas();
        for (int i = 0; i < listaEmpresas.size(); i++) {
            vista.getCmbIdEmpresa().addItem(listaEmpresas.get(i).getNombre_empresa());
        }
    }

    public void enviarDatos() {
        try {
            vista.getTxtcedula().setText(cedulaC);
            vista.getTxtnombres().setText(nombresC);
            vista.getTxtapellidos().setText(apellidosC);
            vista.getTxtdireccion().setText(direccionC);
            vista.getTxtgenero().setText(generoC);
            vista.getTxttelefono().setText(telefonoC);
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
            Date fechaFormat = formatoFecha.parse(fecha_nacimientoC);
            vista.getdtfecha().setDate(fechaFormat);
            vista.getCmbIdEmpresa().setSelectedItem(empresa);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(controladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void limpiar() {
            vista.getTxtcedula().setText("");
            vista.getTxtnombres().setText("");
            vista.getTxtapellidos().setText("");
            vista.getTxtdireccion().setText("");
            vista.getTxtgenero().setText("");
            vista.getTxttelefono().setText("");
            vista.getdtfecha().setDate(null);
            vista.getCmbIdEmpresa().setSelectedItem("");
        
    }

    public void eliminarPro() {
        ModeloProveedor pro= new ModeloProveedor();
        if (pro.eliminarPro()== null && pro.eliminarPersona() == null) {
            JOptionPane.showMessageDialog(null, "Proveedor eliminada con exito");
            listarProveedores();
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor no eliminada");
        }
    }
}
