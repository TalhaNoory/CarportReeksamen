/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Employee;
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
public class CommandLogin extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        Employee employee = logic.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute( "employee", employee );
        return "carportSelectPage.jsp";
    }
    
}
