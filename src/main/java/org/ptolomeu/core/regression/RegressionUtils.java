package org.ptolomeu.core.regression;

import java.util.List;

final class RegressionUtils {

    private RegressionUtils() {
        // Utility class
    }

    static double sumX(List<Point> orderedPairs) {
        double somaDeX = 0.0;
        for (Point pair : orderedPairs) {
            somaDeX += pair.x();
        }

        return somaDeX;
    }

    static double sumY(List<Point> orderedPairs) {
        double somaDeY = 0.0;
        for (Point pair : orderedPairs) {
            somaDeY += pair.y();
        }

        return somaDeY;
    }

    static double sumXY(List<Point> orderedPairs) {
        double somaDeMultDeXY = 0.0;
        for (Point pair : orderedPairs) {
            somaDeMultDeXY +=  pair.x() * pair.y();
        }

        return somaDeMultDeXY;
    }

    static double sumX2(List<Point> orderedPairs) {
        double somaDeX2 = 0.0;
        for (Point pair : orderedPairs) {
            somaDeX2 += Math.pow(pair.x(), 2);
        }

        return somaDeX2;
    }

    static double sumY2(List<Point> orderedPairs) {
        double somaDeY2 = 0.0;
        for (Point pair : orderedPairs) {
            somaDeY2 += Math.pow(pair.y(), 2);
        }

        return somaDeY2;
    }

    static double sumX3(List<Point> orderedPairs) {
        double somaDeX3 = 0.0;
        for (Point pair : orderedPairs) {
            somaDeX3 += Math.pow(pair.x(), 3);
        }

        return somaDeX3;
    }

    static double sumX4(List<Point> orderedPairs) {
        double somaDeX4 = 0.0;
        for (Point pair : orderedPairs) {
            somaDeX4 += Math.pow(pair.x(), 4);
        }

        return somaDeX4;
    }

    static double sumX2Y(List<Point> orderedPairs) {
        double somaDeMultDeX2Y = 0.0;
        for (Point pair : orderedPairs) {
            somaDeMultDeX2Y += Math.pow(pair.x(), 2) * pair.y();
        }

        return somaDeMultDeX2Y;
    }
}
