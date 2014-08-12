package org.ptolomeu.gui.table;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.ptolomeu.core.regression.GridIndex;
import org.ptolomeu.core.regression.Point;
import org.ptolomeu.core.regression.exception.CoordinateNumberException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OrderedPairFactoryTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private TreeMap<GridIndex, Double> gridValues = new TreeMap() {
        {
            // 1st pair -------------------------------
            put(new GridIndex(0, 0), -4.0); // <- x
            put(new GridIndex(0, 1), 6.0);  // <- y

            // 2nd pair -------------------------------
            put(new GridIndex(3, 0), 4.0);  // <- x
            put(new GridIndex(3, 1), 10.0); // <- y

            // 3rd pair -------------------------------
            put(new GridIndex(7, 0), -5.0); // <- x
            put(new GridIndex(7, 1), 8.0);  // <- y
            //-----------------------------------------
        }
    };

    @Test
    public void getCartesianCoordinates() throws Exception {
        List<Point> coordinates = OrderedPairFactory.getOrderedPairs(gridValues);

        assertThat(coordinates.size(), is(equalTo(3)));
        assertThat(coordinates, hasItem(new Point(-4.0, 6.0)));
        assertThat(coordinates, hasItem(new Point(4.0, 10.0)));
        assertThat(coordinates, hasItem(new Point(-5.0, 8.0)));
    }

    @Test
    public void missingAbscissa() {
        thrown.expect(CoordinateNumberException.class);
        thrown.expectMessage("Missing abscissa (?, 6.0)");
        OrderedPairFactory.getOrderedPairs(whenGridHasMissingAbscissa());
    }

    @Test
    public void missingOrdinate() {
        thrown.expect(CoordinateNumberException.class);
        thrown.expectMessage("Missing ordinate (4.0, ?)");
        OrderedPairFactory.getOrderedPairs(whenGridHasMissingOrdinate());
    }

    @Test
    public void invalidPairs() {
        thrown.expect(CoordinateNumberException.class);
        thrown.expectMessage("Missing abscissa (?, 6.0)");
        OrderedPairFactory.getOrderedPairs(whenGridHasInvalidPairs());
    }

    @Test
    public void noOrderedPair() {
        List<Point> empty = OrderedPairFactory.getOrderedPairs(noData());

        assertThat(empty.size(), is(equalTo(0)));
    }

    private TreeMap<GridIndex, Double> whenGridHasMissingAbscissa() {
        return new TreeMap() {
            {
                // 1st pair -------------------------------
                put(new GridIndex(0, 0), -4.0); // <- x
                put(new GridIndex(0, 1), 6.0);  // <- y

                // 2nd pair -------------------------------
                                                // <- x ???
                put(new GridIndex(1, 1), 6.0);  // <- y
                //-----------------------------------------
            }
        };
    }

    private TreeMap<GridIndex, Double> whenGridHasMissingOrdinate() {
        return new TreeMap() {
            {
                // 1st pair -------------------------------
                put(new GridIndex(0, 0), -4.0); // <- x
                put(new GridIndex(0, 1), 6.0);  // <- y

                // 2nd pair -------------------------------
                put(new GridIndex(3, 0), 4.0);  // <- x
                                                // <- y ???
                //-----------------------------------------
            }
        };
    }

    private TreeMap<GridIndex, Double> whenGridHasInvalidPairs() {
        return new TreeMap() {
            {
                // 1st pair -------------------------------
                                                // <- x ???
                put(new GridIndex(0, 1), 6.0);  // <- y

                // 2nd pair -------------------------------
                put(new GridIndex(3, 0), 4.0);  // <- x
                                                // <- y ???
                //-----------------------------------------
            }
        };
    }

    private TreeMap<GridIndex, Double> noData() {
        return new TreeMap<>();
    }

}
