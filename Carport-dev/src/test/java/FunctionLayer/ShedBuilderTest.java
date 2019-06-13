/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

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
public class ShedBuilderTest {
    
    public ShedBuilderTest() {
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
     * Test of getAreaOfShedWalls method, of class ShedBuilder.
     */
    @Test
    public void testgetTotalSurfaceLength() {
        System.out.println("getTotalSurfaceLength");
        int shedLength = 100;
        int shedWidth = 100;
        ShedBuilder instance = new ShedBuilder();
        int expResult = 400;
        int result = instance.getTotalSurfaceLength(shedLength, shedWidth);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfBoards method, of class ShedBuilder.
     */
    @Test
    public void testGetNumberOfBoards() {
        System.out.println("getNumberOfBoards");
        int totalSurfaceLength = 400;
        ShedBuilder instance = new ShedBuilder();
        int expResult = 67;
        int result = instance.getNumberOfBoards(totalSurfaceLength);
        assertEquals(expResult, result);
    }
    
}
