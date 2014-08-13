package org.ptolomeu.core.regression;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RegressionUtilsTest {

    private List<Point> coordinates = new ArrayList() {
        {
            add(new Point(-4.0, 6.0));
            add(new Point(-5.0, 8.0));
            add(new Point(4.0, 10.0));
        }
    };

    @Test
    public void sumX() {
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