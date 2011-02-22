/*
 * Point.java
 * 
 * Created on 14/07/2007, 04:22:50
 */

package org.modelmat.core.regression;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * A 2D point in the space, based on the coordinate (x, y).
 * 
 * @author Rafael Fiume
 */
public class Point implements Comparable<Point> {

    /**
     * The x coordinate.
     */
    private final Double x;

    /**
     * The y coordinate.
     */
    private final Double y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public int compareTo(final Point other) {
        return new CompareToBuilder().append(x, other.x).append(y, other.y).toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1585598641, -261858049).append(x).append(y).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Point)) {
            return false;
        }
        final Point castOther = (Point) other;
        return new EqualsBuilder().append(x, castOther.x).append(y, castOther.y).isEquals();
    }
}