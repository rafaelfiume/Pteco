/*
 * LinearRegression.java
 *
 * Created on 20 de Dezembro de 2006, 05:09
 */

package org.ptolomeu.core.regression;


import java.util.Map;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

/**
 *
 * @author Rafael Fiume
 */
public class LinearRegression extends AbstractRegression {

    private double sumX, sumY, sumX2, sumY2, sumXY;

    private double desvioPadraoX, desvioPadraoY;
    private double covarianciaXY;
    private double coefDeCorrelacao;

    public LinearRegressionResult doRegression(
                final Map<XYIndex, Double> coordValues)
                throws InsufficientDataException, CoordinateNumberException {

        final int numCoord = (coordValues.size() / 2);

        if(numCoord < MIN_COORD) {
            throw new InsufficientDataException();
        }

        final LinearRegressionResult linearResult = new LinearRegressionResult();

        sumX  = sumX(coordValues);
        sumY  = sumY(coordValues);
        sumX2 = sumX2(coordValues);
        sumY2 = sumY2(coordValues);
        sumXY = sumXY(coordValues);

        linearResult.coefB = ((numCoord * sumXY) - (sumX * sumY)) /
                             ((numCoord * sumX2) - (sumX * sumX));

        linearResult.coefA = (sumY - (linearResult.coefB * sumX)) / numCoord;
        linearResult.coefDeCorrelacao   = getCorrelationCoefficient(numCoord);
        linearResult.coefDeDeterminacao = getDeterminationCoefficient();
        linearResult.setCoordValues(coordValues);

        return linearResult;
    }

    /**
     * Computes and returns the correlation coefficient
     * of the linear regression.
     */
    private double getCorrelationCoefficient(final int numCoord) {
        desvioPadraoX =
                sumX2 - (( 1 / (double) numCoord ) * (Math.pow(sumX, 2)));

        desvioPadraoY =
                sumY2 - ((1 / (double) numCoord) * (Math.pow(sumY, 2)));

        covarianciaXY =
                sumXY - ((1 / (double) numCoord ) * (sumX * sumY));

        coefDeCorrelacao =
                covarianciaXY / Math.sqrt(desvioPadraoX * desvioPadraoY);

        return coefDeCorrelacao;
    }

    /**
     * Computes and returns the determination coefficient
     * of the linear regression.
     */
    private double getDeterminationCoefficient() {
        return Math.pow(coefDeCorrelacao, 2);
    }

}

