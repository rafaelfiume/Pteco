package org.ptolomeu.core.regression;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class NonLinearRegressionTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final NonLinearRegression regression = new NonLinearRegression();

    private Map<GridIndex, Double> coordinates = new TreeMap() {
        {
            put(new GridIndex(0, 0), -4.0); // <- x
            put(new GridIndex(0, 1), 6.0);  // <- y
            put(new GridIndex(3, 0), 4.0);  // <- x
            put(new GridIndex(3, 1), 10.0); // <- y
            put(new GridIndex(7, 0), -5.0); // <- x
            put(new GridIndex(7, 1), 8.0);  // <- y
        }
    };

    @Test
    public void doRegression() throws Exception {
        NonLinearRegressionResult result = regression.doRegression(coordinates);

        assertTrue(result.coefA() == 3.5555555555555554);
        assertTrue(result.coefB() == 0.5000000000000001);
        assertTrue(result.coefC() == 0.2777777777777778);
    }

    @Test
    public void insufficientData() throws InsufficientDataException, CoordinateNumberException {
        thrown.expect(InsufficientDataException.class);
        thrown.expectMessage("Minimum number of coordinates to calculate linear regression is 3");

        regression.doRegression(withNotEnoughCoordinates());
    }

    private Map<GridIndex, Double> withNotEnoughCoordinates() {
        return new TreeMap() {
            {
                put(new GridIndex(0, 0), -4.0); // <- x
                put(new GridIndex(0, 1), 6.0);  // <- y
            }
        };
    }

}