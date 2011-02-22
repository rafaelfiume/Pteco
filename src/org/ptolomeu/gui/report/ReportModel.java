/*
 * ReportModel.java
 * 
 * Created on 14/07/2007, 23:00:43
 */

package org.ptolomeu.gui.report;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.ptolomeu.core.regression.AbstractRegressionResult;
import org.ptolomeu.core.regression.LinearRegressionResult;
import org.ptolomeu.core.regression.NonLinearRegressionResult;
import org.ptolomeu.gui.Reporter;

/**
 * 
 * @author Rafael Fiume
 */
public class ReportModel implements Reporter {

    /**
     * The model for the JTextPane in the view.
     */
    private AbstractDocument doc;

    /**
     * Contain formatation style of string output in VReport.
     */
    private SimpleAttributeSet[] atributes;

    /**
     * Format the numbers of string output in VReport.
     */
    private Format format;

    public ReportModel() {
        initOutput();
    }

    public Document getDocument() {
        return doc;
    }

    /**
     * Display the result of the mathematical modeling in the gui.
     */
    public void reportResult(final AbstractRegressionResult result) {
        /*
         * Implementation note: there must be a way to make this better, but for now this is just
         * fine.
         */

        if (result instanceof LinearRegressionResult) {
            reportResult((LinearRegressionResult) result);

        } else if (result instanceof NonLinearRegressionResult) {
            reportResult((NonLinearRegressionResult) result);
        }
    }

    /**
     * Display the result of the mathematical modeling in the gui. The output is like f(x) = a + bx,
     * plus correlation and determination coefficients.
     * 
     * If param result is null, #reportResult do nothing.
     */
    @Override
    public void reportResult(final LinearRegressionResult result) {
        if (result == null) {
            return;
        }

        clear();

        try {
            String[] resultCoefficients = new String[2];
            resultCoefficients[0] = format.format(result.coefA);
            resultCoefficients[1] = format.format(result.coefB);

            final String correlation = format.format(result.coefDeCorrelacao);
            final String determination = format.format(result.coefDeDeterminacao * 100);

            /****************** LINEAR FUNCTION: f(x) = a + bx ****************/
            final String linearRegression = "Linear Regression:";
            final String f_openParenthesis = "\nf(";
            final String closeParenthesis = ") = ";
            final String varX = "x";

            doc.insertString(doc.getLength(), linearRegression, atributes[0]);
            doc.insertString(doc.getLength(), f_openParenthesis,
                    result.coefDeDeterminacao >= 0.80 ? atributes[1] : atributes[4]);

            doc.insertString(doc.getLength(), varX, atributes[2]);
            doc.insertString(doc.getLength(), closeParenthesis,
                    result.coefDeDeterminacao >= 0.80 ? atributes[1] : atributes[4]);

            doc.insertString(doc.getLength(), resultCoefficients[0], atributes[3]);
            doc.insertString(doc.getLength(), resultCoefficients[1], atributes[3]);
            doc.insertString(doc.getLength(), varX, atributes[2]);

            /********************** LINEAR COEFFICIENT: **********************/

            final String coefCorrel = "\nCorrelation Coefficient: ";
            final String coefDeterm = "\nDetermination Coefficient: ";
            final String porcentagem = " % ";

            doc.insertString(doc.getLength(), coefCorrel,
                    result.coefDeDeterminacao >= 0.80 ? atributes[1] : atributes[4]);

            doc.insertString(doc.getLength(), correlation, atributes[3]);
            doc.insertString(doc.getLength(), coefDeterm,
                    result.coefDeDeterminacao >= 0.80 ? atributes[1] : atributes[4]);

            doc.insertString(doc.getLength(), determination, atributes[3]);
            doc.insertString(doc.getLength(), porcentagem, atributes[5]);

            final String SEPARATOR = "\n\n";

            doc.insertString(doc.getLength(), SEPARATOR, atributes[0]);

        } catch (BadLocationException ble) {
            JOptionPane.showMessageDialog(null, "Error", ble.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Display the result of the mathematical modeling in the gui. The output is like f(x) = a + bx
     * + cx2, plus correlation and determination coefficients.
     * 
     * If param result is null, #reportResult do nothing.
     */
    @Override
    public void reportResult(final NonLinearRegressionResult result) {
        if (result == null) {
            return;
        }

        clear();

        try {
            String[] resultCoefficients = new String[3];
            resultCoefficients[0] = format.format(result.coefA);
            resultCoefficients[1] = format.format(result.coefB);
            resultCoefficients[2] = format.format(result.coefC);

            /************ Non-Linear Function: f(x) = a + bx + cx2 ************/

            final String nonLinearRegression = "Non-Linear Function:";
            final String f_openParenthesis = "\nf(";
            final String closeParenthesis = ") = ";
            final String varX = "x";
            final String square = "2";

            doc.insertString(doc.getLength(), nonLinearRegression, atributes[0]);
            doc.insertString(doc.getLength(), f_openParenthesis, atributes[5]);
            doc.insertString(doc.getLength(), varX, atributes[2]);
            doc.insertString(doc.getLength(), closeParenthesis, atributes[5]);
            doc.insertString(doc.getLength(), resultCoefficients[0], atributes[3]);
            doc.insertString(doc.getLength(), resultCoefficients[1], atributes[3]);
            doc.insertString(doc.getLength(), varX, atributes[2]);
            doc.insertString(doc.getLength(), resultCoefficients[2], atributes[3]);
            doc.insertString(doc.getLength(), varX, atributes[2]);
            doc.insertString(doc.getLength(), square, atributes[5]);
            final String SEPARATOR = "\n\n";

            doc.insertString(doc.getLength(), SEPARATOR, atributes[0]);

        } catch (BadLocationException ble) {
            JOptionPane.showMessageDialog(null, "Error", ble.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clear the VReport component.
     */
    public void clear() {
        try {
            doc.remove(0, doc.getLength());

        } catch (BadLocationException ble) {
            JOptionPane.showMessageDialog(null, "Error", ble.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initOutput() {
        doc = new DefaultStyledDocument();
        atributes = initAttributes();
        format = initFormat();
    }

    private SimpleAttributeSet[] initAttributes() {
        SimpleAttributeSet[] attrs = new SimpleAttributeSet[6];

        attrs[0] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[0], 16);

        attrs[1] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[1], 14);
        StyleConstants.setForeground(attrs[1], new Color(0, 102, 51));

        attrs[2] = new SimpleAttributeSet();
        StyleConstants.setBold(attrs[2], true);
        StyleConstants.setFontSize(attrs[2], 14);

        attrs[3] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[3], 14);
        StyleConstants.setForeground(attrs[3], Color.blue);

        attrs[4] = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs[4], 14);
        StyleConstants.setForeground(attrs[4], Color.red);

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
