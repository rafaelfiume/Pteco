package org.ptolomeu.core.regression;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AbstractRegressionResultTest {

    private List<Point> coordinates = new ArrayList() {
        {
            add(new Point(-4.0, 6.0));
            add(new Point(4.0, 10.0));
            add(new Point(-5.0, 8.0));
        }
    };

    private AbstractRegressionResult underTest = new LinearRegressionResult(0, 0, 0, 0, coordinates);

    @Test
    public void getCartesianCoordinates() {
        List<Point> cartesianCoordinates = underTest.orderedPairs();

        assertThat(cartesianCoordinates.size(), is(equalTo(3)));
        assertThat(cartesianCoordinates, hasItem(new Point(-4.0, 6.0)));
        assertThat(cartesianCoordinates, hasItem(new Point(4.0, 10.0)));
        assertThat(cartesianCoordinates, hasItem(new Point(-5.0, 8.0)));
    }

    @Test
    public void min() {
        assertThat(underTest.min(), is(equalTo(-5.0)));
    }

    @Test
    public void max() {
        assertThat(underTest.max(), is(equalTo(10.0)));
    }

}
