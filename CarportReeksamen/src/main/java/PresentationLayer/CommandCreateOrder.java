package PresentationLayer;

import DataLayer.Customer;
import DataLayer.Employee;
import DataLayer.Material;
import FunctionLayer.CalculatePoles;
import FunctionLayer.CalculatePrice;
import FunctionLayer.CalculateRoof;
import FunctionLayer.CalculateShed;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandCreateOrder extends Command {
    
    
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws CarportException {
        
        String customerName = request.getParameter("customerName");
        if (customerName.isEmpty()) throw new CarportException("Customer name cannot be empty, try again");
        String email = request.getParameter("email");
        if (email.isEmpty()) throw new CarportException("Email cannot be empty, try again");
        String address = request.getParameter("address");
        if (address.isEmpty()) throw new CarportException("Address cannot be empty, try again");
        Integer zipCode =  Integer.parseInt(request.getParameter("zipCode"));
        if (zipCode.toString().length() != 4) throw new CarportException("Zipcode must contain 4 digits, try again");
        
        CalculatePoles cp = new CalculatePoles();
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        double distanceBetweenPoles = cp.getPoleDistance(carportLength);
                
        request.setAttribute("carportWidth", carportWidth);
        request.setAttribute("carportLength", carportLength);
        request.setAttribute("shedLength", shedLength);
        request.setAttribute("shedWidth", shedWidth);
        request.setAttribute("distanceBetweenPoles", distanceBetweenPoles);
        
        //Employee
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        int employeeId = employee.getEmployee_Id();
        
        //Customer
        logic.createCustomer(customerName, email, address, zipCode);
        Customer customer = logic.getCustomer(email);
        int customerId = customer.getCustomer_Id();

        //Her lister vi alle Materialerne ind i et Array
        ArrayList<Material> materials = logic.getAllMaterials();
        request.setAttribute("materials", materials);
        
        //int Array'et (amounts) skal indeholde PRISERNE på de forskellige materialer, 
        //det skal så genereres ind på en liste i ShowMaterials.jsp
        int amounts[] = new int[6]; 
        
        //Pris til pælene (Carporten)
        int amountOfPoles = cp.getAmountOfPoles(carportLength);
        amounts[1] = amountOfPoles;
        
        //Pris til tagets materialer (Carporten)
        CalculateRoof cr = new CalculateRoof();
        int amountOfSternBoards = cr.getAmountOfSternBoards(carportLength, carportWidth);
        amounts[0] = amountOfSternBoards;
        int amountOfPlastmo = cr.getAmountOfPlastmo(carportWidth, carportLength);
        amounts[2] = amountOfPlastmo;
        int amountOfRoofScrewPackages = cr.getAmountOfScrewPackages(amountOfPlastmo);
        amounts[3] = amountOfRoofScrewPackages;       
        
        //Pris til skurets materialer (Carporten)
        CalculateShed cs = new CalculateShed();
        int amountofShedBoards = cs.getAmountofBoards(shedLength, shedWidth);
        amounts[4] = amountofShedBoards;
        int amountOfShedScrewPackages = cs.getAmountOfScrewPackages(amountofShedBoards);
        amounts[5] = amountOfShedScrewPackages;
        
        CalculatePrice calP = new CalculatePrice();
        int totalPrice = calP.calculatePrice(
                amountOfSternBoards, amountOfPoles, 
                amountOfPlastmo, amountOfRoofScrewPackages, 
                amountofShedBoards, amountOfShedScrewPackages);       
        
        logic.createOrder(employeeId, customerId,
            carportHeight, carportLength, carportWidth,
            shedLength, shedWidth, totalPrice);
        
       
        request.setAttribute("amounts", amounts);
        
        return "ShowMaterials.jsp";

    }

}
