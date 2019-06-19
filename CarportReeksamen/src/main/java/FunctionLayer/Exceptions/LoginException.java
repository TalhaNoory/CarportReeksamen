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
public class LoginException extends AbstractException{
    
    //Target er den side man skal hen til når LoginException bliver kastet -> LoginOrRegister
    private String target = "LoginOrRegister.jsp";
    
    public LoginException(String msg) {
        super(msg);
    }
    
    public LoginException (String target, String message) {
        super(message);
        this.target = target;
    }

    public String handle(HttpServletRequest request) {
        request.setAttribute("error", this.getMessage());
        return target;
    }
    
}