/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dhono
 */

public class CarportException extends AbstractException{
    
    //Target er den side man skal hen til når CarportException bliver kastet -> SelectMeasurements
    private String target = "SelectMeasurements.jsp";
    
    public CarportException(String msg) {
        super(msg);
    }
    
    public CarportException (String target, String message) {
        super(message);
        this.target = target;
    }

    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return target;
    }

}
