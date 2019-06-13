/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Order;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
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
public class CommandGetCustomerTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;
    
    @Mock
    private Customer customer;
    
    
    public CommandGetCustomerTest() {
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
     * Test of execute method, of class CommandGetCustomer.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("customeremail")).thenReturn("email");
        when(logic.getCustomer("email")).thenReturn(customer);
        when(customer.getCustomerId()).thenReturn(1);
        when(logic.getOrdersFromCustomer(1)).thenReturn(new ArrayList<Order>());
        ArrayList<Order> ofc = logic.getOrdersFromCustomer(1);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<Order> value = invocation.getArgument(1);
                    assertThat(value, is(ofc));
                    return null;
                }
        ).when(request).setAttribute("ofc", ofc);
        Customer c = logic.getCustomer("email");
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Customer value = invocation.getArgument(1);
                    assertThat(value, is(customer));
                    return null;
                }
        ).when(request).setAttribute("c", c);
        Command command = new CommandGetCustomer();
        String target = command.execute(request, logic);
        assertThat(target, is("CustomerView.jsp"));
    }
    
}
