/*
 * MainViewModel.java
 * 
 * Created on 15/07/2007, 06:21:13
 */

package org.ptolomeu.gui;

import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.ptolomeu.application.ModelMatApplication;
import org.ptolomeu.core.regression.AbstractRegressionResult;
import org.ptolomeu.core.regression.RegressionFactory;
import org.ptolomeu.core.regression.AbstractRegression.RegressionType;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;
import org.ptolomeu.gui.chart.ChartModel;
import org.ptolomeu.gui.report.ReportModel;
import org.ptolomeu.gui.table.SpreadsheetModel;

/**
 * The Presentation Model of ModelMatView. Software's action's is here.
 * 
 * @author Rafael Fiume
 */
public class ApplicationModel {

    // TODO: Can I make the models of views final ?

    private SpreadsheetModel spreadsheetModel = new SpreadsheetModel();

    private ReportModel reportModel = new ReportModel();

    private ChartModel chartModel = new ChartModel();

    /**
     * The selected operation by the user in the main menu.
     */
    private volatile RegressionType selectedRegressionType;

    public ApplicationModel(RegressionType regressionType) {
        selectedRegressionType = regressionType;
    }

    @Action(block = Task.BlockingScope.ACTION)
    public Task doRegression() {
        return new DoRegression();
    }

    @Action
    public void clear() {
        spreadsheetModel.clear();
        reportModel.clear();
        chartModel.clear();
    }

    /**
     * Returns the the Spreedsheet model.
     */
    public SpreadsheetModel getSpreadsheetModel() {
        return spreadsheetModel;
    }

    /**
     * Returns the the ReportView's model.
     */
    public ReportModel getReportModel() {
        return reportModel;
    }

    /**
     * Returns the the ReportView's model.
     */
    public ChartModel getChartModel() {
        return chartModel;
    }

    /**
     * Sets the the linear gression type (currently, linear or non-linear).
     */
    public void setSelectedRegressionType(RegressionType selectedRegressionType) {
        this.selectedRegressionType = selectedRegressionType;
    }

    /**
     * Computes linear ou non-linear regression, depending on the selectedRegressionType property,
     * in the background.
     */
    private class DoRegression extends Task<AbstractRegressionResult, Void> {

        DoRegression() {
            super(ModelMatApplication.getApplication());
        }

        protected AbstractRegressionResult doInBackground() throws CoordinateNumberException,
                InsufficientDataException {
            return RegressionFactory.getRegressionFactory().getRegression(selectedRegressionType)
                    .doRegression(spreadsheetModel.getCoordValues());
        }

        @Override
        protected void succeeded(AbstractRegressionResult result) {
            reportModel.reportResult(result);
            chartModel.reportResult(result);
            setMessage("Regression succeeded.");
        }

        @Override
        protected void failed(Throwable cause) {
            setMessage("Regression failed.");
            ExceptionNotifier.notifyError(cause);
        }
    }

}
