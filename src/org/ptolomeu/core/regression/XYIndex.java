/*
 * Point.java
 * 
 * Created on 14/07/2007, 04:22:50
 */

package org.ptolomeu.core.regression;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Maps a single coordinate, x or y, in a spreadsheet, for instance.
 * 
 * @author Rafael Fiume
 */
public class XYIndex implements Comparable<XYIndex> {

    /**
     * The row index.
     */
    private int row;

    /**
     * The column index.
     */
    private int column;

    public XYIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public int compareTo(final XYIndex other) {
        return new CompareToBuilder().append(row, other.row).append(column, other.column)
                .toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1585598641, -261858049).append(row).append(column).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XYIndex)) {
            return false;
        }
        final XYIndex castOther = (XYIndex) other;
        return new EqualsBuilder().append(row, castOther.row).append(column, castOther.column)
                .isEquals();
    }
}
