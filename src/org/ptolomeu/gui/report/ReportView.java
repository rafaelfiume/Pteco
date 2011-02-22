package org.ptolomeu.gui.report;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * 
 * @author Rafael Fiume
 */
public final class ReportView extends JPanel {

    private JScrollPane scReport = new JScrollPane();

    private JTextPane tpReport = new JTextPane();;

    /**
     * Creates a new ReportView with the specified ReportModel.
     */
    public ReportView(ReportModel model) {
        initComponents(model);
        setUpLayout();
    }

    private void initComponents(ReportModel model) {
        tpReport.setEditable(false);
        tpReport.setDocument(model.getDocument());
        scReport.setViewportView(tpReport);
    }

    private void setUpLayout() {
        this.setLayout(new FormLayout("pref:grow", "fill:pref:grow"));
        add(scReport, new CellConstraints().xy(1, 1));
    }

}
