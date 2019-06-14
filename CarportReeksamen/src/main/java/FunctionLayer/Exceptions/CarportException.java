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

//Spørgsmål : hvad gør Super og hvad gør origin?
//Svar      :
public class CarportException extends AbstractExceptions {
    private String origin = "SelectMeasurements.jsp";
    
    public CarportException(String msg) {
        super(msg);
    }
    
    public CarportException (String origin, String message) {
        super(message);
        this.origin = origin;
    }

    @Override
    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return origin;
    }
    
    
}
