/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandCarportSelectCustom extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) 
            throws ServletException, IOException, AbstractException {
        String roofType = request.getParameter("rooftype");
        HttpSession session = request.getSession();
        session.setAttribute("rooftype", roofType);
        String shed = request.getParameter("shed");
        session.setAttribute("shed", shed);
        return "createOrderPage.jsp";
    }
    
}
