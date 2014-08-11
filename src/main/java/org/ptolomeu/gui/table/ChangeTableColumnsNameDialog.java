/*
 * VColumnNameDialog.java
 *
 * Created on 20 de Dezembro de 2006, 07:29
 */
package org.ptolomeu.gui.table;

import com.jgoodies.forms.builder.ButtonBarBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Make this dialog request focus when it appears.
public class ChangeTableColumnsNameDialog extends javax.swing.JDialog {

    private static ChangeTableColumnsNameDialog INSTANCE;

    private final JTableHeader tableHeader;

    private final JLabel lCoordX = new JLabel();
    private final JLabel lCoordY = new JLabel();

    private final JTextField tfCoordX = new JTextField();
    private final JTextField tfCoordY = new JTextField();

    private final JButton bCancel = new JButton();
    private final JButton bOk = new JButton();

    private ChangeTableColumnsNameDialog(JTableHeader tableHeader) {
        super((Frame) null, true);
        this.tableHeader = tableHeader;
        initComponents();
        setUpLayout();
    }

    public synchronized static void showDialog(JTableHeader tableHeader) {
        if (INSTANCE == null) {
            INSTANCE = new ChangeTableColumnsNameDialog(tableHeader);
        }
        INSTANCE.setVisible(true);
    }

    private void initComponents() {
        setTitle("Edit Column Name");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lCoordX.setText("Coord. X:");
        lCoordY.setText("Coord. Y:");

        bOk.setText("Ok");
        bOk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
    }

    private void setUpLayout() {
        getContentPane().setLayout(
                new FormLayout(
                        "4dlu, right:pref, 4dlu, 100dlu, 4dlu, min",
                        "2dlu, pref, 2dlu, pref, 6dlu, pref")
        );

        final CellConstraints cc = new CellConstraints();
        add(lCoordX, cc.xy(2, 2));
        add(tfCoordX, cc.xy(4, 2));

        add(lCoordY, cc.xy(2, 4));
        add(tfCoordY, cc.xy(4, 4));

        add(buildButtonBar(), cc.xyw(2, 6, 4));
        pack();
    }

    private void bOkActionPerformed(ActionEvent evt) {
        if (changeColumnName()) {
            clearFields();
            dispose();
        }
    }

    private void bCancelActionPerformed(ActionEvent evt) {
        clearFields();
        dispose();
    }

    private void clearFields() {
        tfCoordX.setText("");
        tfCoordY.setText("");
    }

    private boolean changeColumnName() {
        final String[] columnName = {tfCoordX.getText(), tfCoordY.getText()};

        if ((columnName[0].compareTo("") == 0) || (columnName[1].compareTo("") == 0)) {
            JOptionPane.showMessageDialog(this, "Type the name of the columns.", "OPS!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        for (int i = 0; i < columnName.length; i++) {
            tableHeader.getColumnModel().getColumn(i).setHeaderValue(columnName[i]);
        }
        return true;
    }

    private Component buildButtonBar() {
        return new ButtonBarBuilder().addGlue().addButton(bOk).addRelatedGap().addButton(bCancel).addRelatedGap().getPanel();
    }

}
