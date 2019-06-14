package PresentationLayer;

import DataLayer.Order;
import FunctionLayer.LogicFacadeImplementation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandCreateOrder extends Command {
    
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        LogicFacadeImplementation logic = new LogicFacadeImplementation();

        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int totalPrice = 6000;

//        Order order = logic.createOrder(carportHeight, carportLength, carportWidth, shedLength, shedWidth, totalPrice);
//        request.setAttribute("order", order);

        return "/jsp/SelectMaterials.jsp";

    }

}
