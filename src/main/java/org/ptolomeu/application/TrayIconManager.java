/*
 * TrayIconManager.java
 *
 * Created on 20 de Fevereiro de 2007, 12:53
 */
package org.ptolomeu.application;

import org.ptolomeu.gui.help.AboutDialog;
import org.ptolomeu.gui.help.TipOfTheDay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import static java.util.logging.Level.WARNING;

public class TrayIconManager {

    private static final Logger LOG = Logger.getLogger(TrayIconManager.class.getName());

    private static TrayIcon trayIcon;

    private static Image icon;

    private static SystemTray systemTray = SystemTray.getSystemTray();

    private static PopupMenu popup = new PopupMenu();

    private static final MenuItem menuTip = new MenuItem();
    private static final MenuItem menuAbout = new MenuItem();
    private static final MenuItem menuExit = new MenuItem();

    private TrayIconManager() {
        // Use TrayIconManager#setTrayIcon instead
    }

    public static void setTrayIcon() {
        if (!SystemTray.isSupported()) {
            LOG.info("Tray icon not supported");
            return;
        }

        icon = Toolkit.getDefaultToolkit().getImage(TrayIconManager.class.getResource("/icons/run.gif"));
        trayIcon = new TrayIcon(icon, "Pteco tray icon...", popup);
        trayIcon.setImageAutoSize(true);

        menuTip.setLabel("Tip of the Day");
        menuTip.addActionListener(new ShowTipOfTheDay());
        popup.add(menuTip);

        menuAbout.setLabel("About          ");
        menuAbout.addActionListener(new ShowAboutDialog());
        popup.add(menuAbout);

        popup.addSeparator();

        menuExit.setLabel("Exit");
        menuExit.addActionListener(new ExitApplication());
        popup.add(menuExit);

        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            LOG.log(WARNING, "Error when adding tray icon", e);
        }
    }

    private static class ShowTipOfTheDay implements ActionListener {

        public void actionPerformed(final ActionEvent e) {
            TipOfTheDay.show(null, true);
        }
    }

    private static class ShowAboutDialog implements ActionListener {

        public void actionPerformed(final ActionEvent e) {
            AboutDialog.showDialog();
        }
    }

    private static class ExitApplication implements ActionListener {

        public void actionPerformed(final ActionEvent e) {
            System.exit(0);
        }
    }

}
