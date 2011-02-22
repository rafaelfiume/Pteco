/*
 * VChart.java
 *
 * Created on 19 de Dezembro de 2006, 22:25
 */

package org.modelmat.gui.chart;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


/**
 * Dislay the linear and non-linear regression result's chart.
 *
 * @author Rafael Fiume
 */
public final class ChartView extends JPanel {
    
    private ChartPanel chartPanel;
        
    /**
     * Creates new ReportView.
     * 
     * <strong>ATENÃÃO:</strong> NÃ£o utilize esse construtor.
     * O construtor padrÃ£o Ã© utilizado apenas para atender
     * a especificaÃ§Ã£o JavaBean. Dessa forma, o componente pode ser instanciado
     * por construtores de interface grÃ¡ficas, como o Matisse.
     * 
     * Utilize sempre o construtor ChartView(ChartModel model),
     * caso contrÃ¡rio o model dessa vew serÃ¡ null.
     */
    public ChartView() {
        super();
        initComponents();
    }
    
    public ChartView(ChartModel model) {
        this();
        add(createChartPanel(model.getJFreeChart()));
    }
    
    /**
     * Creates and configures the chart panel.
     */ 
    private ChartPanel createChartPanel(JFreeChart chart) {
        chartPanel = new ChartPanel(chart, true);
        chartPanel.setMouseZoomable(true, false);        
        return chartPanel;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
         
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
       
}
