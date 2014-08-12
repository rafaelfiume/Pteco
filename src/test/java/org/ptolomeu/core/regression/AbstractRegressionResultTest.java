package org.ptolomeu.core.regression;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AbstractRegressionResultTest {

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

    private AbstractRegressionResult underTest = new LinearRegressionResult(0, 0, 0, 0, coordinates);

    @Test
    public void getCartesianCoordinates() throws Exception {
        List<Point> cartesianCoordinates = underTest.getCartesianCoordinates();

        assertThat(cartesianCoordinates.size(), is(equalTo(3)));
        assertThat(cartesianCoordinates, hasItem(new Point(-4.0, 6.0)));
        assertThat(cartesianCoordinates, hasItem(new Point(4.0, 10.0)));
        assertThat(cartesianCoordinates, hasItem(new Point(-5.0, 8.0)));
    }
}