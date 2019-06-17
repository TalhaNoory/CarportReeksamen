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
public class CalculateRoofTest {
    
    public CalculateRoofTest() {
    }
    
    /**
     * Test of getAmountOfPlastmo method, of class CalculateRoof.
     */
    @Test
    public void testGetAmountOfPlastmo() {
        System.out.println("getAmountOfPlastmo");
        int carportWidth = 400;
        int carportlength = 800;
        CalculateRoof instance = new CalculateRoof();
        int expResult = 11;
        int result = instance.getAmountOfPlastmo(carportWidth, carportlength);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfScrewPackages method, of class CalculateRoof.
     */
    @Test
    public void testGetAmountOfScrewPackages() {
        System.out.println("getAmountOfScrewPackages");
        int amountOfPlastmoTiles = 12;
        CalculateRoof instance = new CalculateRoof();
        int expResult = 0;
        int result = instance.getAmountOfScrewPackages(amountOfPlastmoTiles);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfSternBoards method, of class CalculateRoof.
     */
    @Test
    public void testGetAmountOfSternBoards() {
        System.out.println("getAmountOfSternBoards");
        int carportLength = 600;
        int carportWidth = 400;
        CalculateRoof instance = new CalculateRoof();
        int expResult = 6;
        int result = instance.getAmountOfSternBoards(carportLength, carportWidth);
        assertEquals(expResult, result);
    }
    
}
