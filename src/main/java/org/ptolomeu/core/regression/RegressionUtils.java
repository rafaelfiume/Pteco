package org.ptolomeu.core.regression;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class RegressionUtils {

    private RegressionUtils() {
        // Utility class
    }

    static double sumX(final Map<GridIndex, Double> coordValues) {
        double somaDeX = 0.0;

        for (GridIndex coord : coordValues.keySet()) {
            if (coord.getColumnIndex() == 0) {
                somaDeX += coordValues.get(coord);
            }
        }

        return somaDeX;
    }

    static double sumY(final Map<GridIndex, Double> coordValues) {
        double somaDeY = 0.0;

        for (GridIndex coord : coordValues.keySet()) {
            if (coord.getColumnIndex() == 1) {
                somaDeY += coordValues.get(coord);
            }
        }

        return somaDeY;
    }

    static double sumXY(final Map<GridIndex, Double> coordValues) throws CoordinateNumberException {
        int numCoordX = 0;
        int numCoordY = 0;
        double somaDeMultDeXY = 0.0;

        final List<Double> listX = new ArrayList<>();
        final List<Double> listY = new ArrayList<>();

        for (GridIndex coord : coordValues.keySet()) {
            if (coord.getColumnIndex() == 0) {
                listX.add(coordValues.get(coord));
                numCoordX++;
                continue;

            } else if (coord.getColumnIndex() == 1) {
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

    static double sumX2(final Map<GridIndex, Double> coordValues) {
        double somaDeX2 = 0.0;

        for (GridIndex coord : coordValues.keySet()) {

            if (coord.getColumnIndex() == 0) {
                Double dX2 = coordValues.get(coord);
                somaDeX2 += Math.pow(dX2.doubleValue(), 2);
            }
        }

        return somaDeX2;
    }

    static double sumY2(Map<GridIndex, Double> coordValues) {
        double somaDeY2 = 0.0;

        for (GridIndex coord : coordValues.keySet()) {

            if (coord.getColumnIndex() == 1) {
                Double dY2 = coordValues.get(coord);
                somaDeY2 += Math.pow(dY2.doubleValue(), 2);
            }
        }

        return somaDeY2;
    }

    static double sumX3(final Map<GridIndex, Double> coordValues) {
        double somaDeX3 = 0.0;

        for (GridIndex coord : coordValues.keySet()) {

            if (coord.getColumnIndex() == 0) {
                Double dX3 = coordValues.get(coord);
                somaDeX3 += Math.pow(dX3.doubleValue(), 3);
            }
        }

        return somaDeX3;
    }

    static double sumX4(final Map<GridIndex, Double> coordValues) {
        double somaDeX4 = 0.0;

        for (GridIndex coord : coordValues.keySet()) {

            if (coord.getColumnIndex() == 0) {
                Double dX4 = coordValues.get(coord);
                somaDeX4 += Math.pow(dX4.doubleValue(), 4);
            }
        }

        return somaDeX4;
    }

    static double sumX2Y(final Map<GridIndex, Double> coordValues) {
        double somaDeMultDeX2Y = 0.0;

        List<Double> listX = new ArrayList<>();
        List<Double> listY = new ArrayList<>();

        for (GridIndex coord : coordValues.keySet()) {

            if (coord.getColumnIndex() == 0) {
                listX.add(coordValues.get(coord));
                continue;

            } else if (coord.getColumnIndex() == 1) {
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
