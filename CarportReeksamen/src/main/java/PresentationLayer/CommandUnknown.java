package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnknown extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("error", "Unknown Command");
        return "/jsp/SelectMaterials.jsp";
    }

}
