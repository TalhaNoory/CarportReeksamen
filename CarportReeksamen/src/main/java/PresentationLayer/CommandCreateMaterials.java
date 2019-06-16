/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Material;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhono
 */
public class CommandCreateMaterials extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws CarportException {

        
        int materialId = Integer.parseInt(request.getParameter("materialId"));
        String name = request.getParameter("name");
        int costPrice = Integer.parseInt(request.getParameter("costPrice"));

        
        Material material = logic.getMaterial(materialId);
        HttpSession session = request.getSession();
        session.setAttribute("materials", material);

        return "SelectMaterials.jsp";
    }
    
}
