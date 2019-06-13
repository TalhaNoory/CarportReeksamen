/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Employee;
import DBAccess.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.RoofBuilder;
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
public class CommandCreateOrderTest {

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
    private Employee employee;

    public CommandCreateOrderTest() {
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
     * Test of execute method, of class CommandCreateOrder.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("shed")).thenReturn("shed");
        when(session.getAttribute("rooftype")).thenReturn("med rejsning");
        when(request.getParameter("carportlength")).thenReturn("720");
        int carportLength = Integer.parseInt(request.getParameter("carportlength"));
        when(request.getParameter("carportwidth")).thenReturn("360");
        int carportWidth = Integer.parseInt(request.getParameter("carportwidth"));
        when(request.getParameter("rooftype")).thenReturn("med rejsning");
        String roofType = order.getRoofType();
        when(request.getParameter("roofangle")).thenReturn("25");
        int roofAngle = Integer.parseInt(request.getParameter("roofangle"));
        when(rb.getCarportHeight(carportWidth, roofAngle)).thenReturn(305.);
        Double carportHeightDouble = rb.getCarportHeight(carportWidth, roofAngle);
        int carportHeight = carportHeightDouble.intValue();
        when(request.getParameter("shedwidth")).thenReturn("360");
        int shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
        when(request.getParameter("shedlength")).thenReturn("225");
        int shedLength = Integer.parseInt(request.getParameter("shedlength"));
        when(request.getParameter("customername")).thenReturn("test");
        when(request.getParameter("customeremail")).thenReturn("test");
        when(request.getParameter("customeraddress")).thenReturn("test");
        when(request.getParameter("customerzipcode")).thenReturn("1234");
        when(request.getParameter("customerphonenumber")).thenReturn("12345678");
        when(request.getParameter("customercomment")).thenReturn("test");
        String customerComment = request.getParameter("customercomment");
        when(logic.getCustomer("test")).thenReturn(customer);
        when(customer.getCustomerId()).thenReturn(1);
        when(session.getAttribute("employee")).thenReturn(employee);
        when(logic.createOrder(1, 1, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, 1, 1)).thenReturn(order);
        Order o = logic.createOrder(1, 1, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, 1, 1);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Order value = invocation.getArgument(1);
                    assertThat(value, is(order));
                    return null;
                }
        ).when(request).setAttribute("order", o);
        when(logic.getNewestOrder()).thenReturn(order);
        Order newestOrder = logic.getNewestOrder();
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Order value = invocation.getArgument(1);
                    assertThat(value, is(order));
                    return null;
                }
        ).when(request).setAttribute("newestorder", newestOrder);
        Command command = new CommandCreateOrder();
        String target = command.execute(request, logic);
        assertThat(target, is("carportSelectPage.jsp"));
    }

}
