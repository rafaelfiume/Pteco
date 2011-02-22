/*
 * VSobre.java
 *
 * Created on 25 de Novembro de 2006, 23:22
 */

package org.ptolomeu.gui.help;

import java.awt.Frame;

/**
 *
 * @author  Rafael Fiume
 */
public final class AboutDialog extends javax.swing.JDialog {
    
    private static AboutDialog about;
    
    private AboutDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** Mostra About dialog. */
    public static void showDialog() {
        if (about == null) {
            about = new AboutDialog(null, true);
        }
        about.setVisible(true);
    }
  
    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutView1 = new org.ptolomeu.gui.help.AboutView();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setAlwaysOnTop(true);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.ptolomeu.gui.help.AboutView aboutView1;
    // End of variables declaration//GEN-END:variables
    
}
