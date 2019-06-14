/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhono
 */
public class CommandLogin extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
//        AdminMapper am = new AdminMapper();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        Admin admin = am.login(email, password);
//        session.setAttribute("admin", admin);
        
        return "/jsp/SelectMeasurements.jsp";
    }
}
