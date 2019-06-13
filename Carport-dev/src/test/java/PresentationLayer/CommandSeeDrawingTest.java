/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Employee;
import DBAccess.LineItem;
import DBAccess.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.PoleBuilder;
import FunctionLayer.RoofBuilder;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author frede
 */
public class CommandSeeDrawingTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private Order order;

    @Mock
    private RoofBuilder rb;

    @Mock
    private Customer customer;
    
    @Mock 
    private PoleBuilder pb;
    
    @Mock
    private ArrayList<LineItem> LT;
    
    
    public CommandSeeDrawingTest() {
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
     * Test of execute method, of class CommandSeeDrawing.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("orderId")).thenReturn("1");
        when(logic.getOrder(1)).thenReturn(order);
        Order o = logic.getOrder(1);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Order value = invocation.getArgument(1);
                    assertThat(value, is(order));
                    return null;
                }
        ).when(request).setAttribute("order", o);
        when(order.getCarportLength()).thenReturn(600);
        when(pb.getDistanceBetweenPoles(600)).thenReturn(200.);
        double distance = pb.getDistanceBetweenPoles(600);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    double value = invocation.getArgument(1);
                    assertThat(value, is(200.));
                    return null;
                }
        ).when(request).setAttribute("distance", distance);
        when(order.getCarportWidth()).thenReturn(300);
        when(order.getRoofAngle()).thenReturn(25);
        int carportWidth = order.getCarportWidth();
        int roofAngle = order.getRoofAngle();
        when(rb.getCarportHeight(carportWidth, roofAngle)).thenReturn(305.);
        when(rb.getRafterSideLength(carportWidth, roofAngle)).thenReturn(350.);
        double carportHeight = rb.getCarportHeight(carportWidth, roofAngle);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    double value = invocation.getArgument(1);
                    assertThat(value, is(305.));
                    return null;
                }
        ).when(request).setAttribute("carportheight", carportHeight);
        double rafterLength = rb.getRafterSideLength(carportWidth, roofAngle);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    double value = invocation.getArgument(1);
                    assertThat(value, is(350.));
                    return null;
                }
        ).when(request).setAttribute("siderafterlength", rafterLength);
        when(order.getCustomerId()).thenReturn(1);
        when(logic.getCustomerID(order.getCustomerId())).thenReturn(customer);
        Customer c = logic.getCustomerID(1);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Customer value = invocation.getArgument(1);
                    assertThat(value, is(customer));
                    return null;
                }
        ).when(request).setAttribute("customer", c);
        when(logic.getFullListofMaterial(1)).thenReturn(LT);
        ArrayList<LineItem> lineItems = logic.getFullListofMaterial(1);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<LineItem> value = invocation.getArgument(1);
                    assertThat(value, is(LT));
                    return null;
                }
        ).when(request).setAttribute("LT", lineItems);
        Command command = new CommandSeeDrawing();
        String target = command.execute(request, logic);
        assertThat(target, is("technicalDrawing.jsp"));
    }
    
}
