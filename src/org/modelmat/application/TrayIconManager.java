/*
 * TrayIconManager.java
 *
 * Created on 20 de Fevereiro de 2007, 12:53
 */
package org.modelmat.application;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.modelmat.gui.help.AboutDialog;
import org.modelmat.gui.help.TipOfTheDay;

/**
 *
 * @author Rafael Fiume
 */
public class TrayIconManager {

    private static TrayIconManager trayIconManager;

    private static TrayIcon trayIcon;

    private static Image icon;

    private static SystemTray systemTray;

    private static TrayIconActionListener trayIconActionListener;

    private static PopupMenu popup;

    private static final MenuItem menuTip   = new MenuItem();

    private static final MenuItem menuAbout = new MenuItem();

    private static final MenuItem menuExit  = new MenuItem();

    private TrayIconManager() {
        super();
    }

    public static void setTrayIcon() {
        synchronized (TrayIconManager.class) {
            if (trayIconManager == null) {
                trayIconManager = new TrayIconManager();
            }
        }

        if (SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
            icon = Toolkit.getDefaultToolkit().getImage(
                    TrayIconManager.class.
                    getResource("/org/modelmat/gui/resources/md1.gif"));

            popup = new PopupMenu();
            trayIcon = new TrayIcon(
                    icon,
                    "Double-click to maximize/minimize the software",
                    popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(trayIconActionListener);

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
            } catch (AWTException ex) {
                ex.printStackTrace();
            }

        } else {
            // Silently ignore this...
            // Shold the software do something here?
        }
    }


    /*
     * Action Listener para o TrayIcon: maximiza ou minimiza o software.
     */
    private class TrayIconActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            trayIcon.displayMessage(
                    "Oh my!",
                    "You double-clicked the tray icon!",
                    TrayIcon.MessageType.INFO);
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

