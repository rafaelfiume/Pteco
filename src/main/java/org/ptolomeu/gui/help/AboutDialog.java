package org.ptolomeu.gui.help;

import java.awt.event.ActionEvent;

import javax.swing.*;

import org.jdesktop.swingx.JXHyperlink;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public final class AboutDialog extends JDialog {

    private static final AboutDialog INSTANCE = new AboutDialog();

    private final JXHyperlink developerHyperlink = new JXHyperlink(new LinkAction("My blog...", "http://rafaelfiume.wordpress.com/2007/05/20/modelmat/"));
    private final JXHyperlink productVersionHyperlink = new JXHyperlink(new LinkAction("Pteco Project's Page", "https://github.com/rafaelfiume/Pteco/"));

    private final JLabel productLabel = new JLabel();

    private final JPanel detailPanel = new JPanel();

    private final JTabbedPane aboutTabbedPane = new JTabbedPane();

    private AboutDialog() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("About");
        setAlwaysOnTop(true);
        setResizable(false);

        initComponents();
        setUpLayout();
    }

    public static void showDialog() {
        INSTANCE.setVisible(true);
    }

    private void initComponents() {
        productLabel.setFont(new java.awt.Font("Dialog", 1, 18));
        productLabel.setForeground(new java.awt.Color(0, 0, 204));
        productLabel.setText("Pteco - Information");

        developerHyperlink.setText("Rafael Fiume");
        developerHyperlink.setClickedColor(new java.awt.Color(153, 0, 153));
        developerHyperlink.setUnclickedColor(new java.awt.Color(0, 51, 255));

        productVersionHyperlink.setText("Pteco 0.4"); // Get this info from elsewhere
        productVersionHyperlink.setClickedColor(new java.awt.Color(153, 0, 153));
        productVersionHyperlink.setUnclickedColor(new java.awt.Color(0, 51, 255));

        aboutTabbedPane.addTab("Details", detailPanel);
    }

    private void setUpLayout() {
        setLayout(new FormLayout("pref", "pref"));
        add(aboutTabbedPane, new CellConstraints().xy(1, 1));

        detailPanel.setLayout(
                new FormLayout(
                        "10dlu, pref, 4dlu, pref, 20dlu",
                        "2dlu, center:40dlu, 15dlu, 15dlu, 20dlu:grow")
        );

        final CellConstraints cc = new CellConstraints();
        detailPanel.add(productLabel, cc.xyw(2, 2, 3));
        detailPanel.add(new JLabel("Developer:"), cc.xy(2, 3));
        detailPanel.add(developerHyperlink, cc.xy(4, 3));
        detailPanel.add(new JLabel("Product Version:"), cc.xy(2, 4));
        detailPanel.add(productVersionHyperlink, cc.xy(4, 4));

        pack();
    }

    private static class LinkAction extends AbstractAction {

        LinkAction(String linkText, String link) {
            putValue(Action.NAME, linkText);
            putValue(Action.SHORT_DESCRIPTION, link);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String link = (String) getValue(Action.SHORT_DESCRIPTION);
            BareBonesBrowserLaunch.openURL(link);
        }
    }

}
