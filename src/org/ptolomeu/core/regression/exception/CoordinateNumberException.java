/*
 * CoordinatedNumException.java
 *
 * Created on 20 de Dezembro de 2006, 04:23
 */

package org.ptolomeu.core.regression.exception;

/**
 * Thrown when the data for mathematical modeling is incomplete.
 * 
 * @author Rafael Fiume
 */
public class CoordinateNumberException extends java.lang.Exception {

    /**
     * Creates a new instance of <code>CoordinatedNumException</code> without detail message.
     */
    public CoordinateNumberException() {
    }

    /**
     * Constructs an instance of <code>CoordinatedNumException</code> with the specified detail
     * message.
     * 
     * @param msg
     *            the detail message.
     */
    public CoordinateNumberException(String msg) {
        super(msg);
    }
}
