/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dhono
 */
public abstract class Command {

    private static HashMap<String, PresentationLayer.Command> commands;

    private static void initCommands() {

        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("register", new CommandRegister());
//        commands.put("calculate", new CommandCalculateMaterials());
//        commands.put("createOrder", new CommandCreateOrder());
    }

    public static PresentationLayer.Command from(String commandKey) {
        if (commands == null) {
            initCommands();
        }
//        TODO check for illegal commandKey
        return commands.get(commandKey);
    }
    
    abstract String execute(HttpServletRequest request, HttpServletResponse response);
    
}
