/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dhono
 */
public class CalculatePolesTest {
    
    public CalculatePolesTest() {
    }
    
    /**
     * Test of getPoleDistance method, of class CalculatePoles.
     */
    @Test
    public void testGetPoleDistance() throws Exception {
        System.out.println("getPoleDistance");
        int length = 800;
        CalculatePoles instance = new CalculatePoles();
        double expResult = 253.73333333333335;
        double result = instance.getPoleDistance(length);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAmountOfPoles method, of class CalculatePoles.
     */
    @Test
    public void testGetAmountOfPoles() throws Exception {
        System.out.println("getAmountOfPoles");
        int carportLength = 800;
        CalculatePoles instance = new CalculatePoles();
        int expResult = 8;
        int result = instance.getAmountOfPoles(carportLength);
        assertEquals(expResult, result);
    }
    
}
