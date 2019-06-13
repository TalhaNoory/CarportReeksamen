/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
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
public class CommandCreateMaterialTest {

    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private Material mat;

    @Mock
    private ArrayList<Material> materials;

    public CommandCreateMaterialTest() {
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
     * Test of execute method, of class CommandCreateMaterial.
     */
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("materialname")).thenReturn("material");
        when(request.getParameter("msrp")).thenReturn("200");
        when(request.getParameter("costprice")).thenReturn("150");
        when(logic.getNewestMaterial()).thenReturn(mat);
        when(logic.getAllMaterials()).thenReturn(materials);
        when(request.getSession()).thenReturn(session);
        Material newestMaterial = logic.getNewestMaterial();
        doAnswer(invocation -> {
            String key = invocation.getArgument(0);
            Material value = invocation.getArgument(1);
            assertEquals(value, mat);
            return null;
        }
        ).when(request).setAttribute("newestmaterial", newestMaterial);
        ArrayList<Material> allMaterials = logic.getAllMaterials();
        doAnswer(invocation -> {
            String key = invocation.getArgument(0);
            ArrayList<Material> value = invocation.getArgument(1);
            assertEquals(value, materials);
            return null;
        }
        ).when(request).setAttribute("materials", allMaterials);
        Command command = new CommandCreateMaterial();
        String target = command.execute(request, logic);
        assertThat(target, is("Materials.jsp"));
    }

}
