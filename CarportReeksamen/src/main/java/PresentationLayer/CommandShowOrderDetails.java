/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.Material;
import DataLayer.Order;
import FunctionLayer.CalculatePoles;
import FunctionLayer.CalculatePrice;
import FunctionLayer.CalculateRoof;
import FunctionLayer.CalculateShed;
import FunctionLayer.Exceptions.AbstractException;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dhono
 */
public class CommandShowOrderDetails extends Command{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws AbstractException {
        
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        
        Order order = logic.getOrderByID(orderId);
        
        CalculatePoles cp = new CalculatePoles();
        int carportLength = order.getCarportLength();
        int carportWidth = order.getCarportWidth();
        int shedLength = order.getShedLength();
        int shedWidth = order.getShedWidth();
        double distanceBetweenPoles = cp.getPoleDistance(carportLength);
        
        request.setAttribute("carportWidth", carportWidth);
        request.setAttribute("carportLength", carportLength);
        request.setAttribute("shedLength", shedLength);
        request.setAttribute("shedWidth", shedWidth);
        request.setAttribute("distanceBetweenPoles", distanceBetweenPoles);
        
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
        
        request.setAttribute("amounts", amounts);
        
        return "ShowMaterials.jsp";
    }
    
}
