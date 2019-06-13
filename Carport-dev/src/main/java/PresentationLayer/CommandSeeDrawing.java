/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.LineItem;
import DBAccess.Order;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import FunctionLayer.PoleBuilder;
import FunctionLayer.RoofBuilder;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CommandSeeDrawing extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = logic.getOrder(orderId);
        request.setAttribute("order", order);
        PoleBuilder pb = new PoleBuilder();
        double distance = pb.getDistanceBetweenPoles(order.getCarportLength());
        request.setAttribute("distance", distance);
        RoofBuilder rb = new RoofBuilder();
        Double carportHeight = rb.getCarportHeight(order.getCarportWidth(), order.getRoofAngle());
        Double sideRafterLength = rb.getRafterSideLength(order.getCarportWidth(), order.getRoofAngle());
        request.setAttribute("siderafterlength", sideRafterLength);
        request.setAttribute("carportheight", carportHeight);
        Customer customer = logic.getCustomerID(order.getCustomerId());
        request.setAttribute("customer", customer);
        ArrayList<LineItem> LT = logic.getFullListofMaterial(orderId);
        request.setAttribute("LT", LT);
        
        return "technicalDrawing.jsp";
    }

}
