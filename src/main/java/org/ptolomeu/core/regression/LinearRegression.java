/*
 * LinearRegression.java
 *
 * Created on 20 de Dezembro de 2006, 05:09
 */
package org.ptolomeu.core.regression;

import java.util.List;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import static org.ptolomeu.core.regression.RegressionUtils.sumX;
import static org.ptolomeu.core.regression.RegressionUtils.sumX2;
import static org.ptolomeu.core.regression.RegressionUtils.sumXY;
import static org.ptolomeu.core.regression.RegressionUtils.sumY;
import static org.ptolomeu.core.regression.RegressionUtils.sumY2;

public class LinearRegression implements Regression {

    private static final int MIN_COORD = 3;

    public LinearRegressionResult doRegression(List<Point> orderedPairs) {
        final int numCoord = orderedPairs.size();

        if (numCoord < MIN_COORD) {
            throw new InsufficientDataException("Minimum number of coordinates to calculate linear regression is " + MIN_COORD);
        }

        final double sumX = sumX(orderedPairs);
        final double sumY = sumY(orderedPairs);
        final double sumX2 = sumX2(orderedPairs);
        final double sumY2 = sumY2(orderedPairs);
        final double sumXY = sumXY(orderedPairs);

        final double coefB =
                ((numCoord * sumXY) - (sumX * sumY))
                        /
                ((numCoord * sumX2) - (sumX * sumX));

        final double coefA = (sumY - (coefB * sumX)) / numCoord;
        final double coefDeCorrelacao = getCorrelationCoefficient(numCoord, sumX, sumY, sumX2, sumY2, sumXY);
        final double coefDeDeterminacao = getDeterminationCoefficient(coefDeCorrelacao);

        return new LinearRegressionResult(coefA, coefB, coefDeCorrelacao, coefDeDeterminacao, orderedPairs);
    }

    /**
     * Computes and returns the correlation coefficient of the linear regression.
     */
    private double getCorrelationCoefficient(int numCoord, double sumX, double sumY, double sumX2, double sumY2, double sumXY) {
        final double desvioPadraoX = sumX2 - ((1 / (double) numCoord) * (Math.pow(sumX, 2)));

        final double desvioPadraoY = sumY2 - ((1 / (double) numCoord) * (Math.pow(sumY, 2)));

        final double covarianciaXY = sumXY - ((1 / (double) numCoord) * (sumX * sumY));

        return covarianciaXY / Math.sqrt(desvioPadraoX * desvioPadraoY);
    }

    /**
     * Computes and returns the determination coefficient of the linear regression.
     */
    private double getDeterminationCoefficient(double coefDeCorrelacao) {
        return Math.pow(coefDeCorrelacao, 2);
    }

}
