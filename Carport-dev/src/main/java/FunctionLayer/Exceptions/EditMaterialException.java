/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

import DBAccess.Material;
import FunctionLayer.LogicFacadeImplementation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class EditMaterialException extends AbstractException {
    private final String origin = "EditMaterial.jsp";
    private final LogicFacadeImplementation logic = new LogicFacadeImplementation();

    public EditMaterialException(String msg) {
        super(msg);
    }
    
    @Override
    public String handle(HttpServletRequest request) {
        try {
            ArrayList<Material> materials = logic.getAllMaterials();
            request.setAttribute("materials", materials);
            HttpSession session = request.getSession();
            Integer materialId = (Integer) session.getAttribute("materialid");
            Material material = logic.getMaterial(materialId);
            request.setAttribute("material", material);
        } catch (CarportException ex) {
            Logger.getLogger(CreateMaterialException.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("error", this.getMessage());
        return origin;
    }
    /*
    int materialId = Integer.parseInt(request.getParameter("materialId"));
        HttpSession session = request.getSession();
        session.setAttribute("materialid", materialId);
        Material material = logic.getMaterial(materialId);
        request.setAttribute("material", material);
    */
}
