/*
 * ExceptionNotifier.java
 * 
 * Created on 16/07/2007, 14:22:07
 */
package org.ptolomeu.gui;

import javax.swing.JOptionPane;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class must be the place to handle exceptions in a centralized way.
 * 
 * However, this class is in a very preliminar state. The whole concept and implementation of
 * centralized handling exceptions in this software must be improved.
 *
 * TODO: improve the messages sent to the user.
 */
public class ExceptionNotifier {

    private static final Logger LOG = Logger.getLogger(ExceptionNotifier.class.getName());

    private static final String COORDINATE_NUMBER_EXCEPTION_TITLE = "Missing Coordinate (x, y)";

    private static final String INSUFFICIENT_DATA_EXCEPTION_TITLE = "Insufficient Coordinate Number";
    private static final String INSUFFICIENT_DATA_EXCEPTION_MESSAGE = "Please, provide the necessary data.";

    private ExceptionNotifier() {
        // Use ExceptionNotifier#notifyError instead
    }

    public static void notifyError(Throwable cause) {
        if (cause instanceof InsufficientDataException) {
            notify((InsufficientDataException) cause);

        } else if (cause instanceof CoordinateNumberException) {
            notify((CoordinateNumberException) cause);
        }

        LOG.log(Level.INFO, "", cause);
    }

    private static void notify(CoordinateNumberException e) {
        JOptionPane.showMessageDialog(
                null, e.getMessage(), COORDINATE_NUMBER_EXCEPTION_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void notify(InsufficientDataException e) {
        JOptionPane.showMessageDialog(
                null, INSUFFICIENT_DATA_EXCEPTION_MESSAGE, INSUFFICIENT_DATA_EXCEPTION_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

}
