/*
 * ModelMatApplication.java
 *
 * Created on 16 de Julho de 2007, 10:43
 */

package org.ptolomeu.gui;

import org.jdesktop.application.Application;
import org.jdesktop.application.FrameView;
import org.jdesktop.swingx.JXStatusBar;
import org.ptolomeu.application.ModelMatApplication;
import org.ptolomeu.core.regression.AbstractRegression.RegressionType;
import org.ptolomeu.gui.action.ShowAboutDialog;
import org.ptolomeu.gui.action.ShowNotYetImplementedMessage;
import org.ptolomeu.gui.action.ShowTipOfTheDay;
import org.ptolomeu.gui.chart.ChartView;
import org.ptolomeu.gui.report.ReportView;
import org.ptolomeu.gui.table.SpreadsheetView;

/**
 * 
 * @author Rafael Fiume
 */
public class ModelMatView extends FrameView {

    /**
     * The presentation model of this view.
     * 
     * TODO: Make a more elaborated explanation of this model.
     * 
     * TODO: Can I make this model final?
     */
    private ApplicationModel applicationModel = new ApplicationModel(RegressionType.LINEAR);

    public ModelMatView(Application application) {
        super(application);
        initComponents();
        initSpecificActions();
    }

    /**
     * Init actions based on the Swing Application Framework (JSR-296).
     */
    private void initSpecificActions() {
        bEdit.setAction(getAction(SpreadsheetView.class, spreadsheet, "changeColumnName"));
        bRun.setAction(getAction(ApplicationModel.class, applicationModel, "doRegression"));
        bClear.setAction(getAction(ApplicationModel.class, applicationModel, "clear"));
        bPrint.setAction(new ShowNotYetImplementedMessage("Print",
                "/org/ptolomeu/gui/resources/Print16.gif",
                "/org/ptolomeu/gui/resources/Print24.gif"));
        bPrint.setText(null);
        miPrint.setAction(new ShowNotYetImplementedMessage("Print",
                "/org/ptolomeu/gui/resources/Print16.gif",
                "/org/ptolomeu/gui/resources/Print24.gif"));
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        miOpen = new javax.swing.JMenuItem();
        miImport = new javax.swing.JMenuItem();
        miExport = new javax.swing.JMenuItem();
        miSeparator1 = new javax.swing.JSeparator();
        miSave = new javax.swing.JMenuItem();
        miPrint = new javax.swing.JMenuItem();
        miSeparator2 = new javax.swing.JSeparator();
        miExit = new javax.swing.JMenuItem();
        mSheet = new javax.swing.JMenu();
        miEditColumnName = new javax.swing.JMenuItem();
        mModeling = new javax.swing.JMenu();
        mrbLinearRegression = new javax.swing.JRadioButtonMenuItem();
        mrbNonLinearRegression = new javax.swing.JRadioButtonMenuItem();
        mHelp = new javax.swing.JMenu();
        mhTipOfTheDay = new javax.swing.JMenuItem();
        mhSeparator1 = new javax.swing.JSeparator();
        mhAbout = new javax.swing.JMenuItem();
        toolBar = new javax.swing.JToolBar();
        bOpenFile = new javax.swing.JButton();
        bImport = new javax.swing.JButton();
        bExport = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bPrint = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bRun = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        bShowTip = new javax.swing.JButton();
        bShowAbout = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        spreadsheet = new SpreadsheetView(applicationModel.getSpreadsheetModel());
        chartView = new ChartView(applicationModel.getChartModel());
        reportView = new ReportView(applicationModel.getReportModel());
        buttonGroup = new javax.swing.ButtonGroup();
        statusBar = new JXStatusBar();

        mFile.setText("File"); // NOI18N

        miOpen.setAction(new ShowNotYetImplementedMessage("Open File",
                "/org/ptolomeu/gui/resources/Open16.gif", "/org/ptolomeu/gui/resources/Open24.gif"));
        mFile.add(miOpen);

        miImport.setAction(new ShowNotYetImplementedMessage("Import File",
                "/org/ptolomeu/gui/resources/Import16.gif",
                "/org/ptolomeu/gui/resources/Import24.gif"));
        mFile.add(miImport);

        miExport.setAction(new ShowNotYetImplementedMessage("Export File",
                "/org/ptolomeu/gui/resources/Export16.gif",
                "/org/ptolomeu/gui/resources/Export24.gif"));
        mFile.add(miExport);
        mFile.add(miSeparator1);

        miSave.setAction(new ShowNotYetImplementedMessage("Save",
                "/org/ptolomeu/gui/resources/Save16.gif", "/org/ptolomeu/gui/resources/Save24.gif"));
        mFile.add(miSave);
        mFile.add(miPrint);
        mFile.add(miSeparator2);

        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/org/ptolomeu/gui/resources/Exit16.gif"))); // NOI18N
        miExit.setText("Exit"); // NOI18N
        mFile.add(miExit);

        menuBar.add(mFile);

        mSheet.setText("Sheet"); // NOI18N
        mSheet.add(miEditColumnName);

        menuBar.add(mSheet);

        mModeling.setText("Modeling"); // NOI18N

        buttonGroup.add(mrbLinearRegression);
        mrbLinearRegression.setSelected(true);
        mrbLinearRegression.setText("Linear Regression"); // NOI18N
        mrbLinearRegression.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mrbLinearRegressionItemStateChanged(evt);
            }
        });
        mModeling.add(mrbLinearRegression);

        buttonGroup.add(mrbNonLinearRegression);
        mrbNonLinearRegression.setText("Non-Linear Regression"); // NOI18N
        mrbNonLinearRegression.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mrbNonLinearRegressionItemStateChanged(evt);
            }
        });
        mModeling.add(mrbNonLinearRegression);

        menuBar.add(mModeling);

        mHelp.setText("Help"); // NOI18N

        mhTipOfTheDay.setAction(new ShowTipOfTheDay());
        mHelp.add(mhTipOfTheDay);
        mHelp.add(mhSeparator1);

        mhAbout.setAction(new ShowAboutDialog());
        mHelp.add(mhAbout);

        menuBar.add(mHelp);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        bOpenFile
                .setAction(new ShowNotYetImplementedMessage("Open File",
                        "/org/ptolomeu/gui/resources/Open16.gif",
                        "/org/ptolomeu/gui/resources/Open24.gif"));
        bOpenFile.setText(null);
        bOpenFile.setFocusable(false);
        bOpenFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bOpenFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bOpenFile);

        bImport.setAction(new ShowNotYetImplementedMessage("Import File",
                "/org/ptolomeu/gui/resources/Import16.gif",
                "/org/ptolomeu/gui/resources/Import24.gif"));
        bImport.setText(null);
        bImport.setFocusable(false);
        bImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bImport);

        bExport.setAction(new ShowNotYetImplementedMessage("Export File",
                "/org/ptolomeu/gui/resources/Export16.gif",
                "/org/ptolomeu/gui/resources/Export24.gif"));
        bExport.setText(null);
        bExport.setFocusable(false);
        bExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bExport);

        bSave.setAction(new ShowNotYetImplementedMessage("Save",
                "/org/ptolomeu/gui/resources/Save16.gif", "/org/ptolomeu/gui/resources/Save24.gif"));
        bSave.setText(null);
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bSave);

        bPrint.setText(null);
        bPrint.setFocusable(false);
        bPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bPrint);
        toolBar.addSeparator();

        bEdit.setFocusable(false);
        bEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bEdit);
        toolBar.addSeparator();

        bRun.setFocusable(false);
        bRun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRun.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bRun);

        bClear.setFocusable(false);
        bClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bClear);
        toolBar.addSeparator();

        bShowTip.setAction(new ShowTipOfTheDay());
        bShowTip.setText(null);
        bShowTip.setFocusable(false);
        bShowTip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowTip.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bShowTip);

        bShowAbout.setAction(new ShowAboutDialog());
        bShowAbout.setText(null);
        bShowAbout.setFocusable(false);
        bShowAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bShowAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(bShowAbout);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout
                .setHorizontalGroup(mainPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 710, Short.MAX_VALUE)
                        .addGroup(
                                mainPanelLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                mainPanelLayout
                                                        .createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(
                                                                spreadsheet,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                303,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(
                                                                mainPanelLayout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(
                                                                                chartView,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                383,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                reportView,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                383,
                                                                                Short.MAX_VALUE))
                                                        .addContainerGap())));
        mainPanelLayout
                .setVerticalGroup(mainPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 528, Short.MAX_VALUE)
                        .addGroup(
                                mainPanelLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                mainPanelLayout
                                                        .createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(
                                                                mainPanelLayout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(
                                                                                spreadsheet,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                526,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                mainPanelLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(
                                                                                                chartView,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                401,
                                                                                                Short.MAX_VALUE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(
                                                                                                reportView,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                119,
                                                                                                Short.MAX_VALUE)))
                                                        .addGap(1, 1, 1))));

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusBar);
        setToolBar(toolBar);
    }// </editor-fold>//GEN-END:initComponents

    // Manual binding
    private void mrbNonLinearRegressionItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_mrbNonLinearRegressionItemStateChanged
        applicationModel.setSelectedRegressionType(RegressionType.NON_LINEAR);
    }// GEN-LAST:event_mrbNonLinearRegressionItemStateChanged

    // Manual binding
    private void mrbLinearRegressionItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_mrbLinearRegressionItemStateChanged
        applicationModel.setSelectedRegressionType(RegressionType.LINEAR);
    }// GEN-LAST:event_mrbLinearRegressionItemStateChanged

    /*
     * Utility method to retrieve Actions.
     * 
     * @see https://appframework.dev.java.net/intro/index.html
     */
    private javax.swing.Action getAction(Class actionsClass, Object actionsObject, String actionName) {
        return ModelMatApplication.getApplication().getContext()
                .getActionMap(actionsClass, actionsObject).get(actionName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClear;

    private javax.swing.JButton bEdit;

    private javax.swing.JButton bExport;

    private javax.swing.JButton bImport;

    private javax.swing.JButton bOpenFile;

    private javax.swing.JButton bPrint;

    private javax.swing.JButton bRun;

    private javax.swing.JButton bSave;

    private javax.swing.JButton bShowAbout;

    private javax.swing.JButton bShowTip;

    private javax.swing.ButtonGroup buttonGroup;

    private org.ptolomeu.gui.chart.ChartView chartView;

    private javax.swing.JMenu mFile;

    private javax.swing.JMenu mHelp;

    private javax.swing.JMenu mModeling;

    private javax.swing.JMenu mSheet;

    private javax.swing.JPanel mainPanel;

    private javax.swing.JMenuBar menuBar;

    private javax.swing.JMenuItem mhAbout;

    private javax.swing.JSeparator mhSeparator1;

    private javax.swing.JMenuItem mhTipOfTheDay;

    private javax.swing.JMenuItem miEditColumnName;

    private javax.swing.JMenuItem miExit;

    private javax.swing.JMenuItem miExport;

    private javax.swing.JMenuItem miImport;

    private javax.swing.JMenuItem miOpen;

    private javax.swing.JMenuItem miPrint;

    private javax.swing.JMenuItem miSave;

    private javax.swing.JSeparator miSeparator1;

    private javax.swing.JSeparator miSeparator2;

    private javax.swing.JRadioButtonMenuItem mrbLinearRegression;

    private javax.swing.JRadioButtonMenuItem mrbNonLinearRegression;

    private org.ptolomeu.gui.report.ReportView reportView;

    private org.ptolomeu.gui.table.SpreadsheetView spreadsheet;

    private JXStatusBar statusBar;

    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
