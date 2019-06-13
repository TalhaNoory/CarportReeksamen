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
public class CommandLoginTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private Employee employee;
    
    public CommandLoginTest() {
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
     * Test of execute method, of class CommandLogin.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("email")).thenReturn("email");
        when(request.getParameter("password")).thenReturn("password");
        String email = request.getParameter("email");
        String pw = request.getParameter("password");
        when(logic.login(email, pw)).thenReturn(employee);
        when(request.getSession()).thenReturn(session);
        Employee e = logic.login(email, pw);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Employee value = invocation.getArgument(1);
                    assertThat(value, is(employee));
                    return null;
                }
        ).when(request).setAttribute("employee", e);
        Command command = new CommandLogin();
        String target = command.execute(request, logic);
        assertThat(target, is("carportSelectPage.jsp"));
    }
    
}
