/*
 * ReportModel.java
 * 
 * Created on 14/07/2007, 23:00:43
 */
package org.ptolomeu.gui.report;

import org.ptolomeu.core.regression.AbstractRegressionResult;
import org.ptolomeu.core.regression.LinearRegressionResult;
import org.ptolomeu.core.regression.NonLinearRegressionResult;
import org.ptolomeu.gui.Reporter;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.Format;

public class ReportModel implements Reporter {

    private static final String VAR_X = "x";
    private static final String OPEN_PARENTHESIS = "\nf(";
    private static final String CLOSE_PARENTHESIS = ") = ";

    /**
     * The model for the JTextPane in the view.
     */
    private final AbstractDocument doc;

    private final SimpleAttributeSet[] atributes;

    private final Format format;

    public ReportModel() {
        this.doc = new DefaultStyledDocument();
        this.atributes = initAttributes();
        this.format = initFormat();
    }

    @Override
    public void reportResult(AbstractRegressionResult result) {
        clear();

        try {
            if (result instanceof LinearRegressionResult) {
                doReportResult((LinearRegressionResult) result);

            } else if (result instanceof NonLinearRegressionResult) {
                doReportResult((NonLinearRegressionResult) result);
            }

        } catch (BadLocationException e) {
            JOptionPane.showMessageDialog(null, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Display the result of the mathematical modeling in the gui. The output is like f(x) = a + bx,
     * plus correlation and determination coefficients.
     */
    private void doReportResult(LinearRegressionResult result) throws BadLocationException {
        /****************** LINEAR FUNCTION: f(x) = a + bx ****************/
        final String linearRegression = "Linear Regression:";
        final String a = format.format(result.coefA());
        final String b = format.format(result.coefB());

        doc.insertString(doc.getLength(), linearRegression, atributes[0]);
        doc.insertString(doc.getLength(), OPEN_PARENTHESIS, result.coefDeDeterminacao() >= 0.80 ? atributes[1] : atributes[4]);
        doc.insertString(doc.getLength(), VAR_X, atributes[2]);
        doc.insertString(doc.getLength(), CLOSE_PARENTHESIS, result.coefDeDeterminacao() >= 0.80 ? atributes[1] : atributes[4]);
        doc.insertString(doc.getLength(), a, atributes[3]);
        doc.insertString(doc.getLength(), b, atributes[3]);
        doc.insertString(doc.getLength(), VAR_X, atributes[2]);

        /********************** LINEAR COEFFICIENT: **********************/
        final String coefCorrel = "\nCorrelation Coefficient: ";
        final String coefDeterm = "\nDetermination Coefficient: ";
        final String porcentagem = " % ";
        final String correlation = format.format(result.coefDeCorrelacao());
        final String determination = format.format(result.coefDeDeterminacao() * 100);

        doc.insertString(doc.getLength(), coefCorrel, result.coefDeDeterminacao() >= 0.80 ? atributes[1] : atributes[4]);
        doc.insertString(doc.getLength(), correlation, atributes[3]);
        doc.insertString(doc.getLength(), coefDeterm, result.coefDeDeterminacao() >= 0.80 ? atributes[1] : atributes[4]);
        doc.insertString(doc.getLength(), determination, atributes[3]);
        doc.insertString(doc.getLength(), porcentagem, atributes[5]);
    }

    /*
     * Display the result of the mathematical modeling in the gui. The output is like f(x) = a + bx + cx2,
     * plus correlation and determination coefficients.
     */
    private void doReportResult(NonLinearRegressionResult result) throws BadLocationException {
        /************ Non-Linear Function: f(x) = a + bx + cx2 ************/
        final String nonLinearRegression = "Non-Linear Function:";
        final String a = format.format(result.coefA());
        final String b = format.format(result.coefB());
        final String c = format.format(result.coefC());

        final String square = "2";

        doc.insertString(doc.getLength(), nonLinearRegression, atributes[0]);
        doc.insertString(doc.getLength(), OPEN_PARENTHESIS, atributes[5]);
        doc.insertString(doc.getLength(), VAR_X, atributes[2]);
        doc.insertString(doc.getLength(), CLOSE_PARENTHESIS, atributes[5]);
        doc.insertString(doc.getLength(), a, atributes[3]);
        doc.insertString(doc.getLength(), b, atributes[3]);
        doc.insertString(doc.getLength(), VAR_X, atributes[2]);
        doc.insertString(doc.getLength(), c, atributes[3]);
        doc.insertString(doc.getLength(), VAR_X, atributes[2]);
        doc.insertString(doc.getLength(), square, atributes[5]);
    }

    public void clear() {
        try {
            doc.remove(0, doc.getLength());

        } catch (BadLocationException e) {
            JOptionPane.showMessageDialog(null, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    Document getDocument() {
        return doc;
    }

    /*
     * Formatting style for ReportView.
     */
    private SimpleAttributeSet[] initAttributes() {
        final SimpleAttributeSet[] attrs = new SimpleAttributeSet[6];

        // Title
        attrs[0] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[0], 16);

        // Great accuracy (green)
        attrs[1] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[1], 14);
        StyleConstants.setForeground(attrs[1], new Color(0, 102, 51));

        // var x (bold black)
        attrs[2] = new SimpleAttributeSet();
        StyleConstants.setBold(attrs[2], true);
        StyleConstants.setFontSize(attrs[2], 14);

        // constants (blue)
        attrs[3] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[3], 14);
        StyleConstants.setForeground(attrs[3], Color.blue);

        // Bad accuracy (green)
        attrs[4] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[4], 14);
        StyleConstants.setForeground(attrs[4], Color.red);

        // Unknown accuracy
        attrs[5] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[5], 14);

        return attrs;
    }

    private Format initFormat() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setNegativePrefix(" - ");
        decimalFormat.setPositivePrefix(" + ");
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat;
    }

}
