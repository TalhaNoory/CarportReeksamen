/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Material;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandGoToMaterials extends Command{

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        ArrayList<Material> materials = logic.getAllMaterials();
        HttpSession session = request.getSession();
        session.setAttribute("materials", materials);
        return "Materials.jsp";
    }
    
}
