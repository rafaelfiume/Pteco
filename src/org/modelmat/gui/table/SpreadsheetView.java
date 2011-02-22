/*
 * VTable.java
 *
 * Created on 19 de Dezembro de 2006, 18:35
 */

package org.modelmat.gui.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.jdesktop.application.Action;

/**
 * @author Rafael Fiume.
 */
public final class SpreadsheetView extends JPanel {

    /**
     * Creates new TableView.
     * 
     * <strong>ATENÇÃO:</strong> Não utilize esse construtor. O construtor padrão é utilizado apenas
     * para atender a especificação JavaBean. Dessa forma, o componente pode ser instanciado por
     * construtores de interface gráficas, como o Matisse.
     * <p>
     * 
     * Utilize sempre o construtor TableView(DataTableModel tableModel), caso contrário o model
     * dessa vew será null.
     */
    public SpreadsheetView() {
        super();
        initComponents();
        // table.putClientProperty(
        // SubstanceLookAndFeel.WATERMARK_TO_BLEED,
        // Boolean.FALSE);
    }

    /**
     * Creates a new TableView with the specified DataTableModel.
     */
    public SpreadsheetView(SpreadsheetModel model) {
        this();
        table.setModel(model);
    }

    /**
     * Action's supostamente devem ficar na model (ou PresentationModel). Porém #changeColumnModel
     * parece estar melhor na view, já que a propriedade tableHeader, alvo desse método, faz parte
     * da JTable (i.e. a view).
     */
    @Action
    public void changeColumnName() {
        TableColumnNameDialog.showDialog(table.getTableHeader());
    }

    // Configure the Table ****************************************************

    /*
     * Configure the table row header.
     */
    private void configTableRowHeader() {
        final int COL_SIZE = 40;

        final TableRowHeaderCellRenderer renderer = new TableRowHeaderCellRenderer();

        tableRowHeader.setDefaultRenderer(String.class, renderer);
        tableRowHeader.setRowHeight(table.getRowHeight());
        tableRowHeader.setRowSelectionAllowed(false);
        tableRowHeader.setShowHorizontalLines(table.getShowHorizontalLines());
        tableRowHeader.setShowVerticalLines(table.getShowVerticalLines());
        tableRowHeader.setIntercellSpacing(new Dimension(0, 0));
        tableRowHeader.setGridColor(table.getGridColor());
        tableRowHeader
                .setPreferredScrollableViewportSize(new Dimension(COL_SIZE, table.getHeight()));

        final TableColumn column = tableRowHeader.getColumnModel().getColumn(0);
        column.setMinWidth(COL_SIZE);
        column.setMaxWidth(COL_SIZE);
        column.setWidth(COL_SIZE);

        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        column.setCellRenderer(renderer);
    }

    /*
     * Configure the table header.
     */
    private void configTableHeader() {
        final JTableHeader header = table.getTableHeader();

        header.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        final DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header
                .getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        header.setDefaultRenderer(new CustomTableCellRenderer(header));
    }

    @SuppressWarnings("LocalVariableCouldBeFinal")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableRowHeader = new javax.swing.JTable();
        spTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        tableRowHeader.setModel(new TableRowHeaderModel());
        tableRowHeader.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        // Post-init tableRowHeader code
        configTableRowHeader();
        // //////////////////////////////////////////////

        spTable.setBorder(null);
        // Post-init code. ////////////////////
        spTable.setRowHeaderView(tableRowHeader);
        // //////////////////////////////////////////////////

        table.setRowSelectionAllowed(false);
        // Post-init tableInput code
        configTableHeader();
        // ///////////////////////////
        spTable.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(spTable,
                javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(spTable,
                javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                486, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane spTable;

    private javax.swing.JTable table;

    private javax.swing.JTable tableRowHeader;

    // End of variables declaration//GEN-END:variables

    private static class CustomTableCellRenderer implements TableCellRenderer {

        final TableCellRenderer headerRenderer;

        public CustomTableCellRenderer(JTableHeader header) {
            super();
            headerRenderer = header.getDefaultRenderer();
        }

        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value,
                final boolean isSelected, final boolean hasFocus, final int row, final int column) {

            final Component comp = headerRenderer.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);

            comp.setFont(new Font("Lucida Sans", 0, 14));

            return comp;
        }
    }

    private static class TableRowHeaderCellRenderer extends DefaultTableCellRenderer {

        Font font = new java.awt.Font("Lucida Sans", 0, 12);

        SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);

        Color backgroundColor = new Color(238, 238, 238);

        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value,
                final boolean isSelected, final boolean hasFocus, final int row, final int column) {

            setFont(font);
            setBorder(border);
            setBackground(backgroundColor);
            setValue((String) value);

            return this;
        }
    }

    private class TableRowHeaderModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return table.getModel().getRowCount();
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
