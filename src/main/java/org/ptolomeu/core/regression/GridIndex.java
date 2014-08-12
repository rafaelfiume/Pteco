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
 * TODO Move it to table package
 */
public class GridIndex implements Comparable<GridIndex> {

    private final int rowIndex;

    private final int columnIndex;

    public GridIndex(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    @Override
    public int compareTo(final GridIndex other) {
        return new CompareToBuilder().append(rowIndex, other.rowIndex).append(columnIndex, other.columnIndex).toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1585598641, -261858049).append(rowIndex).append(columnIndex).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GridIndex)) {
            return false;
        }
        final GridIndex castOther = (GridIndex) other;
        return new EqualsBuilder().append(rowIndex, castOther.rowIndex).append(columnIndex, castOther.columnIndex).isEquals();
    }
}
