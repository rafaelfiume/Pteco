package org.ptolomeu.gui.help;

import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.tips.TipLoader;
import org.jdesktop.swingx.tips.TipOfTheDayModel;

import static java.util.logging.Level.SEVERE;

public final class TipOfTheDay {

    private static final Logger LOG = Logger.getLogger(TipOfTheDay.class.getName());

    private static JXTipOfTheDay tipOfTheDay;

    private TipOfTheDay() {
        // Use one of the TipOfTheDay#show methods instead
    }

    public static void show(final Component parentComponent) {
        final Preferences userPreferences = Preferences.userRoot().node("ModelMat");
        getInstance().showDialog(parentComponent, userPreferences);
    }

    public static void show(final Component parentComponent, final boolean force) {
        final JXTipOfTheDay tip = getInstance();
        final Preferences userPreferences = Preferences.userRoot().node("ModelMat");

        if (force) {
            tip.forceShowOnStartup(userPreferences);
        }

        tip.showDialog(parentComponent, userPreferences, force);
    }

    private synchronized static JXTipOfTheDay getInstance() {
        if (tipOfTheDay == null) {
            final Properties prop = new Properties();
            final InputStream input = TipOfTheDay.class.getResourceAsStream("/tip.properties");
            try {
                prop.load(input);

            } catch (IOException e) {
                LOG.log(SEVERE, "Error when creating Tip of The Day", e);
                return null;
            }

            final TipOfTheDayModel model = TipLoader.load(prop);
            tipOfTheDay = new JXTipOfTheDay(model);
        }

        return tipOfTheDay;
    }
}
