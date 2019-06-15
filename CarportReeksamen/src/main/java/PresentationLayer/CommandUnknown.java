package PresentationLayer;

import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnknown extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) {
        request.setAttribute("error", "Unknown Command");
        return "/jsp/SelectMaterials.jsp";
    }

}
