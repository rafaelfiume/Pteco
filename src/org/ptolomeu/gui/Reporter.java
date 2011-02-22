/*
 * Reporter.java
 *
 * Created on 20 de Dezembro de 2006, 23:34
 */

package org.ptolomeu.gui;

import org.ptolomeu.core.regression.LinearRegressionResult;
import org.ptolomeu.core.regression.NonLinearRegressionResult;

/**
 * Gui components that reports mathematical modeling, like ReportView and ChartView, must implement
 * this interface
 * 
 * @author Rafael Fiume
 */
public interface Reporter {

    void reportResult(LinearRegressionResult result);

    void reportResult(NonLinearRegressionResult result);
}
