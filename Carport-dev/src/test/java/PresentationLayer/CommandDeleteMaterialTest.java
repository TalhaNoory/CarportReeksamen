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
public class CommandDeleteMaterialTest {
    
    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;
    
    @Mock
    private ArrayList<Material> materials;
    
    @Mock
    private HttpSession session;
    
    public CommandDeleteMaterialTest() {
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
     * Test of execute method, of class CommandDeleteMaterial.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("materialid")).thenReturn("1");
        when(logic.getAllMaterials()).thenReturn(materials);
        when(request.getSession()).thenReturn(session);
        ArrayList<Material> m = logic.getAllMaterials();
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    ArrayList<Material> value = invocation.getArgument(1);
                    assertThat(value, is(materials));
                    return null;
                }
        ).when(request).setAttribute("materials", m);
        Command command = new CommandDeleteMaterial();
        String target = command.execute(request, logic);
        assertThat(target, is("Materials.jsp"));
    }
    
}
