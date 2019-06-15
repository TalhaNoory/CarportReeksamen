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

//d.15-06
//Spørgsmål : hvad gør Super?
//Svar      : Undersøg nærmere!
public class CarportException extends AbstractExceptions {
    //d.15-06
    //Origin er den side man skal hen til når CarportException bliver kastet -> SelectMeasurements
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
//    //d.15-06
//    OBS!!! Have den her med ind på JSP'erne, så den kan viser problemet i JSP'en
    
//    <% String error = (String) request.getAttribute("error");
//            if (error != null) {
//                out.println("<H2>Error!!</h2>");
//                out.println(error);
//            }
//        %>
    
    
}
