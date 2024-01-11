/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_final2024.newpackageVista;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import proyecto_final2024.newpackageControlador.controladorProducto;
import proyecto_final2024.newpackageModelo.ModeloProducto;

/**
 *
 * @author elshi
 */
public class VistaProducto extends javax.swing.JFrame {

    /**
     * Creates new form VistaProducto
     */
    public VistaProducto() {
        initComponents();
    }

    public JLabel getTxtindicador() {
        return txtindicador;
    }

    public JButton getBtnBUSCAR() {
        return btnBUSCAR;
    }

    public JButton getBtnCREAR() {
        return btnCREAR;
    }

    public JButton getBtnELIMINAR() {
        return btnELIMINAR;
    }

    public JButton getBtnIMPRIMIR() {
        return btnIMPRIMIR;
    }

    public JButton getBtnMODIFICAR() {
        return btnMODIFICAR;
    }

    public JComboBox<String> getCbcategoria() {
        return cbcategoria;
    }

    public JCheckBox getChbdisponibilidad() {
        return chbdisponibilidad;
    }

    public JTextField getTxtcodigoproducto() {
        return txtcodigoproducto;
    }

    public JTextField getTxtBUSCAR() {
        return txtBUSCAR;
    }

    public JTextField getTxtcantidadbodega() {
        return txtcantidadbodega;
    }

    public JTextField getTxtdescripcion() {
        return txtdescripcion;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public JTextField getTxtprecioVenta() {
        return txtprecioVenta;
    }

    public JTextField getTxtpreciocompra() {
        return txtpreciocompra;
    }

    public JTable getTblproductos() {
        return tblproductos;
    }
 

    public JComboBox<String> getCbcodigoproveedor() {
        return cbcodigoproveedor;
    }//QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----
    public static void main(String[] args) { // QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----
        VistaProducto vista=new VistaProducto();//QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----
        //QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----
        VistaProducto vista1=new VistaProducto();
        ModeloProducto modelo1=new ModeloProducto();
       controladorProducto controlp=new controladorProducto(modelo1, vista1);
       controlp.iniciarControl();
    }//QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----QUITAAAAAR----

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCREAR = new javax.swing.JButton();
        btnMODIFICAR = new javax.swing.JButton();
        btnELIMINAR = new javax.swing.JButton();
        btnBUSCAR = new javax.swing.JButton();
        btnIMPRIMIR = new javax.swing.JButton();
        txtBUSCAR = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtpreciocompra = new javax.swing.JTextField();
        txtprecioVenta = new javax.swing.JTextField();
        txtcantidadbodega = new javax.swing.JTextField();
        chbdisponibilidad = new javax.swing.JCheckBox();
        cbcodigoproveedor = new javax.swing.JComboBox<>();
        cbcategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtcodigoproducto = new javax.swing.JTextField();
        txtindicador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCREAR.setText("CREAR");

        btnMODIFICAR.setText("MODIFICAR");

        btnELIMINAR.setText("ELIMINAR");

        btnBUSCAR.setText("BUSCAR");

        btnIMPRIMIR.setText("IMPRIMIR");

        tblproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblproductos);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Codigo de proveedor:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Precio de compra:");

        jLabel5.setText("Precio de venta:");

        jLabel6.setText("Cantidad en bodega:");

        jLabel7.setText("Disponibilidad:");

        jLabel9.setText("Foto del producto:");

        jLabel10.setText("Categoria:");

        txtnombre.setToolTipText("");

        txtdescripcion.setToolTipText("");

        txtpreciocompra.setToolTipText("");

        txtprecioVenta.setToolTipText("");

        txtcantidadbodega.setToolTipText("");

        chbdisponibilidad.setText("jCheckBox1");

        cbcodigoproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbcodigoproveedor.setToolTipText("");

        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel11.setText("Codigo de Producto:");

        txtindicador.setText("-----");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnCREAR)
                .addGap(18, 18, 18)
                .addComponent(btnMODIFICAR)
                .addGap(18, 18, 18)
                .addComponent(btnELIMINAR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(cbcodigoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtindicador)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtprecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcantidadbodega, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtpreciocompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcodigoproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(33, 33, 33)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(chbdisponibilidad)))
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIMPRIMIR)
                                    .addComponent(btnBUSCAR)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBUSCAR)
                    .addComponent(txtBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIMPRIMIR)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtcodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbdisponibilidad)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbcodigoproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtindicador))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcantidadbodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCREAR)
                    .addComponent(btnMODIFICAR)
                    .addComponent(btnELIMINAR))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnCREAR;
    private javax.swing.JButton btnELIMINAR;
    private javax.swing.JButton btnIMPRIMIR;
    private javax.swing.JButton btnMODIFICAR;
    private javax.swing.JComboBox<String> cbcategoria;
    private javax.swing.JComboBox<String> cbcodigoproveedor;
    private javax.swing.JCheckBox chbdisponibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txtBUSCAR;
    private javax.swing.JTextField txtcantidadbodega;
    private javax.swing.JTextField txtcodigoproducto;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JLabel txtindicador;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecioVenta;
    private javax.swing.JTextField txtpreciocompra;
    // End of variables declaration//GEN-END:variables
}
