/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Employee;
import DataLayer.EmployeeMapper;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhono
 */
public class CommandLogin extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws AbstractException{
            
            String email = request.getParameter("email");
            if (email.isEmpty()) throw new LoginException("Email is empty, try again");
            String password = request.getParameter("password");
            if (password.isEmpty()) throw new LoginException("Password is empty, try again");
            
            HttpSession session = request.getSession();
            Employee employee = logic.login(email, password);
            session.setAttribute("employee", employee);
            return "SelectMeasurements.jsp";
    }
}
