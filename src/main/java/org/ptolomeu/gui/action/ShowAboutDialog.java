/*
 * ShowAboutDialog.java
 *
 * Created on 14 de Fevereiro de 2007, 03:39
 */

package org.ptolomeu.gui.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import org.ptolomeu.gui.help.AboutDialog;

/**
 * 
 * @author Rafael Fiume
 */
public class ShowAboutDialog extends AbstractAction {

    private static final String NAME = "About...";

    private static final String SHORT_DESCRIPTION = "Show the about dialog";

    private static final String ACTION_COMMAND_KEY = "show_about_dialog";

    private static final String SMALL_ICON = "/icons/About16.gif";

    private static final String LARGE_ICON_KEY = "/icons/About24.gif";

    /**
     * Creates a new instance of ShowAboutDialog.
     */
    public ShowAboutDialog() {
        super();
        putValue(Action.NAME, NAME);
        putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        putValue(Action.ACTION_COMMAND_KEY, ACTION_COMMAND_KEY);

        putValue(Action.SMALL_ICON, new ImageIcon(ShowAboutDialog.class.getResource(SMALL_ICON)));

        putValue(Action.LARGE_ICON_KEY,
                new ImageIcon(ShowAboutDialog.class.getResource(LARGE_ICON_KEY)));
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        AboutDialog.showDialog();
    }
}
