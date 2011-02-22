/*
 * RegressionFactory.java
 *
 * Created on 28/07/2007, 18:02:06
 */

package org.modelmat.core.regression;

import java.util.HashMap;
import java.util.Map;

import org.modelmat.core.regression.AbstractRegression.RegressionType;

/**
 * Regression's Factory.
 * 
 * "Open for extension, closed for modification". 
 * Clients don't need to change anything when add new implementations
 * of regression's algorithms thanks, basically,
 * to Strategy and Method Factory patterns.
 * 
 * @author Rafael Fiume
 */
public class RegressionFactory {

    private static RegressionFactory factory;

    private Map<RegressionType, AbstractRegression> cache = 
                new HashMap<RegressionType, AbstractRegression>();

    private RegressionFactory() {
    }

    public static synchronized RegressionFactory getRegressionFactory() {
        if (factory == null) {
            factory = new RegressionFactory();
        }
        return factory;
    }

    public AbstractRegression getRegression(RegressionType type) {
        if (type == RegressionType.LINEAR) {
            System.out.println(getLinearRegression());
            return getLinearRegression();        
        } else if (type == RegressionType.NON_LINEAR) {
            return getNonLinearRegression();
        }
        return null; // Line execution must not come at this point.
    }

    private AbstractRegression getLinearRegression() {
        if (cache.containsKey(RegressionType.LINEAR)) {
            return cache.get(RegressionType.LINEAR);
        }        
        LinearRegression linearRegression = new LinearRegression();
        cache.put(RegressionType.LINEAR, linearRegression);
        return linearRegression;
    }
    
    private AbstractRegression getNonLinearRegression() {        
        if (cache.containsKey(RegressionType.NON_LINEAR)) {
            return cache.get(RegressionType.NON_LINEAR);            
        } 
        NonLinearRegression nonLinearRegression = new NonLinearRegression();
        cache.put(RegressionType.NON_LINEAR, nonLinearRegression);
        return nonLinearRegression;
    }
}
