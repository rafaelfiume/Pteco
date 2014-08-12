package org.ptolomeu.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import org.jdesktop.application.Application;
import org.jdesktop.application.FrameView;
import org.jdesktop.swingx.JXStatusBar;
import org.ptolomeu.application.ModelMatApplication;
import org.ptolomeu.core.regression.Regression;
import org.ptolomeu.gui.actions.ShowAboutDialogAction;
import org.ptolomeu.gui.actions.ShowNotYetImplementedMessageAction;
import org.ptolomeu.gui.actions.ShowTipOfTheDayAction;
import org.ptolomeu.gui.chart.ChartView;
import org.ptolomeu.gui.report.ReportView;
import org.ptolomeu.gui.table.SpreadsheetView;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;

public class ModelMatView extends FrameView {

    private final ApplicationModel applicationModel = new ApplicationModel(Regression.Type.LINEAR);

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
    private final JMenuItem mhTipOfTheDay = new JMenuItem();
    private final JMenuItem miEditColumnName = new JMenuItem();
    private final JMenuItem miExit = new JMenuItem();
    private final JMenuItem miExport = new JMenuItem();
    private final JMenuItem miImport = new JMenuItem();
    private final JMenuItem miOpen = new JMenuItem();
    private final JMenuItem miPrint = new JMenuItem();
    private final JMenuItem miSave = new JMenuItem();

    private final JSeparator mhSeparator1 = new JSeparator();
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
    private final JLabel statusLabel = new JLabel();

    public ModelMatView(Application application) {
        super(application);
        initComponents();
        setUpLayout();
        assembleView();
    }

    private void initComponents() {
        setUpMenu();
        setUpToolbar();
        setUpStatusBar();
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

        bOpenFile.setAction(new ShowNotYetImplementedMessageAction("Open File", "/icons/Open16.gif", "/icons/Open24.gif"));
        bOpenFile.setText(null);
        bOpenFile.setFocusable(false);
        bOpenFile.setHorizontalTextPosition(CENTER);
        bOpenFile.setVerticalTextPosition(BOTTOM);

        bImport.setAction(new ShowNotYetImplementedMessageAction("Import File", "/icons/Import16.gif", "/icons/Import24.gif"));
        bImport.setText(null);
        bImport.setFocusable(false);
        bImport.setHorizontalTextPosition(CENTER);
        bImport.setVerticalTextPosition(BOTTOM);

        bExport.setAction(new ShowNotYetImplementedMessageAction("Export File", "/icons/Export16.gif", "/icons/Export24.gif"));
        bExport.setText(null);
        bExport.setFocusable(false);
        bExport.setHorizontalTextPosition(CENTER);
        bExport.setVerticalTextPosition(BOTTOM);

        bSave.setAction(new ShowNotYetImplementedMessageAction("Save", "/icons/Save16.gif", "/icons/Save24.gif"));
        bSave.setText(null);
        bSave.setFocusable(false);
        bSave.setHorizontalTextPosition(CENTER);
        bSave.setVerticalTextPosition(BOTTOM);

        bPrint.setText(null);
        bPrint.setFocusable(false);
        bPrint.setHorizontalTextPosition(CENTER);
        bPrint.setVerticalTextPosition(BOTTOM);
        bPrint.setAction(new ShowNotYetImplementedMessageAction("Print", "/icons/Print16.gif", "/icons/Print24.gif"));
        bPrint.setText(null);

        bEdit.setFocusable(false);
        bEdit.setHorizontalTextPosition(CENTER);
        bEdit.setVerticalTextPosition(BOTTOM);
        bEdit.setAction(getAction(SpreadsheetView.class, spreadsheet, "changeColumnName"));
        bEdit.setText(null);

        bRun.setFocusable(false);
        bRun.setHorizontalTextPosition(CENTER);
        bRun.setVerticalTextPosition(BOTTOM);
        bRun.setAction(getAction(ApplicationModel.class, applicationModel, "doRegression"));

        bClear.setFocusable(false);
        bClear.setHorizontalTextPosition(CENTER);
        bClear.setVerticalTextPosition(BOTTOM);
        bClear.setAction(getAction(ApplicationModel.class, applicationModel, "clear"));

        bShowTip.setAction(new ShowTipOfTheDayAction());
        bShowTip.setText(null);
        bShowTip.setFocusable(false);
        bShowTip.setHorizontalTextPosition(CENTER);
        bShowTip.setVerticalTextPosition(BOTTOM);

        bShowAbout.setAction(new ShowAboutDialogAction());
        bShowAbout.setText(null);
        bShowAbout.setFocusable(false);
        bShowAbout.setHorizontalTextPosition(CENTER);
        bShowAbout.setVerticalTextPosition(BOTTOM);

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
        statusLabel.setText("Pteco");
        JXStatusBar.Constraint c1 = new JXStatusBar.Constraint();
        c1.setFixedWidth(100);
        statusBar.add(statusLabel, c1);
    }

    private void initFileMenu() {
        miOpen.setAction(new ShowNotYetImplementedMessageAction("Open File", "/icons/Open16.gif", "/icons/Open24.gif"));
        miImport.setAction(new ShowNotYetImplementedMessageAction("Import File", "/icons/Import16.gif", "/icons/Import24.gif"));
        miExport.setAction(new ShowNotYetImplementedMessageAction("Export File", "/icons/Export16.gif", "/icons/Export24.gif"));
        miSave.setAction(new ShowNotYetImplementedMessageAction("Save", "/icons/Save16.gif", "/icons/Save24.gif"));

        miExit.setIcon(new ImageIcon(getClass().getResource("/icons/Exit16.gif")));
        miExit.setText("Exit");

        miPrint.setAction(new ShowNotYetImplementedMessageAction("Print", "/icons/Print16.gif", "/icons/Print24.gif"));

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
        mSheet.setText("Spreadsheet");
        miEditColumnName.setAction(getAction(SpreadsheetView.class, spreadsheet, "changeColumnName"));
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
        mhTipOfTheDay.setAction(new ShowTipOfTheDayAction());
        mhAbout.setAction(new ShowAboutDialogAction());

        mHelp.setText("Help");
        mHelp.add(mhTipOfTheDay);
        mHelp.add(mhSeparator1);
        mHelp.add(mhAbout);
        menuBar.add(mHelp);
    }

    private void mrbNonLinearRegressionItemStateChanged(ItemEvent evt) {
        applicationModel.setSelectedRegressionType(Regression.Type.NON_LINEAR);
    }

    private void mrbLinearRegressionItemStateChanged(ItemEvent evt) {
        applicationModel.setSelectedRegressionType(Regression.Type.LINEAR);
    }

    /*
     * Utility method to retrieve Actions.
     * 
     * @see https://appframework.dev.java.net/intro/index.html
     */
    private Action getAction(Class actionsClass, Object actionsObject, String actionName) {
        return ModelMatApplication.getApplication().getContext().getActionMap(actionsClass, actionsObject).get(actionName);
    }

}
