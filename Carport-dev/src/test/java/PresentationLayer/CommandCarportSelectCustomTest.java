/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class CommandCarportSelectCustomTest {
  @Mock
  private LogicFacade logic;
  
  @Mock
  private HttpServletRequest request;
  
  @Mock
  private HttpSession session;
    
    public CommandCarportSelectCustomTest() {
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
     * Test of execute method, of class CommandCarportSelectCustom.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testExecute() throws Exception {
    when(request.getParameter("rooftype")).thenReturn("fladt");
    when(request.getParameter("shed")).thenReturn("shed");
    when(request.getSession()).thenReturn(session);
    String roofType = request.getParameter("rooftype");
    doAnswer( 
      invocation -> {
          String key = invocation.getArgument(0);
          String value = invocation.getArgument(1);
          assertThat(value, is("fladt"));
          return null;
          }
      ).when(session).setAttribute("rooftype", roofType);
    String shed = request.getParameter("shed");
    doAnswer( 
      invocation -> {
          String key = invocation.getArgument(0);
          String value = invocation.getArgument(1);
          assertThat(value, is("shed"));
          return null;
          }
      ).when(session).setAttribute("shed", shed);
    Command command = new CommandCarportSelectCustom();
    String target = command.execute(request, logic);
    assertThat(target, is("createOrderPage.jsp"));
    }
    
    
}
