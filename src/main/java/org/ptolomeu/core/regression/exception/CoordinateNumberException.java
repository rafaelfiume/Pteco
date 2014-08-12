/*
 * CoordinatedNumException.java
 *
 * Created on 20 de Dezembro de 2006, 04:23
 */
package org.ptolomeu.core.regression.exception;

/**
 * Thrown when the data for mathematical modeling is incomplete.
 */
public class CoordinateNumberException extends RuntimeException {

    public CoordinateNumberException() {
    }

    public CoordinateNumberException(String message) {
        super(message);
    }

}
