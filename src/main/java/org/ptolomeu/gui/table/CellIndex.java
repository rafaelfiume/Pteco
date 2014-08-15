/*
 *
 * Created on 14/07/2007, 04:22:50
 */
package org.ptolomeu.gui.table;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CellIndex implements Comparable<CellIndex> {

    private final int rowIndex;

    private final int columnIndex;

    public CellIndex(int rowIndex, int columnIndex) {
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
    public int compareTo(final CellIndex other) {
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
        if (!(other instanceof CellIndex)) {
            return false;
        }
        final CellIndex castOther = (CellIndex) other;
        return new EqualsBuilder().append(rowIndex, castOther.rowIndex).append(columnIndex, castOther.columnIndex).isEquals();
    }
}
