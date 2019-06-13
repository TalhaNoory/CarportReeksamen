/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

import DBAccess.Material;
import FunctionLayer.LogicFacadeImplementation;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author frede
 */
public class CreateMaterialException extends AbstractException {

    private final String origin = "Materials.jsp";
    private final LogicFacadeImplementation logic = new LogicFacadeImplementation();

    public CreateMaterialException(String msg) {
        super(msg);
    }

    @Override
    public String handle(HttpServletRequest request) {
        try {
            ArrayList<Material> materials = logic.getAllMaterials();
            request.setAttribute("materials", materials);
        } catch (CarportException ex) {
            Logger.getLogger(CreateMaterialException.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("error", this.getMessage());
        return origin;
    }

}
