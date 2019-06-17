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
public class CalculatePriceTest {
    
    public CalculatePriceTest() {
    }
    
    /**
     * Test of calculatePrice method, of class CalculatePrice.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        int amountOfSternBoards = 10;
        int amountOfPoles = 8;
        int amountOfPlastmo = 12;
        int amountOfRoofScrewPackages = 4;
        int amountofShedBoards = 210;
        int amountOfShedScrewPackages = 3;
        CalculatePrice instance = new CalculatePrice();
        int expResult = 22720;
        int result = instance.calculatePrice(amountOfSternBoards, amountOfPoles, amountOfPlastmo, amountOfRoofScrewPackages, amountofShedBoards, amountOfShedScrewPackages);
        assertEquals(expResult, result);
    }
    
}
