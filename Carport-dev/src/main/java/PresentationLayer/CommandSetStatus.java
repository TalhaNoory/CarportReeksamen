/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CommandSetStatus extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        Order o = logic.getOrder(Integer.parseInt(request.getParameter("OrderID")));
        logic.setOrderStatus(request.getParameter("status"), o);
        ArrayList<Order> orders = logic.getAllOrders();
        request.setAttribute("orders", orders);
        return "showAllOrdersPage.jsp";
    }
    
}
