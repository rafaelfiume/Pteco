/*
 * InsufficientDataException.java
 *
 * Created on 20 de Dezembro de 2006, 05:11
 */
package org.ptolomeu.core.regression.exception;

/**
 * Thrown when there is insufficient data for mathematical modeling.
 */
public class InsufficientDataException extends RuntimeException {

    public InsufficientDataException(String msg) {
        super(msg);
    }

}
