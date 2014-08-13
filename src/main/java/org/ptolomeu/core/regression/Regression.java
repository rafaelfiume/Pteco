/*
 * AbstractRegression.java
 *
 * Created on 20 de Dezembro de 2006, 04:07
 */
package org.ptolomeu.core.regression;

import java.util.List;

public interface Regression {

    public enum Type {
        LINEAR, NON_LINEAR;
    }

    AbstractRegressionResult doRegression(List<Point> orderedPairs);

}
