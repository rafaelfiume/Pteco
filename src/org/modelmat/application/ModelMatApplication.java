/*
 * ModelMatApplication.java
 * 
 * Created on 16/07/2007, 10:24:54
 */

package org.modelmat.application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.modelmat.gui.ModelMatView;
import org.modelmat.gui.help.TipOfTheDay;

/**
 * 
 * @author Rafael Fiume
 */
public class ModelMatApplication extends SingleFrameApplication {

    private ModelMatView view;

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

    public static Application getApplication() {
        return Application.getInstance(ModelMatApplication.class);
    }

    public static void main(String[] args) {
        Application.launch(ModelMatApplication.class, args);
    }

    private class FrameHandler extends WindowAdapter {

        @Override
        public void windowClosing(final WindowEvent e) {
            exit(e);
        }
    }
}
