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
public class CalculateShedTest {
    
    public CalculateShedTest() {
    }

    /**
     * Test of getAmountofBoards method, of class CalculateShed.
     */
    @Test
    public void testGetAmountofBoards() {
        System.out.println("getAmountofBoards");
        int shedLength = 400;
        int shedWidth = 400;
        CalculateShed instance = new CalculateShed();
        int expResult = 271;
        int result = instance.getAmountofBoards(shedLength, shedWidth);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfScrewPackages method, of class CalculateShed.
     */
    @Test
    public void testGetAmountOfScrewPackages() {
        System.out.println("getAmountOfScrewPackages");
        int amountOfBoards = 120;
        CalculateShed instance = new CalculateShed();
        int expResult = 4;
        int result = instance.getAmountOfScrewPackages(amountOfBoards);
        assertEquals(expResult, result);
    }
    
}
