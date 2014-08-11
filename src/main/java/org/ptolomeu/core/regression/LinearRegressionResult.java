/*
 * LinearRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 04:00
 */

package org.ptolomeu.core.regression;

/**
 * Anemic domain ?
 * 
 * @author Rafael Fiume
 */
public final class LinearRegressionResult extends AbstractRegressionResult {

    /** f(x) = a + bx */
    public double coefA;

    public double coefB;

    public double coefDeCorrelacao;

    public double coefDeDeterminacao;

    public String toString() {
        return new StringBuilder("Linear Regression: ").append(coefA).append("\t").append(coefB)
                .append("\t").append(coefDeCorrelacao).append("\t").append(coefDeDeterminacao)
                .toString();
    }
}
