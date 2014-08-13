/*
 * AbstractRegressionResult.java
 *
 * Created on 20 de Dezembro de 2006, 03:58
 */
package org.ptolomeu.core.regression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.min;
import static java.util.Collections.unmodifiableList;

public abstract class AbstractRegressionResult {

    private final List<Point> orderedPairs;

    private final List<Double> xys;

    protected AbstractRegressionResult(List<Point> orderedPairs) {
        this.orderedPairs = unmodifiableList(orderedPairs);
        this.xys = extractValuesFrom(orderedPairs);
    }

    public final List<Point> orderedPairs() {
        return orderedPairs;
    }

    public double min() {
        return Collections.min(xys);
    }

    public double max() {
        return Collections.max(xys);
    }

    private List<Double> extractValuesFrom(List<Point> orderedPairs) {
        final List<Double> xys = new ArrayList<>();
        for (Point pair : orderedPairs) {
            xys.add(pair.x());
            xys.add(pair.y());
        }

        return unmodifiableList(xys);
    }

}
