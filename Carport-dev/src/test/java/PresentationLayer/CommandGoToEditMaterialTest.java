/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
import DBAccess.Order;
import FunctionLayer.LogicFacade;
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
public class CommandGoToEditMaterialTest {

    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;
    
    @Mock
    private Material material;

    public CommandGoToEditMaterialTest() {
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
     * Test of execute method, of class CommandGoToEditMaterial.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("materialId")).thenReturn("1");
        int materialId = Integer.parseInt(request.getParameter("materialId"));
        when(request.getSession()).thenReturn(session);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    int value = invocation.getArgument(1);
                    assertThat(value, is(1));
                    return null;
                }
        ).when(session).setAttribute("materialid", materialId);
        when(logic.getMaterial(materialId)).thenReturn(material);
        Material m = logic.getMaterial(materialId);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    Material value = invocation.getArgument(1);
                    assertThat(value, is(material));
                    return null;
                }
        ).when(session).setAttribute("material", m);
        Command command = new CommandGoToEditMaterial();
        String target = command.execute(request, logic);
        assertThat(target, is("EditMaterial.jsp"));
    }

}
