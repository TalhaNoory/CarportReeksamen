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
import java.util.ArrayList;

/**
 *
 * @author Dhono
 */
public class MaterialMapper {

    public Material getMaterialByID(int materialId) throws CarportException {
        Material m = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material` where material_Id ='" + materialId + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                m = new Material(
                        rs.getInt("material_Id"),
                        rs.getString("name"),
                        rs.getInt("costPrice"));
            }
            return m;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public ArrayList<Material> getAllMaterials() throws CarportException {
        try {
            ArrayList<Material> m = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material`;";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                m.add(new Material(
                        rs.getInt("material_Id"),
                        rs.getString("name"),
                        rs.getInt("costPrice")));
            }
            return m;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }

    }

    public static void main(String[] args) throws CarportException {
        MaterialMapper mm = new MaterialMapper();
//        ArrayList<Material> materials = mm.getAllMaterials();
//        System.out.println(materials.get(0));
//        Material m = mm.getMaterialByID(2);
//        System.out.println(m);

    }

}
