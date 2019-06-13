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
public class RoofBuilderTest {
    
    public RoofBuilderTest() {
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
     * Test of getRafterSideLength method, of class RoofBuilder.
     */
    @Test
    public void testGetRafterSideLength() {
        System.out.println("getRafterSideLength");
        int carportWidth = 300;
        int roofAngle = 25;
        RoofBuilder instance = new RoofBuilder();
        Double expResult = 182.1;
        Double result = instance.getRafterSideLength(carportWidth, roofAngle);
        result = Math.round(result * 10) / 10.0;
        assertEquals(expResult,result);
    }

    /**
     * Test of getRoofArea method, of class RoofBuilder.
     */
    @Test
    public void testGetRoofAreaFlatRoof() {
        System.out.println("getRoofArea");
        int carportLength = 10;
        int carportWidth = 10;
        int roofAngle = 0;
        RoofBuilder instance = new RoofBuilder();
        Double expResult = 2800.0;
        Double result = instance.getRoofArea(carportLength, carportWidth, roofAngle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRoofAreaRoofWithHeight() {
        System.out.println("getRoofArea");
        int carportLength = 10;
        int carportWidth = 10;
        int roofAngle = 15;
        RoofBuilder instance = new RoofBuilder();
        Double expResult = 2898.8;
        Double result = instance.getRoofArea(carportLength, carportWidth, roofAngle);
        result = Math.round(result * 10) / 10.0;
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfRoofTiles method, of class RoofBuilder.
     */
    @Test
    public void testGetAmountOfRoofTilesRoofArea72600() {
        System.out.println("getAmountOfRoofTiles");
        int roofArea = 72600;
        RoofBuilder instance = new RoofBuilder();
        int expResult = 100;
        int result = instance.getAmountOfRoofTiles(roofArea);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAmountOfRoofTilesRoofArea72601() {
        System.out.println("getAmountOfRoofTiles");
        int roofArea = 72601;
        RoofBuilder instance = new RoofBuilder();
        int expResult = 101;
        int result = instance.getAmountOfRoofTiles(roofArea);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfRidgeTiles method, of class RoofBuilder.
     */
    @Test
    public void testGetAmountOfRidgeTilesRoofLength330() {
        System.out.println("getAmountOfRidgeTiles");
        int roofLength = 330;
        RoofBuilder instance = new RoofBuilder();
        int expResult = 10;
        int result = instance.getAmountOfRidgeTiles(roofLength);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAmountOfRidgeTilesRoofLength331() {
        System.out.println("getAmountOfRidgeTiles");
        int roofLength = 331;
        RoofBuilder instance = new RoofBuilder();
        int expResult = 11;
        int result = instance.getAmountOfRidgeTiles(roofLength);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarportHeight method, of class RoofBuilder.
     */
    @Test
    public void testGetCarportHeightWithFlatRoof() {
        System.out.println("getCarportHeight");
        int carportWidth = 300;
        int roofAngle = 0;
        RoofBuilder instance = new RoofBuilder();
        Double expResult = 225.0;
        Double result = instance.getCarportHeight(carportWidth, roofAngle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCarportHeightRoofWithAngle() {
        System.out.println("getCarportHeight");
        int carportWidth = 360;
        int roofAngle = 25;
        RoofBuilder instance = new RoofBuilder();
        Double expResult = 315.9;
        Double result = instance.getCarportHeight(carportWidth, roofAngle);
        result = Math.round(result * 10) / 10.0;
        assertEquals(expResult, result);
    }
    
}
