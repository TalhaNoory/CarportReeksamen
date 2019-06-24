/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhono
 */
public class CommandLogout extends Command{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws AbstractException {
        HttpSession session = request.getSession();
//        Reset Session 
        session.invalidate();
//        Sends User back to main page
        return "index.jsp";
    }
    
}
