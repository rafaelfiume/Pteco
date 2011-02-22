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

/**
 * TBD: AbstractRegressionResult doesn't seems anemic, but its subclasses do.
 * 
 * @author Rafael Fiume
 */
public abstract class AbstractRegressionResult {

    /**
     * Os valores de acordo com sua coordenada (x, y).
     */
    protected Map<XYIndex, Double> coordValues;

    public void setCoordValues(final Map<XYIndex, Double> coordValues) {
        this.coordValues = coordValues;
    }

    public double min() {
        return Collections.min(coordValues.values());
    }

    public double max() {
        return Collections.max(coordValues.values());
    }

    public List<Point> getPointsIn2DSpace() {
        Set<XYIndex> indexes = coordValues.keySet();
        final List<Point> points = new ArrayList<Point>(15);

        for (XYIndex index : indexes) {
            if (index.getColumn() != 0) {
                continue;
            }

            final Double x = coordValues.get(index);
            final Double y = coordValues.get(new XYIndex(index.getRow(), index.getColumn() + 1));

            points.add(new Point(x, y));
        }

        return points;
    }
}
