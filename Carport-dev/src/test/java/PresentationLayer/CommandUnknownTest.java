/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.LogicFacade;
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
import org.mockito.MockitoAnnotations;

/**
 *
 * @author frede
 */
public class CommandUnknownTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;
    
    public CommandUnknownTest() {
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
     * Test of execute method, of class CommandUnknown.
     */
    @Test
    public void testExecute() throws Exception {
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    String value = invocation.getArgument(1);
                    assertThat(value, is("unknown command"));
                    return null;
                }
        ).when(request).setAttribute("error", "unknown command");
        Command command = new CommandUnknown();
        String target = command.execute(request, logic);
        assertThat(target, is("carportSelectPage.jsp"));
    }
    
}
