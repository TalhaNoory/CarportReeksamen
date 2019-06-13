/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Customer;
import DBAccess.Employee;
import DBAccess.Order;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Exceptions.CreateOrderException;
import FunctionLayer.RoofBuilder;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandCreateOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, AbstractException {
        try {
            int carportLength = Integer.parseInt(request.getParameter("carportlength"));
            int carportWidth = Integer.parseInt(request.getParameter("carportwidth"));
            HttpSession session = request.getSession();
            String roofType = (String) session.getAttribute("rooftype");
            int roofAngle;
            if (roofType.equals("fladt")) {
                roofAngle = 0;
            } else {
                roofAngle = Integer.parseInt((String) request.getParameter("roofangle"));
            }
            int shedWidth;
            int shedLength;
            if (session.getAttribute("shed").equals("noshed")){
                shedWidth = 0;
                shedLength = 0;
            }
            else{
            shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
            shedLength = Integer.parseInt(request.getParameter("shedlength"));
            }
            RoofBuilder rb = new RoofBuilder();
            int carportHeight = rb.getCarportHeight(carportWidth, roofAngle).intValue();
            String customerName = request.getParameter("customername");
            if (!Pattern.matches("^[a-zA-ZæøåÆØÅ ]+$", customerName)){
                throw new CreateOrderException("There was an error in the customer name, please try again.");
            }
            String customerEmail = request.getParameter("customeremail");
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ@.]+$", customerEmail)){
                throw new CreateOrderException("There was an error in the customer email, please try again.");
            }
            String customerAddress = request.getParameter("customeraddress");
            if (!Pattern.matches("^[a-zA-Z0-9æøåÆØÅ ]+$", customerAddress)){
                throw new CreateOrderException("There was an error in the customer address, please try again.");
            }
            String customerZipcode = request.getParameter("customerzipcode");
            if (!Pattern.matches("[0-9]{4}", customerZipcode)){
                throw new CreateOrderException("There was an error in the customer zipcode, please try again.");
            }
            String customerPhonenumber = request.getParameter("customerphonenumber");
            if (!Pattern.matches("[0-9]{8}", customerPhonenumber)){
                throw new CreateOrderException("There was an error in the customer phone number, please try again.");
            }
            String customerComment = request.getParameter("customercomment");
            logic.createCustomer(customerName, customerEmail, customerAddress, Integer.parseInt(customerZipcode), customerPhonenumber);
            Customer customer = logic.getCustomer(request.getParameter("customeremail"));
            int customerId = customer.getCustomerId();
            //int totalSale = Integer.parseInt(request.getParameter("salesprice"));
            Employee employee = (Employee) session.getAttribute("employee");
            int employeeId = employee.getEmployeeId();
            //placeholder værdier
            //int totalCost = 100;
            Order order = logic.createOrder(employeeId, customerId, carportHeight, carportWidth, carportLength, roofType, roofAngle, shedWidth, shedLength, customerComment, 0, 0);
            request.setAttribute("order", order);
            Order newestOrder = logic.getNewestOrder();
            logic.createMaterialList(newestOrder);
            logic.setTotalCostPrice(logic.getFullListofMaterial(newestOrder.getOrderId()), newestOrder);
            logic.setTotalSalePrice(logic.getFullListofMaterial(newestOrder.getOrderId()), newestOrder);
            request.setAttribute("newestorder", newestOrder);
        } catch (NumberFormatException ex) {
            throw new CreateOrderException("There was an error in one or more of the input fields, please check them again.");
        }
        return "carportSelectPage.jsp";
    }

}
