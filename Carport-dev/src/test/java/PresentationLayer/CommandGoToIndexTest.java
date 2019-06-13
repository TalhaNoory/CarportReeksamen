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
import org.mockito.MockitoAnnotations;

/**
 *
 * @author frede
 */
public class CommandGoToIndexTest {
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;
    
    public CommandGoToIndexTest() {
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
     * Test of execute method, of class CommandGoToIndex.
     */
    @Test
    public void testExecute() throws Exception {
        Command command = new CommandGoToIndex();
        String target = command.execute(request, logic);
        assertThat(target, is("index.jsp"));
    }
    
}
