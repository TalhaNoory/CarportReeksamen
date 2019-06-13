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
public abstract class AbstractException extends Exception {
    
    public AbstractException(String msg){
        super(msg);
    }
    
    public abstract String handle(HttpServletRequest request);
    
}
