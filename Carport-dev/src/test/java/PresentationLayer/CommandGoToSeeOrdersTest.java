/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.LogicFacade;
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
public class CommandGoToSeeOrdersTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;
    
    @Mock
    private ArrayList<Order> orders;
    
    public CommandGoToSeeOrdersTest() {
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
     * Test of execute method, of class CommandGoToSeeOrders.
     */
    @Test
    public void testExecute() throws Exception {
        when(logic.getAllOrders()).thenReturn(orders);
        ArrayList<Order> o = logic.getAllOrders();
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<Order> value = invocation.getArgument(1);
                    assertThat(value, is(orders));
                    return null;
                }
        ).when(request).setAttribute("orders", o);
        Command command = new CommandGoToSeeOrders();
        String target = command.execute(request, logic);
        assertThat(target, is("showAllOrdersPage.jsp"));
    }
    
}
