/*
 * NonLinearRegression.java
 *
 * Created on 20 de Dezembro de 2006, 05:43
 */
package org.ptolomeu.core.regression;

import java.util.Map;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import static org.ptolomeu.core.regression.RegressionUtils.sumX;
import static org.ptolomeu.core.regression.RegressionUtils.sumX2;
import static org.ptolomeu.core.regression.RegressionUtils.sumX2Y;
import static org.ptolomeu.core.regression.RegressionUtils.sumX3;
import static org.ptolomeu.core.regression.RegressionUtils.sumX4;
import static org.ptolomeu.core.regression.RegressionUtils.sumXY;
import static org.ptolomeu.core.regression.RegressionUtils.sumY;

/**
 * @author Rafael Fiume
 * @author JoÃ£o AurÃ©lio B. Franzini
 */
public class NonLinearRegression implements Regression {

    private static final int MIN_COORD = 3;

    @Override
    public NonLinearRegressionResult doRegression(final Map<GridIndex, Double> matriz)
            throws InsufficientDataException, CoordinateNumberException {

        final int numCoord = (matriz.size() / 2);

        if (numCoord < MIN_COORD) {
            throw new InsufficientDataException("Minimum number of coordinates to calculate linear regression is " + MIN_COORD);
        }

        final double a11 = (double) (matriz.size() / 2);
        double a21 = sumX(matriz);
        double a31 = sumX2(matriz);
        final double a12 = a21;
        double a22 = a31;
        double a32 = sumX3(matriz);
        final double a13 = a31;
        double a23 = a32;
        double a33 = sumX4(matriz);

        final double y1 = sumY(matriz);
        double y2 = sumXY(matriz);
        double y3 = sumX2Y(matriz);

        final double m21 = a21 / a11;
        final double m31 = a31 / a11;

        if (m21 != 0) {
            a21 = a21 - (a11 * m21);
            a22 = a22 - (a12 * m21);
            a23 = a23 - (a13 * m21);
        }

        if (m31 != 0) {
            a31 = a31 - (a11 * m31);
            a32 = a32 - (a12 * m31);
            a33 = a33 - (a13 * m31);
        }

        final double m32 = a32 / a22;

        if (m32 != 0) {
            a32 = a32 - (a22 * m32);
            a33 = a33 - (a23 * m32);
        }

        y2 = y2 - (m21 * y1);
        y3 = y3 - m31 * y1 - m32 * y2;

        final double coefC = y3 / a33;
        final double coefB = (y2 - (a23 * coefC)) / a22;
        final double coefA = (y1 - (a13 * coefC) - (a12 * coefB)) / a11;

        return new NonLinearRegressionResult(coefA, coefB, coefC, matriz);
    }

}
