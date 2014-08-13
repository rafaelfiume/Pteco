/*
 * Reporter.java
 *
 * Created on 20 de Dezembro de 2006, 23:34
 */
package org.ptolomeu.gui;

import org.ptolomeu.core.regression.AbstractRegressionResult;

public interface Reporter {

    /**
     * Display the result of the mathematical modeling in the gui.
     */
    void reportResult(AbstractRegressionResult result);

}
