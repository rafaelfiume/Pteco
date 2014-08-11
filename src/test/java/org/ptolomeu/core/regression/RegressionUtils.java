package org.ptolomeu.core.regression;

import org.junit.Test;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class RegressionUtils {

    // Testing only utility methods (they will be extracted to its own class).
    private final AbstractRegression underTest = new LinearRegression();

    // TODO Try this with other implementation that TreeMap. It will fail. Consider changing API to expect TreeMap...
    private Map<XyIndex, Double> coordinates = new TreeMap() {
        {
            // TODO Consider replacing Point by XyIndex here, since their behaviour are exactly the same
            put(new XyIndex(0, 0), -4.0); // <- x
            put(new XyIndex(0, 1), 6.0);  // <- y
            put(new XyIndex(3, 0), 4.0);  // <- x
            put(new XyIndex(5, 0), 10.0); // <- x
            put(new XyIndex(7, 1), -5.0); // <- y
            put(new XyIndex(10, 0), 8.0); // <- x
        }
    };

    @Test
    public void sumX() throws Exception {
        assertTrue(underTest.sumX(coordinates) == 18);
    }

    @Test
    public void sumY() throws Exception {
        assertTrue(underTest.sumY(coordinates) == 1);
    }

}