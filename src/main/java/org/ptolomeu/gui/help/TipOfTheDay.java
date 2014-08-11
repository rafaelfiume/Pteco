package org.ptolomeu.gui.help;

import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.prefs.Preferences;

import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.tips.TipLoader;
import org.jdesktop.swingx.tips.TipOfTheDayModel;

public final class TipOfTheDay {

    private static JXTipOfTheDay tipOfTheDay;

    private TipOfTheDay() {
        // Use one of the TipOfTheDay#show methods instead
    }

    public static void show(final Component parentComponent) {
        final Preferences userPreferences = Preferences.userRoot().node("ModelMat");
        create().showDialog(parentComponent, userPreferences);
    }

    public static void show(final Component parentComponent, final boolean force) {
        final JXTipOfTheDay tip = create();
        final Preferences userPreferences = Preferences.userRoot().node("ModelMat");

        if (force) {
            tip.forceShowOnStartup(userPreferences);
        }

        tip.showDialog(parentComponent, userPreferences, force);
    }

    private synchronized static JXTipOfTheDay create() {
        if (tipOfTheDay == null) {

            final Properties prop = new Properties();
            final InputStream input = TipOfTheDay.class
                    .getResourceAsStream("/tip.properties");
            try {
                prop.load(input);

            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }

            final TipOfTheDayModel model = TipLoader.load(prop);
            tipOfTheDay = new JXTipOfTheDay(model);

            return tipOfTheDay;
        }

        return tipOfTheDay;
    }
}
