/*
 * NonLinearRegression.java
 *
 * Created on 20 de Dezembro de 2006, 05:43
 */

package org.ptolomeu.core.regression;

import java.util.Map;

import org.ptolomeu.core.regression.exception.CoordinateNumberException;
import org.ptolomeu.core.regression.exception.InsufficientDataException;

/**
 *
 * @author Rafael Fiume
 * @author JoÃ£o AurÃ©lio B. Franzini
 */
public class NonLinearRegression extends AbstractRegression {
    
    private double a11, a12, a13, a21, a22, a23, a31, a32, a33;
    private double m21, m31, m32, y1, y2, y3;
    
    @Override
    @SuppressWarnings("LooseCoupling")
    public NonLinearRegressionResult doRegression(
                final Map<XYIndex, Double> matriz) 
                throws InsufficientDataException, CoordinateNumberException {
        
        final int numCoord = (matriz.size() / 2);
        
        if(numCoord < MIN_COORD) {
            throw new InsufficientDataException();
        }
        
        final NonLinearRegressionResult nonLinearResult = 
                new NonLinearRegressionResult();
        
        a11 = (float) (matriz.size() / 2);
        a21 = sumX(matriz);
        a31 = sumX2(matriz);
        a12 = a21;
        a22 = a31;
        a32 = sumX3(matriz);
        a13 = a31;
        a23 = a32;
        a33 = sumX4(matriz);
        
        y1  = sumY(matriz);
        y2  = sumXY(matriz);
        y3  = sumX2Y(matriz);
        
        m21 = a21 / (float) a11;
        m31 = a31 / (float) a11;
        
        if(m21 != 0) {
            a21 = a21 - ((float) a11 * m21);
            a22 = a22 - (a12 * m21);
            a23 = a23 - (a13 * m21);
        }
        
        if(m31 != 0) {
            a31 = a31 - ((float) a11 * m31);
            a32 = a32 - (a12 * m31);
            a33 = a33 - (a13 * m31);
        }
        
        m32 = a32 / a22;
        
        if(m32 != 0) {
            a32 = a32 - (a22 * m32);
            a33 = a33 - (a23 * m32);
        }
        
        y2 = y2 - (m21 * y1);
        y3 = y3 - m31 * y1 - m32 * y2;
        
        nonLinearResult.coefC = y3 / a33;        
        nonLinearResult.coefB = (y2 - (a23 * nonLinearResult.coefC)) / a22;        
        nonLinearResult.coefA = 
                (y1 - 
                (a13 * nonLinearResult.coefC) - (a12 * nonLinearResult.coefB)) / 
                (float) a11;
        
        nonLinearResult.setCoordValues(matriz);
        
        return nonLinearResult;
    }
    
}

