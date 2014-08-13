/*
 * NonLinearRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 04:00
 */
package org.ptolomeu.core.regression;

import java.util.List;

public class NonLinearRegressionResult extends AbstractRegressionResult {

    /* f(x) = a + bx + cx2 */

    private final double coefA;

    private final double coefB;

    private final double coefC;

    public NonLinearRegressionResult(double coefA, double coefB, double coefC, List<Point> orderedPairs) {
        super(orderedPairs);
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
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

}
