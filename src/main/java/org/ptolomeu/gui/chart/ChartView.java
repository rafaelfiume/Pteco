package org.ptolomeu.gui.chart;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * Dislay the linear and non-linear regression result's chart.
 */
public final class ChartView extends JPanel {

    public ChartView(ChartModel model) {
        initComponents();
        add(createChartPanel(model.getJFreeChart()));
    }

    private void initComponents() {
        setLayout(new java.awt.BorderLayout());
    }

    private ChartPanel createChartPanel(JFreeChart chart) {
        final ChartPanel chartPanel = new ChartPanel(chart, true);
        chartPanel.setMouseZoomable(true, false);
        return chartPanel;
    }

}
