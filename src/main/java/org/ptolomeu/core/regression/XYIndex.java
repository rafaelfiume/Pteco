/*
 * Point.java
 * 
 * Created on 14/07/2007, 04:22:50
 */
package org.ptolomeu.core.regression;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Maps a single coordinate, x or y, in a spreadsheet.
 *
 * TODO It's necessary to diferenciate this class from Point.
 */
public class XyIndex implements Comparable<XyIndex> {

    /**
     * The row index.
     */
    private final int row;

    /**
     * The column index.
     */
    private final int column;

    public XyIndex(int row, int column) {
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
    public int compareTo(final XyIndex other) {
        return new CompareToBuilder().append(row, other.row).append(column, other.column).toComparison();
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
        if (!(other instanceof XyIndex)) {
            return false;
        }
        final XyIndex castOther = (XyIndex) other;
        return new EqualsBuilder().append(row, castOther.row).append(column, castOther.column).isEquals();
    }
}
