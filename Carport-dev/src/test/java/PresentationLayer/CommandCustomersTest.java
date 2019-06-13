/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import static org.hamcrest.CoreMatchers.any;
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
public class CommandCustomersTest {

    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    public CommandCustomersTest() {
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
     * Test of execute method, of class CommandCustomers.
     */
    @Test
    public void testExecute() throws Exception {
        when(logic.Customerlist()).thenReturn(new ArrayList<Customer>());
        ArrayList<Customer> CL = logic.Customerlist();
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<Customer> value = invocation.getArgument(1);
                    assertThat(value, is(CL));
                    return null;
                }
        ).when(request).setAttribute("CL", CL);
        Command command = new CommandCustomers();
        String target = command.execute(request, logic);
        assertThat(target, is("CustomerList.jsp"));
    }

}
