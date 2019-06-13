/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.Exceptions.CreateMaterialException;
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
public class CommandCreateMaterial extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        try {
            String materialName = request.getParameter("materialname");
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ ]+$", materialName)) {
                throw new CreateMaterialException("There was an error in the material name, please try again.");
            }
            String msrp = request.getParameter("msrp");
            if (!Pattern.matches("^[0-9]+$", msrp)) {
                throw new CreateMaterialException("There was an error in the msrp, please try again.");
            }
            String costPrice = request.getParameter("costprice");
            if (!Pattern.matches("^[0-9]+$", costPrice)) {
                throw new CreateMaterialException("There was an error in the costPrice, please try again.");
            }
            logic.createMaterial(new Material(materialName, Integer.parseInt(msrp), Integer.parseInt(costPrice)));
            Material newestMaterial = logic.getNewestMaterial();
            request.setAttribute("newestmaterial", newestMaterial);
            ArrayList<Material> materials = logic.getAllMaterials();
            HttpSession session = request.getSession();
            session.setAttribute("materials", materials);
        } catch (NumberFormatException ex) {
            throw new CreateMaterialException("Please check your new inputs again.");
        }
        return "Materials.jsp";
    }

}
