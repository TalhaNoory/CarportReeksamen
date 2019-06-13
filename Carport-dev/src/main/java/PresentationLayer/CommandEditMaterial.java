/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.Exceptions.EditMaterialException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandEditMaterial extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        try {
            int materialId = Integer.parseInt(request.getParameter("materialid"));
            String newName = request.getParameter("materialname");
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ ]+$", newName)) {
                throw new EditMaterialException("There was an error in the material name, please try again.");
            }
            String newMSRP = request.getParameter("msrp");
            if (!Pattern.matches("^[0-9]+$", newMSRP)) {
                throw new EditMaterialException("There was an error in the msrp, please try again.");
            }
            String newCostPrice = request.getParameter("costPrice");
            if (!Pattern.matches("^[0-9]+$", newCostPrice)) {
                throw new EditMaterialException("There was an error in the cost price, please try again.");
            }
            logic.editMaterial(materialId, newName, Integer.parseInt(newMSRP), Integer.parseInt(newCostPrice));
            ArrayList<Material> materials = logic.getAllMaterials();
            HttpSession session = request.getSession();
            session.setAttribute("materials", materials);
        } catch (NumberFormatException ex) {
            throw new EditMaterialException("Please check your new inputs again.");
        }
        return "Materials.jsp";
    }

}
