/*
 * NonLinearRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 04:00
 */
package org.ptolomeu.core.regression;

import java.util.Map;

public class NonLinearRegressionResult extends AbstractRegressionResult {

    /* f(x) = a + bx + cx2 */

    private final double coefA;

    private final double coefB;

    private final double coefC;

    private final Map<GridIndex, Double> coordValues;

    public NonLinearRegressionResult(double coefA, double coefB, double coefC, Map<GridIndex,Double> coordValues) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
        this.coordValues = coordValues;
    }

    public double coefA() {
        return coefA;
    }

    public double coefB() {
        return coefB;
    }

    public double coefC() {
        return coefC;
    }

    public String toString() {
        return new StringBuilder("Non Linear Regression Result: ")
                .append(coefA).append("\t").append(coefB).append("\t").append(coefC).toString();
    }

    @Override
    protected Map<GridIndex, Double> coordValues() {
        return coordValues;
    }

}
