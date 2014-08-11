package org.ptolomeu.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

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

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class ModelMatView extends FrameView {

    private final ApplicationModel applicationModel = new ApplicationModel(RegressionType.LINEAR);

    private final JButton bClear = new JButton();
    private final JButton bEdit = new JButton();
    private final JButton bExport = new JButton();
    private final JButton bImport = new JButton();
    private final JButton bOpenFile = new JButton();
    private final JButton bPrint = new JButton();
    private final JButton bRun = new JButton();
    private final JButton bSave = new JButton();
    private final JButton bShowAbout = new JButton();
    private final JButton bShowTip = new JButton();

    private final ButtonGroup buttonGroup = new ButtonGroup();

    private final JMenu mFile = new JMenu();
    private final JMenu mHelp = new JMenu();
    private final JMenu mModeling = new JMenu();
    private final JMenu mSheet = new JMenu();

    private final JMenuItem mhAbout = new JMenuItem();
    private final JSeparator mhSeparator1 = new JSeparator();
    private final JMenuItem mhTipOfTheDay = new JMenuItem();
    private final JMenuItem miEditColumnName = new JMenuItem();
    private final JMenuItem miExit = new JMenuItem();
    private final JMenuItem miExport = new JMenuItem();
    private final JMenuItem miImport = new JMenuItem();
    private final JMenuItem miOpen = new JMenuItem();
    private final JMenuItem miPrint = new JMenuItem();
    private final JMenuItem miSave = new JMenuItem();

    private final JSeparator miSeparator1 = new JSeparator();
    private final JSeparator miSeparator2 = new JSeparator();

    private final JRadioButtonMenuItem mrbLinearRegression = new JRadioButtonMenuItem();
    private final JRadioButtonMenuItem mrbNonLinearRegression = new JRadioButtonMenuItem();

    private final JMenuBar menuBar = new JMenuBar();

    private final JToolBar toolBar = new JToolBar();

    private final JPanel mainPanel = new JPanel();

    private final ReportView reportView = new ReportView(applicationModel.getReportModel());

    private final SpreadsheetView spreadsheet = new SpreadsheetView(applicationModel.getSpreadsheetModel());

    private final ChartView chartView = new ChartView(applicationModel.getChartModel());

    private final JXStatusBar statusBar = new JXStatusBar();

    public ModelMatView(Application application) {
        super(application);
        initComponents();
    }

    private void initComponents() {
        setUpMenu();
        setUpToolbar();
        setUpStatusBar();
        setUpLayout();
        assembleView();
    }

    private void setUpLayout() {
        mainPanel.setLayout(new FormLayout(
                "4dlu, max(150dlu;min):, 4dlu, max(200dlu;default):grow, 4dlu",
                "2dlu, fill:default:grow, 2dlu, fill:80dlu:grow"));

        final CellConstraints cc = new CellConstraints();
        mainPanel.add(spreadsheet, cc.xywh(2, 2, 1, 3));
        mainPanel.add(chartView, cc.xy(4, 2));
        mainPanel.add(reportView, cc.xy(4, 4));
    }

    private void assembleView() {
        setMenuBar(menuBar);
        setToolBar(toolBar);
        setStatusBar(statusBar);
        setComponent(mainPanel);
    }

    private void setUpMenu() {
        initFileMenu();
        initSheetMenu();
        initModelingMenu();
        initHelpMenu();
    }

    private void setUpToolbar() {
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        bOpenFile
                .setAction(new ShowNotYetImplementedMessage("Open File",
                        "/icons/Open16.gif",
                        "/icons/Open24.gif"));
        bOpenFile.setText(null);
        bOpenFile.setFocusable(false);
        bOpenFile.setHorizontalTextPosition(SwingConstants.CENTER);
        bOpenFile.setVerticalTextPosition(SwingConstants.BOTTOM);

        bImport.setAction(new ShowNotYetImplementedMessage("Import File",
                "/icons/Import16.gif",
                "/icons/Import24.gif"));
        bImport.setText(null);
        bImport.setFocusable(false);
        bImport.setHorizontalTextPosition(SwingConstants.CENTER);
        bImport.setVerticalTextPosition(SwingConstants.BOTTOM);

        bExport.setAction(new ShowNotYetImplementedMessage("Export File",
                "/icons/Export16.gif",
                "/icons/Export24.gif"));
        bExport.setText(null);
        bExport.setFocusable(false);
        bExport.setHorizontalTextPosition(SwingConstants.CENTER);
        bExport.setVerticalTextPosition(SwingConstants.BOTTOM);

        bSave.setAction(new ShowNotYetImplementedMessage("Save",
                "/icons/Save16.gif", "/icons/Save24.gif"));
        bSave.setText(null);
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(SwingConstants.CENTER);
        bSave.setVerticalTextPosition(SwingConstants.BOTTOM);

        bPrint.setText(null);
        bPrint.setFocusable(false);
        bPrint.setHorizontalTextPosition(SwingConstants.CENTER);
        bPrint.setVerticalTextPosition(SwingConstants.BOTTOM);
        bPrint.setAction(new ShowNotYetImplementedMessage("Print",
                "/icons/Print16.gif",
                "/icons/Print24.gif"));
        bPrint.setText(null);

        bEdit.setFocusable(false);
        bEdit.setHorizontalTextPosition(SwingConstants.CENTER);
        bEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
        bEdit.setAction(getAction(SpreadsheetView.class, spreadsheet, "changeColumnName"));

        bRun.setFocusable(false);
        bRun.setHorizontalTextPosition(SwingConstants.CENTER);
        bRun.setVerticalTextPosition(SwingConstants.BOTTOM);
        bRun.setAction(getAction(ApplicationModel.class, applicationModel, "doRegression"));

        bClear.setFocusable(false);
        bClear.setHorizontalTextPosition(SwingConstants.CENTER);
        bClear.setVerticalTextPosition(SwingConstants.BOTTOM);
        bClear.setAction(getAction(ApplicationModel.class, applicationModel, "clear"));

        bShowTip.setAction(new ShowTipOfTheDay());
        bShowTip.setText(null);
        bShowTip.setFocusable(false);
        bShowTip.setHorizontalTextPosition(SwingConstants.CENTER);
        bShowTip.setVerticalTextPosition(SwingConstants.BOTTOM);

        bShowAbout.setAction(new ShowAboutDialog());
        bShowAbout.setText(null);
        bShowAbout.setFocusable(false);
        bShowAbout.setHorizontalTextPosition(SwingConstants.CENTER);
        bShowAbout.setVerticalTextPosition(SwingConstants.BOTTOM);

        toolBar.add(bOpenFile);
        toolBar.add(bImport);
        toolBar.add(bExport);
        toolBar.add(bSave);
        toolBar.add(bPrint);
        toolBar.addSeparator();
        toolBar.add(bEdit);
        toolBar.addSeparator();
        toolBar.add(bRun);
        toolBar.add(bClear);
        toolBar.addSeparator();
        toolBar.add(bShowTip);
        toolBar.add(bShowAbout);
    }

    private void setUpStatusBar() {
//        statusBar.setText("Pteco");
    }

    private void initFileMenu() {
        miOpen.setAction(new ShowNotYetImplementedMessage("Open File",
                "/icons/Open16.gif", "/icons/Open24.gif"));

        miImport.setAction(new ShowNotYetImplementedMessage("Import File",
                "/icons/Import16.gif",
                "/icons/Import24.gif"));

        miExport.setAction(new ShowNotYetImplementedMessage("Export File",
                "/icons/Export16.gif",
                "/icons/Export24.gif"));

        miSave.setAction(new ShowNotYetImplementedMessage("Save",
                "/icons/Save16.gif", "/icons/Save24.gif"));

        miExit.setIcon(new ImageIcon(getClass().getResource(
                "/icons/Exit16.gif")));
        miExit.setText("Exit");

        miPrint.setAction(new ShowNotYetImplementedMessage("Print",
                "/icons/Print16.gif",
                "/icons/Print24.gif"));

        mFile.setText("File");
        mFile.add(miOpen);
        mFile.add(miImport);
        mFile.add(miExport);
        mFile.add(miSeparator1);
        mFile.add(miSave);
        mFile.add(miPrint);
        mFile.add(miSeparator2);
        mFile.add(miExit);
        menuBar.add(mFile);
    }

    private void initSheetMenu() {
        mSheet.setText("Sheet");
        mSheet.add(miEditColumnName);
        menuBar.add(mSheet);
    }

    private void initModelingMenu() {
        buttonGroup.add(mrbLinearRegression);
        mrbLinearRegression.setSelected(true);
        mrbLinearRegression.setText("Linear Regression");
        mrbLinearRegression.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent evt) {
                mrbLinearRegressionItemStateChanged(evt);
            }
        });

        buttonGroup.add(mrbNonLinearRegression);
        mrbNonLinearRegression.setText("Non-Linear Regression");
        mrbNonLinearRegression.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent evt) {
                mrbNonLinearRegressionItemStateChanged(evt);
            }
        });

        mModeling.setText("Modeling");
        mModeling.add(mrbLinearRegression);
        mModeling.add(mrbNonLinearRegression);
        menuBar.add(mModeling);
    }

    private void initHelpMenu() {
        mhTipOfTheDay.setAction(new ShowTipOfTheDay());
        mhAbout.setAction(new ShowAboutDialog());

        mHelp.setText("Help");
        mHelp.add(mhTipOfTheDay);
        mHelp.add(mhSeparator1);
        mHelp.add(mhAbout);
        menuBar.add(mHelp);
    }

    private void mrbNonLinearRegressionItemStateChanged(ItemEvent evt) {
        applicationModel.setSelectedRegressionType(RegressionType.NON_LINEAR);
    }

    private void mrbLinearRegressionItemStateChanged(ItemEvent evt) {
        applicationModel.setSelectedRegressionType(RegressionType.LINEAR);
    }

    /*
     * Utility method to retrieve Actions.
     * 
     * @see https://appframework.dev.java.net/intro/index.html
     */
    private Action getAction(Class actionsClass, Object actionsObject, String actionName) {
        return ModelMatApplication.getApplication().getContext()
                .getActionMap(actionsClass, actionsObject).get(actionName);
    }

}
