/*
 * AbstractRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 03:58
 */
package org.ptolomeu.core.regression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractRegressionResult {

    public double min() {
        return Collections.min(coordValues().values());
    }

    public double max() {
        return Collections.max(coordValues().values());
    }

    public List<Point> getCartesianCoordinates() {
        Set<GridIndex> indexes = coordValues().keySet();
        final List<Point> points = new ArrayList<>(15);

        for (GridIndex index : indexes) {
            if (index.getColumnIndex() != 0) {
                continue;
            }

            final Double x = coordValues().get(index);
            final Double y = coordValues().get(new GridIndex(index.getRowIndex(), index.getColumnIndex() + 1));

            points.add(new Point(x, y));
        }

        return points;
    }

    /**
     * Os valores de acordo com sua coordenada (x, y).
     */
    protected abstract Map<GridIndex, Double> coordValues();
}
