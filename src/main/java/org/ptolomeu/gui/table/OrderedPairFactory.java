/*
 * AbstractRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 03:58
 */
package org.ptolomeu.gui.table;

import org.ptolomeu.core.regression.Point;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;

import java.util.*;

import static java.util.Collections.unmodifiableList;

/**
 * Check <a href="http://en.wikipedia.org/wiki/Ordered_pair">this</a> if you want to know more about Ordered Pair.
 */
public final class OrderedPairFactory {

    private OrderedPairFactory() {
        // Use factory method
    }

    /**
     * Returns a list of ordered pair. <p/>
     *
     * It expects ordered gridValues. If it's not ordered, this method behaves unpredictably.
     */
    public static List<Point> getOrderedPairs(Map<GridIndex, Double> gridValues) {
        final Set<GridIndex> indexes = gridValues.keySet();
        final Map<Integer, MutablePoint> rows = new HashMap<>();

        for (GridIndex index : indexes) {
            final Double value = gridValues.get(index);
            final int rowIndex = index.getRowIndex();

            if (rows.containsKey(rowIndex)) {
                rows.get(rowIndex).update(index, value);
            } else {
                rows.put(rowIndex, new MutablePoint().update(index, value));
            }
        }

        final List<Point> orderedPairs = new ArrayList<>(gridValues.size());
        for (MutablePoint row : rows.values()) {
            orderedPairs.add(row.newPoint());
        }

        return unmodifiableList(orderedPairs);
    }

    private static final class MutablePoint {

        private Double x;

        private Double y;

        MutablePoint update(GridIndex index, Double value) {
            if (abscissaIn(index)) {
                x = value;

            } else if (ordinateIn(index)){
                y = value;
            }
            return this;
        }

        Point newPoint() {
            if (x == null || y == null) {
                throw new CoordinateNumberException(errorMessageFor(x, y));
            }
            return new Point(x, y);
        }

        private boolean abscissaIn(GridIndex index) {
            return index.getColumnIndex()  == 0;
        }

        private boolean ordinateIn(GridIndex index) {
            return index.getColumnIndex()  == 1;
        }

        private String errorMessageFor(Double x, Double y) {
            final String name = (x == null) ? "abscissa" : "ordinate";
            return "Missing " + name + " (" + value(x) + ", " + value(y) + ")";
        }

        private String value(Double x) {
            return (x == null) ? "?" : x.toString();
        }
    }

}
