/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.usa.inventario.view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlInventario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblInventario = new javax.swing.JTable();
        PnlNuevoProducto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        LblInventario = new javax.swing.JLabel();
        TxtInventario = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnBorrar = new javax.swing.JButton();
        BtnGenerarInforme = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlInventario.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        TblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TblInventario);

        javax.swing.GroupLayout PnlInventarioLayout = new javax.swing.GroupLayout(PnlInventario);
        PnlInventario.setLayout(PnlInventarioLayout);
        PnlInventarioLayout.setHorizontalGroup(
            PnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
        PnlInventarioLayout.setVerticalGroup(
            PnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlInventarioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PnlNuevoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Nuevo Producto"));

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        TxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioActionPerformed(evt);
            }
        });

        LblInventario.setText("Inventario:");

        TxtInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtInventarioActionPerformed(evt);
            }
        });

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout PnlNuevoProductoLayout = new javax.swing.GroupLayout(PnlNuevoProducto);
        PnlNuevoProducto.setLayout(PnlNuevoProductoLayout);
        PnlNuevoProductoLayout.setHorizontalGroup(
            PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoProductoLayout.createSequentialGroup()
                .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnlNuevoProductoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnlNuevoProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnLimpiar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PnlNuevoProductoLayout.setVerticalGroup(
            PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNuevoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblInventario)
                    .addComponent(TxtInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnLimpiar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnBorrar.setText("Borrar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });

        BtnGenerarInforme.setText("Generar Informe");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("??Bienvenido a la APP de Inventario! ");
        jLabel4.setAlignmentY(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(BtnGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PnlInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PnlNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(PnlNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PnlInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnBorrar)
                    .addComponent(BtnActualizar)
                    .addComponent(BtnGenerarInforme))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPrecioActionPerformed

    private void TxtInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtInventarioActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBorrarActionPerformed

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnGenerarInforme;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JLabel LblInventario;
    private javax.swing.JPanel PnlInventario;
    private javax.swing.JPanel PnlNuevoProducto;
    private javax.swing.JTable TblInventario;
    private javax.swing.JTextField TxtInventario;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnActualizar() {
        return BtnActualizar;
    }

    public void setBtnActualizar(JButton BtnActualizar) {
        this.BtnActualizar = BtnActualizar;
    }

    public JButton getBtnAgregar() {
        return BtnAgregar;
    }

    public void setBtnAgregar(JButton BtnAgregar) {
        this.BtnAgregar = BtnAgregar;
    }

    public JButton getBtnBorrar() {
        return BtnBorrar;
    }

    public void setBtnBorrar(JButton BtnBorrar) {
        this.BtnBorrar = BtnBorrar;
    }

    public JButton getBtnGenerarInforme() {
        return BtnGenerarInforme;
    }

    public void setBtnGenerarInforme(JButton BtnGenerarInforme) {
        this.BtnGenerarInforme = BtnGenerarInforme;
    }

    public JButton getBtnLimpiar() {
        return BtnLimpiar;
    }

    public void setBtnLimpiar(JButton BtnLimpiar) {
        this.BtnLimpiar = BtnLimpiar;
    }

    public JTable getTblInventario() {
        return TblInventario;
    }

    public void setTblInventario(JTable TblInventario) {
        this.TblInventario = TblInventario;
    }

    public JTextField getTxtInventario() {
        return TxtInventario;
    }

    public void setTxtInventario(JTextField TxtInventario) {
        this.TxtInventario = TxtInventario;
    }

    public JTextField getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(JTextField TxtNombre) {
        this.TxtNombre = TxtNombre;
    }

    public JTextField getTxtPrecio() {
        return TxtPrecio;
    }

    public void setTxtPrecio(JTextField TxtPrecio) {
        this.TxtPrecio = TxtPrecio;
    }

}
