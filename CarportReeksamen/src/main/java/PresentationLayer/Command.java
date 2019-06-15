/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.AbstractExceptions;
import FunctionLayer.LogicFacade;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dhono
 */
public abstract class Command  {

    private static HashMap<String, PresentationLayer.Command> commands;

    private static void initCommands() {

        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("createOrder", new CommandCreateOrder());
//        commands.put("calculate", new CommandCalculateMaterials());
    }

    public static PresentationLayer.Command from(String commandKey) {
        if (commands == null) {
            initCommands();
        }
//        TODO check for illegal commandKey
        return commands.get(commandKey);
    }
    
    //d.17-06
    //Spørgsmål : Hvorfor kører man kun requests her?
    //Svar      :
    abstract String execute(HttpServletRequest request, LogicFacade logic) throws AbstractExceptions;
    
}
