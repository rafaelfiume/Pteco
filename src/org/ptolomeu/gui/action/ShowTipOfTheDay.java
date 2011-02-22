/*
 * ShowTipOfTheDay.java
 *
 * Created on 14 de Fevereiro de 2007, 03:51
 */

package org.ptolomeu.gui.action;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import org.ptolomeu.gui.help.TipOfTheDay;

/**
 * 
 * @author Rafael Fiume
 */
public class ShowTipOfTheDay extends AbstractAction {

    private static final String NAME = "Show Tip of the Day";

    private static final String SHORT_DESCRIPTION = "Show tip of the day";

    private static final String ACTION_COMMAND_KEY = "show_tip_of_the_day";

    private static final String SMALL_ICON = "/org/ptolomeu/gui/resources/TipOfTheDay16.gif";

    private static final String LARGE_ICON_KEY = "/org/ptolomeu/gui/resources/TipOfTheDay24.gif";

    /**
     * Creates a new instance of ShowTipOfTheDay.
     */
    public ShowTipOfTheDay() {
        super();
        putValue(Action.NAME, NAME);
        putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        putValue(Action.ACTION_COMMAND_KEY, ACTION_COMMAND_KEY);

        putValue(Action.SMALL_ICON, new ImageIcon(ShowTipOfTheDay.class.getResource(SMALL_ICON)));

        putValue(Action.LARGE_ICON_KEY,
                new ImageIcon(ShowTipOfTheDay.class.getResource(LARGE_ICON_KEY)));
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        TipOfTheDay.show(((Component) e.getSource()), true);
    }

}
