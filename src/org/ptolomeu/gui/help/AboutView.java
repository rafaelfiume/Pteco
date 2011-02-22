package org.ptolomeu.gui.help;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jdesktop.swingx.JXHyperlink;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * Display basic informations about the software.
 * 
 * TODO: Substituir BareBonesBrowserLaunch pela Java Desktop API.
 * 
 * @author Rafael Fiume
 */
public final class AboutView extends javax.swing.JPanel {

    private final JXHyperlink developerHyperlink = new JXHyperlink(new LinkAction("My blog...",
            "http://rafaelfiume.wordpress.com/"));

    private final JXHyperlink productVersionHyperlink = new JXHyperlink(new LinkAction(
            "Pteco Project's Page", "https://github.com/rafaelfiume/Pteco/"));

    private final JLabel productLabel = new JLabel();

    private final JPanel detailPanel = new JPanel();

    private final JTabbedPane aboutTabbedPane = new JTabbedPane();

    public AboutView() {
        initComponents();
        newLayout();
    }

    private void initComponents() {
        productLabel.setFont(new java.awt.Font("Dialog", 1, 18));
        productLabel.setForeground(new java.awt.Color(0, 0, 204));
        productLabel.setText("Pteco - Information");

        developerHyperlink.setText("Rafael Fiume");
        developerHyperlink.setClickedColor(new java.awt.Color(153, 0, 153));
        developerHyperlink.setUnclickedColor(new java.awt.Color(0, 51, 255));

        productVersionHyperlink.setText("ModelMat 0.1");
        productVersionHyperlink.setClickedColor(new java.awt.Color(153, 0, 153));
        productVersionHyperlink.setUnclickedColor(new java.awt.Color(0, 51, 255));

        aboutTabbedPane.addTab("Details", detailPanel);
    }

    private void newLayout() {
        setLayout(new FormLayout("pref", "pref"));
        add(aboutTabbedPane, new CellConstraints().xy(1, 1));

        detailPanel.setLayout(new FormLayout("10dlu, pref, 4dlu, pref, 20dlu",
                "2dlu, center:40dlu, 15dlu, 15dlu, 20dlu:grow"));

        final CellConstraints cc = new CellConstraints();
        detailPanel.add(productLabel, cc.xyw(2, 2, 3));
        detailPanel.add(new JLabel("Developer:"), cc.xy(2, 3));
        detailPanel.add(developerHyperlink, cc.xy(4, 3));
        detailPanel.add(new JLabel("Product Version:"), cc.xy(2, 4));
        detailPanel.add(productVersionHyperlink, cc.xy(4, 4));
    }

}

/**
 * @see http://www.samspublishing.com/articles/article.asp?p=598024&seqNum=3&rl=1
 */
class LinkAction extends AbstractAction {

    LinkAction(String linkText, String link) {
        putValue(Action.NAME, linkText);
        putValue(Action.SHORT_DESCRIPTION, link);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = (String) getValue(Action.SHORT_DESCRIPTION);
        // TODO: Substituir BareBones pela Java Desktop API
        BareBonesBrowserLaunch.openURL(link);
    }
}
