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

public class NonLinearRegressionTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final NonLinearRegression regression = new NonLinearRegression();

    private List<Point> coordinates = new ArrayList() {
        {
            add(new Point(-4.0, 6.0));
            add(new Point(4.0, 10.0));
            add(new Point(-5.0, 8.0));
        }
    };

    @Test
    public void doRegression() {
        NonLinearRegressionResult result = regression.doRegression(coordinates);

        assertTrue(result.coefA() == 3.5555555555555554);
        assertTrue(result.coefB() == 0.5000000000000001);
        assertTrue(result.coefC() == 0.2777777777777778);
    }

    @Test
    public void insufficientData() {
        thrown.expect(InsufficientDataException.class);
        thrown.expectMessage("Minimum number of coordinates to calculate linear regression is 3");

        regression.doRegression(withNotEnoughCoordinates());
    }

    private List<Point> withNotEnoughCoordinates() {
        return new ArrayList() {
            {
                add(new Point(-4.0, 6.0));
            }
        };
    }

}