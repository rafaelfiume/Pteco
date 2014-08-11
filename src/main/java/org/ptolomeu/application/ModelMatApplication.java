/*
 * ModelMatApplication.java
 * 
 * Created on 16/07/2007, 10:24:54
 */
package org.ptolomeu.application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.ptolomeu.gui.ModelMatView;
import org.ptolomeu.gui.help.TipOfTheDay;

public class ModelMatApplication extends SingleFrameApplication {

    private ModelMatView view;

    public static Application getApplication() {
        return Application.getInstance(ModelMatApplication.class);
    }

    public static void main(String[] args) {
        Application.launch(ModelMatApplication.class, args);
    }

    @Override
    protected void startup() {
        view = new ModelMatView(this);
        view.getFrame().addWindowListener(new FrameHandler());
        show(view);
    }

    @Override
    protected void ready() {
        TrayIconManager.setTrayIcon();
        TipOfTheDay.show(view.getFrame());
    }

    private class FrameHandler extends WindowAdapter {

        @Override
        public void windowClosing(final WindowEvent e) {
            exit(e);
        }
    }
}
