/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.Order;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author frede
 */
public class MaterialCalcTest {
    @Mock
    private ShedBuilder sb;
    
    @Mock
    private RoofBuilder rb;
    public MaterialCalcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of buildShed method, of class MaterialCalc.
     */
    @Test
    public void testBuildShed250x250() throws Exception {
        when(sb.getTotalSurfaceLength(250, 250)).thenReturn(1000);
        int surfaceLength = sb.getTotalSurfaceLength(250, 250);
        when(sb.getNumberOfBoards(surfaceLength)).thenReturn(167);
        int amountofBoards = sb.getNumberOfBoards(surfaceLength);
        int[] result ={24 * 8, ((amountofBoards/2)*3), ((amountofBoards/2)*6)};
        assertThat(result[0], is(192));
        assertThat(result[1], is(249));
        assertThat(result[2], is(498));
    }

    /**
     * Test of buildAngleRoofStructure method, of class MaterialCalc.
     */
    @Test
    public void testBuildAngleRoofStructureCarportWidth300Angle25() throws Exception {
        when(rb.getRafterSideLength(300, 25)).thenReturn(182.06);
        double length = rb.getRafterSideLength(300, 25);
        int actualLength = (int) length+1;
        int amountOfRafters = actualLength/30;
        int AmountOfPremadeRafters = 5;
        int result = amountOfRafters*AmountOfPremadeRafters;
        assertThat(result, is(30));
    }

    /**
     * Test of buildTriangle method, of class MaterialCalc.
     */
    @Test
    public void testBuildTriangleCarportLength720() throws Exception {
        int carportLength = 720;
        int amountofPremadeRafters = carportLength/100;
        assertThat(amountofPremadeRafters, is(7));
    }

    /**
     * Test of buildGable method, of class MaterialCalc.
     */
    @Test
    public void testBuildGable() throws Exception {
        int carportWidth = 300;
        int surfaceLength = carportWidth*2;
        when(sb.getNumberOfBoards(surfaceLength)).thenReturn(100);
        int amountofBoards = sb.getNumberOfBoards(surfaceLength);
        int[] result ={24 * 8, ((amountofBoards/2)*3), ((amountofBoards/2)*6)};
        assertThat(result[0], is(192));
        assertThat(result[1], is(150));
        assertThat(result[2], is(300));
    }

    /**
     * Test of buildFlatRoof method, of class MaterialCalc.
     */
    @Test
    public void testBuildFlatRoof600x300() throws Exception {
        int area = 600*300;
        when(rb.getAmountOfPlastmo(area)).thenReturn(4);
        int amountOfPlastmo = rb.getAmountOfPlastmo(area);
        assertThat(amountOfPlastmo, is(4));
    }


    
}
