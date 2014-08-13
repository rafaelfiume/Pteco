/*
 * LinearRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 04:00
 */
package org.ptolomeu.core.regression;

import java.util.List;

public final class LinearRegressionResult extends AbstractRegressionResult {

    /* f(x) = a + bx */

    private final double coefA;
    private final double coefB;
    private final double coefDeCorrelacao;
    private final double coefDeDeterminacao;

    public LinearRegressionResult(double coefA, double coefB, double coefDeCorrelacao, double coefDeDeterminacao, List<Point> orderedPairs) {
        super(orderedPairs);
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefDeCorrelacao = coefDeCorrelacao;
        this.coefDeDeterminacao = coefDeDeterminacao;
    }

    public double coefA() {
        return coefA;
    }

    public double coefB() {
        return coefB;
    }

    public double coefDeCorrelacao() {
        return coefDeCorrelacao;
    }

    public double coefDeDeterminacao() {
        return coefDeDeterminacao;
    }

    public String toString() {
        return new StringBuilder("Linear Regression: ")
                .append(coefA).append("\t").append(coefB).append("\t").append(coefDeCorrelacao).append("\t").append(coefDeDeterminacao).toString();
    }

}
