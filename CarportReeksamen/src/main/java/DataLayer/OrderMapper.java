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
import java.util.ArrayList;

/**
 *
 * @author Dhono
 */
public class OrderMapper {

    public void createOrder(int employeeId, int customerId,
            int carportHeight, int carportLength, int carportWidth,
            int shedLength, int shedWidth, int totalPrice) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            //d.15-06
            //Spørgsmål : Er det iorden at min Foreign Keys, har samme navn som Primary Keys?           
            //Svar      : Det er helt fint
            String SQL = "insert into `Order` (employee_Id, customer_Id, "
                    + " `carportHeight`, `carportLength`, `carportWidth`,"
                    + " `shedLength`, `shedWidth`, totalPrice) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, employeeId);
            ps.setInt(2, customerId);
            ps.setInt(3, carportHeight);
            ps.setInt(4, carportLength);
            ps.setInt(5, carportWidth);
            ps.setInt(6, shedLength);
            ps.setInt(7, shedWidth);
            ps.setInt(8, totalPrice);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public Order getOrderByID(int orderId) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where OrderID = " + orderId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Order order = new Order(
                    rs.getInt("order_Id"), rs.getInt("employee_Id"), rs.getInt("customer_Id"),
                    rs.getInt("carportHeight"), rs.getInt("carportLength"), rs.getInt("carportWidth"),
                    rs.getInt("shedLength"), rs.getInt("shedWidth"), rs.getInt("totalPrice"));
            return order;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }        
    }
    
    public ArrayList<Order> getShowOrders() throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order`;";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next() ) {
                Order order = new Order(
                    rs.getInt("order_Id"), rs.getInt("employee_Id"), rs.getInt("customer_Id"),
                    rs.getInt("carportHeight"), rs.getInt("carportLength"), rs.getInt("carportWidth"),
                    rs.getInt("shedLength"), rs.getInt("shedWidth"), rs.getInt("totalPrice"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
}
