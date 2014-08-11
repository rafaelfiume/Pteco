package org.ptolomeu.gui.help;

import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

/**
 * 
 * @author Rafael Fiume
 */
public final class AboutDialog extends JDialog {

    private static AboutDialog about;

    private final AboutView aboutView = new AboutView();

    private AboutDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** Mostra About dialog. */
    public static void showDialog() {
        if (about == null) {
            about = new AboutDialog(null, true);
        }
        about.setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setAlwaysOnTop(true);
        setResizable(false);

        oldLayout();
    }

    private void oldLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(aboutView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(aboutView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE));

        pack();
    }

}
