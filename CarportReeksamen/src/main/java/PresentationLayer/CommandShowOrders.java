/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Order;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dhono
 */
public class CommandShowOrders extends Command{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws CarportException {
        
        ArrayList<Order> orders = logic.getOrders();
        request.setAttribute("orders", orders);
        
        return "ShowOrders.jsp";
    }
    
}
