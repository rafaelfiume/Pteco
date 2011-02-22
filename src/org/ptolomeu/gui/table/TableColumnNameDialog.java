/*
 * VColumnNameDialog.java
 *
 * Created on 20 de Dezembro de 2006, 07:29
 */

package org.ptolomeu.gui.table;

import java.awt.Frame;

import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 * Dialog to change the name of table's columns.
 * 
 * TODO: Make this dialog request focus when it appears.
 *
 * @author Rafael Fiume
 */
public class TableColumnNameDialog extends javax.swing.JDialog {

    private final JTableHeader tableHeader;
    
    private static TableColumnNameDialog _instance;

    private TableColumnNameDialog(JTableHeader tableHeader) {
        super((Frame) null, true);
        this.tableHeader = tableHeader;
        initComponents();
    }
    
    /**
     * Lazily construct the TableColumnNameDialog.
     */
    public synchronized static void showDialog(JTableHeader tableHeader) {
        if (_instance == null) {
            _instance = new TableColumnNameDialog(tableHeader);            
        }
        _instance.setVisible(true);
    }

    @SuppressWarnings("LocalVariableCouldBeFinal")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        lCoordX = new javax.swing.JLabel();
        tfCoordX = new javax.swing.JTextField();
        lCoordY = new javax.swing.JLabel();
        tfCoordY = new javax.swing.JTextField();
        bCancel = new javax.swing.JButton();
        bOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Column Name");

        lCoordX.setText("Coord. X:");

        lCoordY.setText("Coord. Y:");

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lCoordX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lCoordY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCoordY, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bOk, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bCancel, bOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCoordX)
                    .addComponent(tfCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCoordY)
                    .addComponent(tfCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("MethodArgumentCouldBeFinal")
    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        boolean success = changeColumnName();
        if (success) {
            clearFields();
            dispose();             
        }
    }//GEN-LAST:event_bOkActionPerformed

    @SuppressWarnings("MethodArgumentCouldBeFinal")
    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        clearFields();
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    /**
     * Clears the field of this dialog.
     */
    private void clearFields() {
        tfCoordX.setText("");
        tfCoordY.setText("");
    }

    /**
     * Change the column's name of the Spreadsheet object.
     */ 
    private boolean changeColumnName() {        
        final String[] columnName = new String[2];
        columnName[0] = tfCoordX.getText();
        columnName[1] = tfCoordY.getText();

        if ((columnName[0].compareTo("") == 0) ||
                (columnName[1].compareTo("") == 0)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Type the name of the columns.",
                    "OPS!",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        for (int i = 0; i < columnName.length; i++) {
            tableHeader.getColumnModel()
                        .getColumn(i)
                        .setHeaderValue(columnName[i]);
            
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bOk;
    private javax.swing.JLabel lCoordX;
    private javax.swing.JLabel lCoordY;
    private javax.swing.JTextField tfCoordX;
    private javax.swing.JTextField tfCoordY;
    // End of variables declaration//GEN-END:variables

}
