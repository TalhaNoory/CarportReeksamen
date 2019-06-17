/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Exceptions.CarportException;
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
        commands.put("showOrders", new CommandShowOrders());
        commands.put("selectMeasurements", new CommandSelectMeasurements());
    }

    public static PresentationLayer.Command from(String commandKey) {
        if (commands == null) {
            initCommands();
        }
//        TODO check for illegal commandKey
        return commands.get(commandKey);
    }
    
    //Her gemmer jeg ting i requesten i de forskellige Command's execute og så henter jeg det ud af request på JSP siderne
    //Hvilket betyder at når execute metoden i en commands bliver kørt, så skal den have en request med!
    abstract String execute(HttpServletRequest request, LogicFacade logic) throws CarportException;
    
}
