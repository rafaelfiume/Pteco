package org.ptolomeu.core.regression;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.ptolomeu.core.regression.Regression.Type.LINEAR;
import static org.ptolomeu.core.regression.Regression.Type.NON_LINEAR;

public class RegressionFactoryTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final RegressionFactory regressionFactory = RegressionFactory.getInstance();

    @Test
    public void invalidArgument() throws Exception {
        thrown.expect(NullPointerException.class);
        regressionFactory.getRegression(null);
    }

    @Test
    public void getRegression() {
        assertThat(regressionFactory.getRegression(LINEAR), is(instanceOf(LinearRegression.class)));
        assertThat(regressionFactory.getRegression(NON_LINEAR), is(instanceOf(NonLinearRegression.class)));
    }
}
