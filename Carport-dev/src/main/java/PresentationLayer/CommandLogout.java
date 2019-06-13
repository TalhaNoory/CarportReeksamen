/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikolaj
 */
public class CommandLogout extends Command {

    /**
     *
     * @param request
     * @param logic
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws CarportException
     */
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        HttpSession session = request.getSession();
        /* Reset Session */
        session.invalidate();
        request.logout();
        /* Send back to main page */
        return "index.jsp";
    }
}
