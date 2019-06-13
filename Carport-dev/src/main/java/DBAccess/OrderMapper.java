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
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author frede
 */
public class OrderMapper {

    public void createOrder(Order order) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into `Order` (EmployeeID, CustomerID, `carport-height`, `carport-width`,"
                    + " `carport-length`, rooftype, roofangle, `shed-width`, `shed-length`, CustomerComment, totalCost,"
                    + " TotalSale, Status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getEmployeeId());
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getCarportHeight());
            ps.setInt(4, order.getCarportWidth());
            ps.setInt(5, order.getCarportLength());
            ps.setString(6, order.getRoofType());
            ps.setInt(7, order.getRoofAngle());
            ps.setInt(8, order.getShedWidth());
            ps.setInt(9, order.getShedLength());
            ps.setString(10, order.getCustomerComment());
            ps.setInt(11, order.getTotalCost());
            ps.setInt(12, order.getTotalSale());
            ps.setString(13, order.getStatus());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public ArrayList<Order> getAllOrders() throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order`;";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Order o = new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                        rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                        rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                        rs.getInt("TotalSale"), rs.getString("Status"));
                o.setStatus(rs.getString("OrderStatus"));
                orders.add(o);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public Order getPremadeOrder(int premadeId) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where premadeID = " + premadeId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Order order = new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                    rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                    rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                    rs.getInt("TotalSale"), rs.getString("Status"));
            order.setStatus(rs.getString("OrderStatus"));
            return order;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public void setTotalSalesPrice(int TotalSalesPrice, Order o) throws CarportException{
        try{
             Connection con = DBConnector.connection();
             String SQL = "UPDATE `Order` SET `TotalSale` = " + TotalSalesPrice + " WHERE OrderID = " + o.getOrderId() + ";";
             con.createStatement().execute(SQL);
        }catch(SQLException | ClassNotFoundException ex){
            throw new CarportException(ex.getMessage());
        }
    }
    
        public void setTotalCostPrice(int TotalCostPrice, Order o) throws CarportException{
        try{
             Connection con = DBConnector.connection();
             String SQL = "UPDATE `Order` SET `totalCost` = " + TotalCostPrice + " WHERE OrderID = " + o.getOrderId() + ";";
             con.createStatement().execute(SQL);
        }catch(SQLException | ClassNotFoundException ex){
            throw new CarportException(ex.getMessage());
        }
    }
        
    public void setOrderStatus(String status, Order o) throws CarportException{
        try{
             Connection con = DBConnector.connection();
             String SQL = "UPDATE `Order` SET `OrderStatus` = \" "+ status + "\" WHERE OrderID = " + o.getOrderId() + ";";
             con.createStatement().execute(SQL);
        }catch(SQLException | ClassNotFoundException ex){
            throw new CarportException(ex.getMessage());
        }
    }    
    
    public ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where customerID=" + customerId + ";";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Order o = new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                        rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                        rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                        rs.getInt("TotalSale"), rs.getString("Status"));
                o.setStatus(rs.getString("OrderStatus"));
                orders.add(o);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public Order getOrder(int orderId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Order` where OrderID = " + orderId + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            Order order = new Order(rs.getInt("OrderID"), rs.getInt("EmployeeID"), rs.getInt("CustomerID"), rs.getInt("carport-height"),
                    rs.getInt("carport-width"), rs.getInt("carport-length"), rs.getString("rooftype"), rs.getInt("roofangle"),
                    rs.getInt("shed-width"), rs.getInt("shed-length"), rs.getString("CustomerComment"), rs.getInt("totalCost"),
                    rs.getInt("TotalSale"), rs.getString("Status"));
            order.setStatus(rs.getString("OrderStatus"));
               
            return order;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public Order getNewestOrder() throws CarportException {
        ArrayList<Order> orders = getAllOrders();
        Order order = orders.get(0);
        for (Order o : orders) {
            if (o.getOrderId() > order.getOrderId()) order = o;
        }
        return order;
    }
}
