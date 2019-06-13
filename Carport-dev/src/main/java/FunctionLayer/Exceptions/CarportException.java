/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CarportException extends AbstractException {
    private String origin = "carportSelectPage.jsp";

    public CarportException(String msg) {
        super(msg);
    }

    public CarportException(String origin, String message) {
        super(message);
        this.origin = origin;
    }
    
    

    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return origin;
    }

}
