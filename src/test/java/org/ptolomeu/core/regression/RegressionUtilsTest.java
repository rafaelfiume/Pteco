package org.ptolomeu.core.regression;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class RegressionUtilsTest {

    // TODO Try this with other implementation that TreeMap. It will fail. Consider changing API to expect TreeMap...
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
    public void sumX() throws Exception {
        assertTrue(RegressionUtils.sumX(coordinates) == -5);
    }

    @Test
    public void sumY() throws Exception {
        assertTrue(RegressionUtils.sumY(coordinates) == 24);
    }

    @Test
    public void sumXY() throws Exception {
        assertTrue(RegressionUtils.sumXY(coordinates) == -24);
    }

    @Test
    public void sumX2() throws Exception {
        assertTrue(RegressionUtils.sumX2(coordinates) == 57);
    }

    @Test
    public void sumY2() throws Exception {
        assertTrue(RegressionUtils.sumY2(coordinates) == 200);
    }

    @Test
    public void sumX3() throws Exception {
        assertTrue(RegressionUtils.sumX3(coordinates) == -125);
    }

    @Test
    public void sumX4() throws Exception {
        assertTrue(RegressionUtils.sumX4(coordinates) == 1137);
    }

    @Test
    public void sumX2Y() throws Exception {
        assertTrue(RegressionUtils.sumX2Y(coordinates) == 456);
    }

}