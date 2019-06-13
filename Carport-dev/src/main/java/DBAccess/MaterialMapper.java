/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Exceptions.CarportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class MaterialMapper {
    
    public Material getMaterial(int materialId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material` where Material_ID = " + materialId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Material material = new Material(rs.getInt("Material_ID"), rs.getString("Name"), rs.getInt("MSRP"), rs.getInt("costPrice"));
            return material;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public ArrayList<Material> getAllMaterials() throws CarportException{
        try {
            ArrayList<Material> materials = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "select * from `Material`;";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()){
                materials.add(new Material(rs.getInt("Material_ID"), rs.getString("Name"), rs.getInt("MSRP"), rs.getInt("costPrice")));
            }
            return materials;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public void createMaterial( Material material ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Material (`Name`, MSRP, `costPrice`) values (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, material.getName());
            ps.setInt( 2, material.getMsrp());
            ps.setInt( 3, material.getCostPrice());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public void editMaterial(int materialId, String newName, int newMSRP, int newCostPrice) throws CarportException{
        try {
            getMaterial(materialId);
        } catch (CarportException ex){
            throw new CarportException("The material you are trying to edit does not exist");
        }
        try {
            Connection con = DBConnector.connection();
            String SQL = "update Material set `Name`=?, MSRP=?, `costPrice`=? where `Material_ID`="+materialId+";";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, newName);
            ps.setInt( 2, newMSRP);
            ps.setInt( 3, newCostPrice);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public Material getNewestMaterial() throws CarportException{
        ArrayList<Material> materials = getAllMaterials();
        Material material = materials.get(0);
        for (Material m : materials) {
            if (m.getMaterialId() > material.getMaterialId()) material = m;
        }
        return material;
    }
    
    public void deleteMaterial(int materialId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "delete from Material where Material_ID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, materialId);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
}
