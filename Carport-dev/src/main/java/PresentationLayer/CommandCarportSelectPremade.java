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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandCarportSelectPremade extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        int premadeId = Integer.parseInt(request.getParameter("premadeCarport"));
        Order order = logic.getPremadeOrder(premadeId);
        int carportLength = order.getCarportLength();
        request.setAttribute("carportlength", carportLength);
        int carportWidth = order.getCarportWidth();
        request.setAttribute("carportwidth", carportWidth);
        int carportHeight = order.getCarportHeight();
        request.setAttribute("carportheight", carportHeight);
        String roofType = order.getRoofType();
        HttpSession session = request.getSession();
        session.setAttribute("rooftype", roofType);
        int roofAngle = order.getRoofAngle();
        request.setAttribute("roofangle", roofAngle);
        int shedWidth = order.getShedWidth();
        if (shedWidth == 0){
            session.setAttribute("shed", "noshed");
        }
        else {
            session.setAttribute("shed", "shed");
        }
        request.setAttribute("shedwidth", shedWidth);
        int shedLength = order.getShedLength();
        request.setAttribute("shedlength", shedLength);
        int totalSale = order.getTotalSale();
        request.setAttribute("totalsale", totalSale);
        return "createPremadeOrderPage.jsp";
    }
    
}
