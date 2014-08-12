/*
 * AbstractRegression.java
 *
 * Created on 20 de Dezembro de 2006, 04:07
 */
package org.ptolomeu.core.regression;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import java.util.Map;

public interface Regression {

    public enum Type {
        LINEAR, NON_LINEAR;
    }

    // TODO Replace GridIndex by Point
    AbstractRegressionResult doRegression(Map<GridIndex, Double> coordValues)
            throws InsufficientDataException, CoordinateNumberException;

}
