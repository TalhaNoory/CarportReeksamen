/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Exceptions.CarportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dhono
 */
public class OrderMapper {
    
    public void createOrder (Order order) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            //Spørgsmål : Er det iorden at min Foreign Keys, har samme navn som Primary Keys?           
            //Svar      : 
            String SQL = "insert into `Order` (employee_Id, customer_Id, material_Id, "
                    + " `carportHeight`, `carportWidth`, `carportLength`,"
                    + " `shedWidth`, `shedLength`, totalPrice) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getEmployee_Id());
            ps.setInt(2, order.getCustomer_Id());
            ps.setInt(3, order.getMaterial_Id());
            ps.setInt(4, order.getCarportHeight());
            ps.setInt(5, order.getCarportLength());
            ps.setInt(6, order.getCarportWidth());
            ps.setInt(7, order.getShedLength());
            ps.setInt(8, order.getShedWidth());
            ps.setInt(9, order.getTotalPrice());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    //Spørgsmål : Hvordan finder jeg ud af hvor det her skal være? i JSP'en          
    //Svar      : 
    public void setTotalPrice (int totalPrice, Order order) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "UPDATE `Order` SET `totalCost` = " + totalPrice + " WHERE OrderID = " + order.getOrder_Id() + ";";
            con.createStatement().execute(SQL);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
//    public Order getOrder (int orderId) throws CarportException {
//        try {
//            Connection con = DBConnector.connection();
//            String SQL = "select * from `Order` where OrderID = " + orderId + ";";
//            ResultSet rs = con.createStatement().executeQuery(SQL);
//            rs.next();
//            Order order = new Order(rs.getInt("order_Id"), 
//                    rs.getInt("employee_Id"),rs.getInt("material_Id"), rs.getInt("customer_Id"), 
//                    rs.getInt("carportHeight"), rs.getInt("carportLength"), rs.getInt("carportWidth"), 
//                    rs.getInt("shedLength"), rs.getInt("shedWidth"), rs.getInt("totalPrice"));
            
    
              //Spørgsmål   : hvordan bruger I OrderStatus, hvor henter I den henne?
              //Svar        :         
//            order.set
//        }
//    }
    
}
