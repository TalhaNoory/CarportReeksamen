/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Exceptions.CarportException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dhono
 */
public class MaterialMapper {
    
    //d.15-06
    //Spørgsmål : Hvordan laver jeg en Exception til denne her class?
    //Svar      : jeg holder mig til CarportException, som virker fint. 
    
    public Material getMaterialByID(int materialId) throws CarportException {
        Material m = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material` where material_Id ='" + materialId + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                m = new Material(rs.getInt("material_Id"), rs.getString("name"), rs.getInt("costPrice"));
            }
            return m;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
}
