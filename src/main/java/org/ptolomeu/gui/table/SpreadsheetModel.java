/*
 * TableInputModel.java
 *
 * Created on 19 de Dezembro de 2006, 21:36
 */
package org.ptolomeu.gui.table;

import org.jdesktop.application.Action;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class SpreadsheetModel implements TableModel, Serializable {

    private static final int NUM_ROW = 5000;

    private final Map<CellIndex, Double> cellValues = new TreeMap();

    private final String[] columnName;
    private final int numColumn;

    private final Class[] classType;

    private final boolean[] isEditable;

    private final EventListenerList listeners = new EventListenerList();

    private final TableColumnModel tableColumnModel = new DefaultTableColumnModel();

    private int maxRow = 0;

    public SpreadsheetModel() {
        this.columnName = loadTableColumnNames();
        this.numColumn = columnName.length;
        classType = loadTableColumnTypes();
        isEditable = loadTableColumnIsEditable();
    }

    // Actions ***************************************************************

    @Action
    public void changeColumnName() {
        ChangeTableColumnsNameDialog.showDialog(tableColumnModel);
        fireTableChanged(new TableModelEvent(this, TableModelEvent.HEADER_ROW, TableModelEvent.HEADER_ROW));
    }

    public void clear() {
        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c < numColumn; c++) {
                setValueAt(null, r, c);
            }
        }
        fireTableChanged(new TableModelEvent(this));
    }

    // Implementing TableModel ***********************************************

    @Override
    public int getRowCount() {
        return NUM_ROW;
    }

    @Override
    public int getColumnCount() {
        return numColumn;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        return classType[columnIndex];
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return isEditable[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return cellValues.get(new CellIndex(rowIndex, columnIndex));
    }

    @Override
    public void setValueAt(Object aValue, final int rowIndex, int columnIndex) {
        if (aValue == null) {
            cellValues.remove(new CellIndex(rowIndex, columnIndex));
            return;
        }
        cellValues.put(new CellIndex(rowIndex, columnIndex), (Double) aValue);

        maxRow = Math.max(maxRow, rowIndex);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Managing Listeners  ***************************************************

    @Override
    public void addTableModelListener(final TableModelListener l) {
        listeners.add(TableModelListener.class, l);
    }

    @Override
    public void removeTableModelListener(final TableModelListener l) {
        listeners.remove(TableModelListener.class, l);
    }

    // Others helpful methods ************************************************

    public Map<CellIndex, Double> getCellValues() {
        return Collections.unmodifiableMap(cellValues);
    }

    public TableColumnModel getTableColumnModel() {
        return tableColumnModel;
    }

    TableModel getTableRowHeaderModel() {
        return new TableRowHeaderModel(this);
    }

    private void fireTableCellUpdated(final int row, final int column) {
        fireTableChanged(new TableModelEvent(this, row, row, column));
    }

    private void fireTableChanged(final TableModelEvent e) {
        final Object[] listenerList = listeners.getListenerList();

        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == TableModelListener.class) {
                ((TableModelListener) listenerList[i + 1]).tableChanged(e);
            }
        }
    }

    private String[] loadTableColumnNames() {
        return new String[] { "Coord X", "Coord Y", };
    }

    private Class<?>[] loadTableColumnTypes() {
        return new Class[] { Double.class, Double.class, };
    }

    private boolean[] loadTableColumnIsEditable() {
        return new boolean[] { true, true, };
    }

    private static class TableRowHeaderModel extends AbstractTableModel {

        private final TableModel tableModel;

        private TableRowHeaderModel(TableModel tableModel) {
            this.tableModel = tableModel;
        }

        @Override
        public int getRowCount() {
            return tableModel.getRowCount();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(final int row, final int column) {
            return String.valueOf(row + 1);
        }
    }

}
