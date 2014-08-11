/*
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
 * <a href="http://martinfowler.com/eaaDev/PresentationModel.html">Presentation Model</a> for ModelMatView.
 */
public class ApplicationModel {

    private final SpreadsheetModel spreadsheetModel = new SpreadsheetModel();

    private final ReportModel reportModel = new ReportModel();

    private final ChartModel chartModel = new ChartModel();

    /**
     * The regression selected by the user.
     */
    private RegressionType selectedRegressionType;

    public ApplicationModel(RegressionType regressionType) {
        this.selectedRegressionType = regressionType;
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

    public SpreadsheetModel getSpreadsheetModel() {
        return spreadsheetModel;
    }

    public ReportModel getReportModel() {
        return reportModel;
    }

    public ChartModel getChartModel() {
        return chartModel;
    }

    /**
     * Sets the the linear regression type (currently, linear or non-linear).
     */
    public void setSelectedRegressionType(RegressionType selectedRegressionType) {
        this.selectedRegressionType = selectedRegressionType;
    }

    /*
     * Computes in background linear or non-linear regression, depending on #selectedRegressionType.
     */
    private class DoRegression extends Task<AbstractRegressionResult, Void> {

        DoRegression() {
            super(ModelMatApplication.getApplication());
        }

        protected AbstractRegressionResult doInBackground() throws CoordinateNumberException, InsufficientDataException {
            return RegressionFactory.getInstance()
                    .getRegression(selectedRegressionType)
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
