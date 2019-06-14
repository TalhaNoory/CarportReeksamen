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

//Spørgsmål : Hvad er det der gør at den har nærmest samme mønster som Command?
//Svar      :
public abstract class AbstractExceptions extends Exception {
    
    public AbstractExceptions(String msg) {
        super(msg);
    }
    
    public abstract String handle(HttpServletRequest request);
    
}
