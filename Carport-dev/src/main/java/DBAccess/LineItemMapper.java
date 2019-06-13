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
public class LineItemMapper {
    
    public void createLineItem(int materialId, int orderId, int qty, double length,
            double width, double height, String comment) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into LineItems (`Material_ID`, `OrderID`, `Qty`, length, width, height, Comments) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, materialId);
            ps.setInt(2, orderId);
            ps.setInt(3, qty);
            ps.setDouble(4, length);
            ps.setDouble(5, width);
            ps.setDouble(6, height);
            ps.setString(7, comment);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
   
     }   
         
     public ArrayList<LineItem> FullListofMaterial(int OrderID) throws CarportException{
         ArrayList<LineItem> LT = new ArrayList();
         try{
             Connection con = DBConnector.connection();
             String SQL = "select * from `LineItems` where OrderID ='" + OrderID + "';";
             ResultSet rs = con.createStatement().executeQuery(SQL);
             while(rs.next()){
                 LT.add(new LineItem(rs.getInt("LineItemsID"),rs.getInt("Material_ID"),rs.getInt("OrderID"),
                 rs.getInt("Qty"), rs.getDouble("length"),rs.getDouble("width"),rs.getDouble("height"),rs.getString("Comments")));
             }
         }catch(SQLException | ClassNotFoundException ex){
             throw new CarportException(ex.getMessage());
         }
         return LT;
     }
     
     
        public int getCustomerId(Customer customer) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String email = customer.getEmail();
            String SQL = "select * from `Customer` where Email ='" + email + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            int customerId = rs.getInt("CustomerID");
            return customerId;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
}

