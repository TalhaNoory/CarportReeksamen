/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
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
public class CommandGoToMaterialsTest {
    
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;
    
    public CommandGoToMaterialsTest() {
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
     * Test of execute method, of class CommandGoToMaterials.
     */
    @Test
    public void testExecute() throws Exception {
        when(logic.getAllMaterials()).thenReturn(new ArrayList<Material>());
        when(request.getSession()).thenReturn(session);
        ArrayList<Material> materials = logic.getAllMaterials();
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<Material> value = invocation.getArgument(1);
                    assertThat(value, is(materials));
                    return null;
                }
        ).when(session).setAttribute("materials", materials);
        Command command = new CommandGoToMaterials();
        String target = command.execute(request, logic);
        assertThat(target, is("Materials.jsp"));
    }
    
}
