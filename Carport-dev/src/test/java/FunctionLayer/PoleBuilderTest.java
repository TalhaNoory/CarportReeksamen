/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class PoleBuilderTest {
    
    public PoleBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDistanceBetweenPoles method, of class PoleBuilder.
     */
    @Test
    public void testGetDistanceBetweenPolesLength420() throws Exception {
        System.out.println("getDistanceBetweenPoles");
        int length = 420;
        PoleBuilder instance = new PoleBuilder();
        double expResult = 400.6;
        double result = instance.getDistanceBetweenPoles(length);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetDistanceBetweenPolesLength430() throws Exception {
        System.out.println("getDistanceBetweenPoles");
        int length = 430;
        PoleBuilder instance = new PoleBuilder();
        double expResult = 200.45;
        double result = instance.getDistanceBetweenPoles(length);
        //vi acceptere en forskel på 0.1 da det rigtige resultat har en masse decimaler
        assertEquals(expResult, result, 0.1);
    }
    

    /**
     * Test of getAmountOfPoles method, of class PoleBuilder.
     */
    @Test
    public void testGetAmountOfPolesLength420() throws Exception {
        System.out.println("getAmountOfPoles");
        int carportLength = 420;
        PoleBuilder instance = new PoleBuilder();
        int expResult = 4;
        int result = instance.getAmountOfPoles(carportLength);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAmountOfPolesLength430() throws Exception{
        System.out.println("getAmountOfPoles");
        int carportLength = 430;
        PoleBuilder instance = new PoleBuilder();
        int expResult = 6;
        int result = instance.getAmountOfPoles(carportLength);
        assertEquals(expResult, result);
    }
   
}
