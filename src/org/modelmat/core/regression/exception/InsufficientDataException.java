/*
 * InsufficientDataException.java
 *
 * Created on 20 de Dezembro de 2006, 05:11
 */

package org.modelmat.core.regression.exception;

/**
 * Thrown when there is insufficient data for mathematical modeling.
 *
 * @author Rafael Fiume
 */
public class InsufficientDataException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>InsufficientDataException</code> 
     * without detail message.
     */
    public InsufficientDataException() {
    }
    
    
    /**
     * Constructs an instance of <code>InsufficientDataException</code> 
     * with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public InsufficientDataException(String msg) {
        super(msg);
    }
}
