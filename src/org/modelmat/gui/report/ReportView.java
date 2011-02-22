/*
 * VReport.java
 *
 * Created on 20 de Dezembro de 2006, 00:19
 */

package org.modelmat.gui.report;

import javax.swing.JPanel;

/**
 *
 * @author Rafael Fiume
 */
public final class ReportView extends JPanel {
    
    /**
     * Creates new ReportView.
     * 
     * <strong>ATENÃÃO:</strong> NÃ£o utilize esse construtor.
     * O construtor padrÃ£o Ã© utilizado apenas para atender
     * a especificaÃ§Ã£o JavaBean. Dessa forma, o componente pode ser instanciado
     * por construtores de interface grÃ¡ficas, como o Matisse.
     * 
     * Utilize sempre o construtor ReportView(ReportModel model),
     * caso contrÃ¡rio o model dessa vew serÃ¡ null.
     */
    public ReportView() {
        super();
        initComponents();        
    }
    
    /**
     * Creates a new ReportView with the specified ReportModel.
     */
    public ReportView(ReportModel model) {
        this();
        tpReport.setDocument(model.getDocument());
    }

    @SuppressWarnings("LocalVariableCouldBeFinal")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        scReport = new javax.swing.JScrollPane();
        tpReport = new javax.swing.JTextPane();

        tpReport.setEditable(false);
        scReport.setViewportView(tpReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scReport, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scReport;
    private javax.swing.JTextPane tpReport;
    // End of variables declaration//GEN-END:variables

}
