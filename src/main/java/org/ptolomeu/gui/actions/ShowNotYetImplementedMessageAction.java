/*
 * ShowNotYetImplementedMessage.java
 *
 * Created on 14 de Fevereiro de 2007, 00:37
 */
package org.ptolomeu.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ShowNotYetImplementedMessageAction extends AbstractAction {

    private static final String SHORT_DESCRIPTION = "Not yet implemented";

    private static final String ACTION_COMMAND_KEY = "not_yet_implemented";

    public ShowNotYetImplementedMessageAction(String name, String smallIcon, String largeIcon) {
        putValue(Action.NAME, name);
        putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        putValue(Action.ACTION_COMMAND_KEY, ACTION_COMMAND_KEY);
        putValue(Action.SMALL_ICON, new ImageIcon(ShowNotYetImplementedMessageAction.class.getResource(smallIcon)));
        putValue(Action.LARGE_ICON_KEY, new ImageIcon(ShowNotYetImplementedMessageAction.class.getResource(largeIcon)));
    }

    public void actionPerformed(final ActionEvent e) {
        showNotYetImplementedMessage(e);
    }

    private void showNotYetImplementedMessage(final ActionEvent e) {
        JOptionPane.showMessageDialog(
                null,
                getValue(Action.NAME) + " is not yet implemented.",
                "Information!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
