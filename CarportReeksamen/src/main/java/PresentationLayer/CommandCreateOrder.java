package PresentationLayer;

import DataLayer.Customer;
import DataLayer.Employee;
import FunctionLayer.Exceptions.AbstractExceptions;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandCreateOrder extends Command {
    
    
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws AbstractExceptions {

        HttpSession session = request.getSession();
        
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int zipCode =  Integer.parseInt(request.getParameter("zipCode"));
        
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int totalPrice = 6000;
        
        Employee employee = (Employee) session.getAttribute("employee");
        int employeeId = employee.getEmployee_id();
        
        logic.createCustomer(customerName, email, address, zipCode);
        Customer customer = logic.getCustomer(email);
        int customerId = customer.getCustomer_id();

        logic.createOrder(employeeId, customerId,
            carportHeight, carportLength, carportWidth,
            shedLength, shedWidth, totalPrice);

        return "SelectMeasurements.jsp";

    }

}
