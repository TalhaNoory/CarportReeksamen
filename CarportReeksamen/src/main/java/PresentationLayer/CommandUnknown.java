package PresentationLayer;

import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

public class CommandUnknown extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws CarportException{
        request.setAttribute("error", "Unknown Command");
        return "SelectMaterials.jsp";
    }

}
