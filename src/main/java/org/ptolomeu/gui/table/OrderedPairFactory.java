/*
 * AbstractRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 03:58
 */
package org.ptolomeu.gui.table;

import org.ptolomeu.core.regression.GridIndex;
import org.ptolomeu.core.regression.Point;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;

import java.util.*;

import static java.util.Collections.unmodifiableList;

/**
 * Check <a href="http://en.wikipedia.org/wiki/Ordered_pair">this</a> if you want to know more about Ordered Pair.
 */
final class OrderedPairFactory {

    private OrderedPairFactory() {
        // Use factory method
    }

    /**
     * Returns a list of ordered pair. <p/>
     *
     * It expects ordered gridValues. If it's not ordered, this method behaves unpredictable.
     */
    static List<Point> getOrderedPairs(TreeMap<GridIndex, Double> gridValues) {
        final List<Point> orderedPairs = new ArrayList<>(gridValues.size());
        final Set<GridIndex> indexes = gridValues.keySet();

        final Map<Integer, MutablePoint> rows = new HashMap<>();
        for (GridIndex index : indexes) {
            final Double value = gridValues.get(index);
            final int rowIndex = index.getRowIndex();

            if (rows.containsKey(rowIndex)) {
                rows.get(rowIndex).update(index, value);

            } else {
                rows.put(rowIndex, MutablePoint.newInstance(index, value));
            }
        }

        for (Map.Entry<Integer, MutablePoint> row : rows.entrySet()) {
            orderedPairs.add(row.getValue().newPoint());
        }

        return unmodifiableList(orderedPairs);
    }

    private static final class MutablePoint {

        private Double x;

        private Double y;

        static MutablePoint newInstance(GridIndex index, Double value) {
            MutablePoint mp = new MutablePoint();
            mp.update(index, value);

            return mp;
        }

        void update(GridIndex index, Double value) {
            if (abscissaIn(index)) {
                x = value;

            } else if (ordinateIn(index)){
                y = value;
            }
        }

        private boolean abscissaIn(GridIndex index) {
            return index.getColumnIndex()  == 0;
        }

        private boolean ordinateIn(GridIndex index) {
            return index.getColumnIndex()  == 1;
        }

        public Point newPoint() {
            if (x == null || y == null) {
                throw new CoordinateNumberException(errorMessageFor(x, y));
            }
            return new Point(x, y);
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
