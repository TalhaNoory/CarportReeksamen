/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dhono
 */
public class CommandSelectMeasurements extends Command{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws CarportException {
        
        return "SelectMeasurements.jsp";
        
    }
    
}
