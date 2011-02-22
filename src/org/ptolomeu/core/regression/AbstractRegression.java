/*
 * AbstractRegression.java
 *
 * Created on 20 de Dezembro de 2006, 04:07
 */

package org.ptolomeu.core.regression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

/**
 * 
 * @author Rafael Fiume
 */
public abstract class AbstractRegression {

    public enum RegressionType {
        LINEAR, NON_LINEAR;
    }

    protected int MIN_COORD = 3;

    public abstract AbstractRegressionResult doRegression(Map<XYIndex, Double> coordValues)
            throws InsufficientDataException, CoordinateNumberException;

    protected double sumX(final Map<XYIndex, Double> coordValues) {
        double somaDeX = 0.0;

        for (XYIndex coord : coordValues.keySet()) {
            if (coord.getColumn() == 0) {
                somaDeX += coordValues.get(coord);
            }
        }

        return somaDeX;
    }

    protected double sumY(final Map<XYIndex, Double> coordValues) {
        double somaDeY = 0.0;

        for (XYIndex coord : coordValues.keySet()) {
            if (coord.getColumn() == 1) {
                somaDeY += coordValues.get(coord);
            }
        }

        return somaDeY;
    }

    protected double sumXY(final Map<XYIndex, Double> coordValues) throws CoordinateNumberException {
        int numCoordX = 0;
        int numCoordY = 0;
        double somaDeMultDeXY = 0.0;

        final List<Double> listX = new ArrayList<Double>();
        final List<Double> listY = new ArrayList<Double>();

        for (XYIndex coord : coordValues.keySet()) {
            if (coord.getColumn() == 0) {
                listX.add(coordValues.get(coord));
                numCoordX++;
                continue;

            } else if (coord.getColumn() == 1) {
                listY.add(coordValues.get(coord));
                numCoordY++;
            }
        }

        if (numCoordX != numCoordY) {
            throw new CoordinateNumberException();
        }

        final Iterator<Double> itX = listX.iterator();
        final Iterator<Double> itY = listY.iterator();

        while (itX.hasNext() && itY.hasNext()) {
            final Double dX = itX.next();
            final Double dY = itY.next();
            somaDeMultDeXY += dX.doubleValue() * dY.doubleValue();
        }

        return somaDeMultDeXY;
    }

    protected double sumX2(final Map<XYIndex, Double> coordValues) {
        double somaDeX2 = 0.0;

        for (XYIndex coord : coordValues.keySet()) {

            if (coord.getColumn() == 0) {
                Double dX2 = coordValues.get(coord);
                somaDeX2 += Math.pow(dX2.doubleValue(), 2);
            }
        }

        return somaDeX2;
    }

    protected double sumY2(Map<XYIndex, Double> coordValues) {
        double somaDeY2 = 0.0;

        for (XYIndex coord : coordValues.keySet()) {

            if (coord.getColumn() == 1) {
                Double dY2 = coordValues.get(coord);
                somaDeY2 += Math.pow(dY2.doubleValue(), 2);
            }
        }

        return somaDeY2;
    }

    protected double sumX3(final Map<XYIndex, Double> coordValues) {
        double somaDeX3 = 0.0;

        for (XYIndex coord : coordValues.keySet()) {

            if (coord.getColumn() == 0) {
                Double dX3 = coordValues.get(coord);
                somaDeX3 += Math.pow(dX3.doubleValue(), 3);
            }
        }

        return somaDeX3;
    }

    protected double sumX4(final Map<XYIndex, Double> coordValues) {
        double somaDeX4 = 0.0;

        for (XYIndex coord : coordValues.keySet()) {

            if (coord.getColumn() == 0) {
                Double dX4 = coordValues.get(coord);
                somaDeX4 += Math.pow(dX4.doubleValue(), 4);
            }
        }

        return somaDeX4;
    }

    protected double sumX2Y(final Map<XYIndex, Double> coordValues) {
        double somaDeMultDeX2Y = 0.0;

        List<Double> listX = new ArrayList<Double>();
        List<Double> listY = new ArrayList<Double>();

        for (XYIndex coord : coordValues.keySet()) {

            if (coord.getColumn() == 0) {
                listX.add(coordValues.get(coord));
                continue;

            } else if (coord.getColumn() == 1) {
                listY.add(coordValues.get(coord));
            }
        }

        final Iterator<Double> itX = listX.iterator();
        final Iterator<Double> itY = listY.iterator();

        while (itX.hasNext() && itY.hasNext()) {
            Double dX = itX.next();
            Double dY = itY.next();

            somaDeMultDeX2Y += Math.pow(dX, 2) * dY;
        }

        return somaDeMultDeX2Y;
    }

}
