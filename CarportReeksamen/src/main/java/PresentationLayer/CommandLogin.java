/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Employee;
import DataLayer.EmployeeMapper;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhono
 */
public class CommandLogin extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) {

        try {
            HttpSession session = request.getSession();
            EmployeeMapper em  = new EmployeeMapper();
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Employee employee = em.login(email, password);
            session.setAttribute("employee", employee);
        } catch (CarportException ex) {
            Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            return "SelectMeasurements.jsp";
    }
}
