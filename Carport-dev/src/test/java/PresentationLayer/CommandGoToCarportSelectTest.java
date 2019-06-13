/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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

/**
 *
 * @author frede
 */
public class CommandGoToCarportSelectTest {
    @Mock
    private LogicFacade logic;
    
    @Mock
    private HttpServletRequest request;
    
    public CommandGoToCarportSelectTest() {
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
     * Test of execute method, of class CommandGoToCarportSelect.
     */
    @Test
    public void testExecute() throws Exception {
        Command command = new CommandGoToCarportSelect();
        String target = command.execute(request, logic);
        assertThat(target, is("carportSelectPage.jsp"));
    }
    
}
