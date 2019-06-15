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
public class OrderException extends AbstractExceptions {
    //d.15-06
    //Skal helst sendes det samme sted man laver tingene!
    String origin = "SelectMeasurements.jsp";
    
    public OrderException (String msg) {
        super(msg);
    }

    @Override
    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return origin;
    }
    
}
