/*
 * NonLinearRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 04:00
 */

package org.ptolomeu.core.regression;

/**
 * 
 * @author Rafael Fiume
 */
public class NonLinearRegressionResult extends AbstractRegressionResult {

    /** f(x) = a + bx + cx2 */
    public double coefA;

    public double coefB;

    public double coefC;

    public String toString() {
        return new StringBuilder("Non Linear Regression Result: ").append(coefA).append("\t")
                .append(coefB).append("\t").append(coefC).toString();
    }

}
