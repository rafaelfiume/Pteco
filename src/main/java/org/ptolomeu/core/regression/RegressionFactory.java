/*
 * RegressionFactory.java
 *
 * Created on 28/07/2007, 18:02:06
 */
package org.ptolomeu.core.regression;

public class RegressionFactory {

    private static RegressionFactory INSTANCE = new RegressionFactory();

    private RegressionFactory() {
        // Use factory method instead.
    }

    public static synchronized RegressionFactory getInstance() {
        return INSTANCE;
    }

    public Regression getRegression(Regression.Type type) {
        switch (type) {
            case LINEAR: return newLinearRegression();
            case NON_LINEAR: return newNonLinearRegression();
        }
        throw new IllegalArgumentException("Unknown argument: " + type);
    }

    private Regression newLinearRegression() {
        return new LinearRegression();
    }

    private Regression newNonLinearRegression() {
        return new NonLinearRegression();
    }
}
