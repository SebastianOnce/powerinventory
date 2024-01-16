/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final2024.newpackageVista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

/**
 *
 * @author USER
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    public JButton getBtnProveedores() {
        return btnProveedores;
    }

    public JDesktopPane getDktPrincipal() {
        return dktPrincipal;
    }

    public JButton getBtnAdmin() {
        return btnAdmin;
    }

    public JButton getBtnCategoria() {
        return btnCategoria;
    }

    public JButton getBtnEmpresa() {
        return btnEmpresa;
    }

    public JButton getBtnProducos() {
        return btnProducos;
    }

    public JButton getBtnFactura() {
        return btnFactura;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnProveedores = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAdmin = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCliente = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnEmpresa = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnProducos = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCategoria = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnFactura = new javax.swing.JButton();
        dktPrincipal = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 51));
        jToolBar1.setRollover(true);

        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-proveedor-40.png"))); // NOI18N
        btnProveedores.setToolTipText("Ventana de proveedores");
        btnProveedores.setFocusable(false);
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnProveedores);
        jToolBar1.add(jSeparator1);

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-administrador-del-hombre-40.png"))); // NOI18N
        btnAdmin.setToolTipText("Ventana de administradores");
        btnAdmin.setFocusable(false);
        btnAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAdmin);
        jToolBar1.add(jSeparator2);

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cliente-40.png"))); // NOI18N
        btnCliente.setToolTipText("Ventana cliente");
        btnCliente.setFocusable(false);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCliente);
        jToolBar1.add(jSeparator6);

        btnEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-empresa-40.png"))); // NOI18N
        btnEmpresa.setToolTipText("Ventana de empresas");
        btnEmpresa.setFocusable(false);
        btnEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEmpresa);
        jToolBar1.add(jSeparator3);

        btnProducos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-carros-40.png"))); // NOI18N
        btnProducos.setToolTipText("Ventana de componentes de carros");
        btnProducos.setFocusable(false);
        btnProducos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnProducos);
        jToolBar1.add(jSeparator4);

        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-lista-40.png"))); // NOI18N
        btnCategoria.setToolTipText("Ventana de categoria");
        btnCategoria.setFocusable(false);
        btnCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCategoria);
        jToolBar1.add(jSeparator5);

        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-factura-40.png"))); // NOI18N
        btnFactura.setToolTipText("Crear factura");
        btnFactura.setFocusable(false);
        btnFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnFactura);

        javax.swing.GroupLayout dktPrincipalLayout = new javax.swing.GroupLayout(dktPrincipal);
        dktPrincipal.setLayout(dktPrincipalLayout);
        dktPrincipalLayout.setHorizontalGroup(
            dktPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dktPrincipalLayout.setVerticalGroup(
            dktPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1462, Short.MAX_VALUE)
            .addComponent(dktPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(dktPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEmpresa;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnProducos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JDesktopPane dktPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
