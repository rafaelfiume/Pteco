/*
 * ChartModel.java
 * 
 * Created on 16/07/2007, 15:35:04
 */

package org.ptolomeu.gui.chart;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.function.PowerFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.ptolomeu.core.regression.AbstractRegressionResult;
import org.ptolomeu.core.regression.LinearRegressionResult;
import org.ptolomeu.core.regression.NonLinearRegressionResult;
import org.ptolomeu.core.regression.Point;

/**
 * The model of ChartView.
 * 
 * @author Rafael Fiume
 */
public class ChartModel {

    private final JFreeChart chart;

    private final NumberAxis xAxis = new NumberAxis("X");

    private final NumberAxis yAxis = new NumberAxis("Y");

    private final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

    /**
     * Creates a new ChartModel.
     * 
     * Something here is based on example located at
     * http://www.java2s.com/Code/Java/Chart/JFreeChartXYLineAndShapeRendererDemo.htm
     */
    public ChartModel() {
        xAxis.setAutoRangeIncludesZero(false);
        yAxis.setAutoRangeIncludesZero(false);

        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);

        chart = ChartFactory.createXYLineChart("Regression Chart", "X", "Y", null,
                PlotOrientation.VERTICAL, false, false, false);

        XYPlot plot = chart.getXYPlot();
        plot.setRenderer(renderer);
        chart.setAntiAlias(true);
    }

    public void reportResult(final AbstractRegressionResult result) {
        if (result instanceof LinearRegressionResult) {
            reportResult((LinearRegressionResult) result);

        } else if (result instanceof NonLinearRegressionResult) {
            reportResult((NonLinearRegressionResult) result);
        }
    }

    /**
     * Reports the result in a chart.
     * 
     * Something here is based on example located at
     * http://www.java2s.com/Code/Java/Chart/JFreeChartXYLineAndShapeRendererDemo.htm
     */
    public void reportResult(final LinearRegressionResult result) {
        final LineFunction2D lineFunction2D = new LineFunction2D(result.coefA, result.coefB);

        final XYDataset xyDataset = DatasetUtilities.sampleFunction2D(lineFunction2D, result.min(),
                result.max(), 500, "Fitted Regression Line");

        chart.getXYPlot()
                .setDataset(
                        1,
                        createRegressionDataset((XYSeriesCollection) xyDataset,
                                result.getPointsIn2DSpace()));
        chart.setTitle("Linear Regression");
    }

    /**
     * Reports the result in a chart.
     * 
     * Something here is based on example located at
     * http://www.java2s.com/Code/Java/Chart/JFreeChartXYLineAndShapeRendererDemo.htm
     */
    public void reportResult(final NonLinearRegressionResult result) {
        final PowerFunction2D powerFunction2D = new PowerFunction2D(result.coefC, 2);

        final XYDataset xyDataset = DatasetUtilities.sampleFunction2D(powerFunction2D,
                result.min(), result.max(), 500, "Fitted Non-Regression Line");

        chart.getXYPlot()
                .setDataset(
                        1,
                        createRegressionDataset((XYSeriesCollection) xyDataset,
                                result.getPointsIn2DSpace()));

        chart.setTitle("Non-Linear Regression");
    }

    /**
     * Clear the regression chart.
     */
    public void clear() {
        chart.getXYPlot().setDataset(1, null);
        chart.setTitle("Regression Chart");
    }

    /**
     * Returns JFreeChart chart.
     */
    public JFreeChart getJFreeChart() {
        return chart;
    }

    private XYDataset createRegressionDataset(final XYSeriesCollection regressionDataset,
            final List<Point> pointsIn2DSpace) {
        final XYSeries xySeries = new XYSeries("The points in 2D space");

        for (Point point : pointsIn2DSpace) {
            xySeries.add(point.getX(), point.getY());
        }
        regressionDataset.addSeries(xySeries);
        return regressionDataset;
    }

}
