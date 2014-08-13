package org.ptolomeu.gui.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import static javax.swing.JTable.AUTO_RESIZE_OFF;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.border.BevelBorder.RAISED;

public final class SpreadsheetView extends JPanel {

    private final JScrollPane spTable = new JScrollPane();

    private final JTable tableRowHeader = new JTable();

    private final JTable table;

    public SpreadsheetView(final SpreadsheetModel model) {
        this.table = new JTable() {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                final TableColumnModel tableColumnModel = model.getTableColumnModel();
                setColumnModel(tableColumnModel);
                return new JTableHeader(tableColumnModel);
            }
        };

        initComponents(model);
        setUpLayout();
    }

    private void initComponents(SpreadsheetModel model) {
        tableRowHeader.setModel(model.getTableRowHeaderModel());
        configTableRowHeader();

        table.setModel(model);
        table.setRowSelectionAllowed(false);
        table.setModel(model);
        configTableHeader();

        spTable.setBorder(null);
        spTable.setRowHeaderView(tableRowHeader);
        spTable.setViewportView(table);
    }

    private void setUpLayout() {
        setLayout(new FormLayout("max(10dlu;default)", "fill:pref:grow"));
        add(spTable, new CellConstraints().xy(1, 1));
    }

    private void configTableRowHeader() {
        final int COL_SIZE = 40;

        final TableRowHeaderCellRenderer renderer = new TableRowHeaderCellRenderer();
        tableRowHeader.setDefaultRenderer(String.class, renderer);
        tableRowHeader.setAutoResizeMode(AUTO_RESIZE_OFF);
        tableRowHeader.setRowHeight(table.getRowHeight());
        tableRowHeader.setRowSelectionAllowed(false);
        tableRowHeader.setShowHorizontalLines(table.getShowHorizontalLines());
        tableRowHeader.setShowVerticalLines(table.getShowVerticalLines());
        tableRowHeader.setIntercellSpacing(new Dimension(0, 0));
        tableRowHeader.setGridColor(table.getGridColor());
        tableRowHeader.setPreferredScrollableViewportSize(new Dimension(COL_SIZE, table.getHeight()));

        final TableColumn column = tableRowHeader.getColumnModel().getColumn(0);
        column.setMinWidth(COL_SIZE);
        column.setMaxWidth(COL_SIZE);
        column.setWidth(COL_SIZE);

        renderer.setHorizontalAlignment(CENTER);
        column.setCellRenderer(renderer);
    }

    private void configTableHeader() {
        final JTableHeader header = table.getTableHeader();
        header.setBorder(new SoftBevelBorder(RAISED));
        header.setDefaultRenderer(new CustomTableCellRenderer(header));
    }

    private static class CustomTableCellRenderer implements TableCellRenderer {

        private final TableCellRenderer headerRenderer;

        CustomTableCellRenderer(JTableHeader header) {
            this.headerRenderer = header.getDefaultRenderer();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final Component comp = headerRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            comp.setFont(new Font("Lucida Sans", 0, 14));
            return comp;
        }
    }

    private static class TableRowHeaderCellRenderer extends DefaultTableCellRenderer {

        private final Font font = new Font("Lucida Sans", 0, 12);

        private final SoftBevelBorder border = new SoftBevelBorder(RAISED);

        private final Color backgroundColor = new Color(238, 238, 238);

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setFont(font);
            setBorder(border);
            setBackground(backgroundColor);
            setValue(value);
            return this;
        }
    }

}
