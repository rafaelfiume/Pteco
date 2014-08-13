package org.ptolomeu.core.regression;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class LinearRegressionTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final LinearRegression regresion = new LinearRegression();

    private List<Point> coordinates = new ArrayList() {
        {
            add(new Point(-4.0, 6.0));
            add(new Point(4.0, 10.0));
            add(new Point(-5.0, 8.0));
        }
    };

    @Test
    public void doRegression() {
        LinearRegressionResult result = regresion.doRegression(coordinates);

        assertTrue(result.coefA() == 8.547945205479452);
        assertTrue(result.coefB() == 0.3287671232876712);
        assertTrue(result.coefDeCorrelacao() == 0.810884854079383);
        assertTrue(result.coefDeDeterminacao() == 0.6575342465753423);
    }

    @Test
    public void insufficientData() {
        thrown.expect(InsufficientDataException.class);
        thrown.expectMessage("Minimum number of coordinates to calculate linear regression is 3");

        regresion.doRegression(withNotEnoughCoordinates());
    }

    private List<Point> withNotEnoughCoordinates() {
        return new ArrayList() {
            {
                add(new Point(-4.0, 6.0));
            }
        };
    }

}