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
public class CustomerMapper {
    
    public void createCustomer (String name, String email, String address, 
            int zipCode) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Customer (`name`, email, address, zipCode) values (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setInt(4, zipCode);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public Customer getCustomer(String email) throws CarportException {
        Customer c = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Customer` where email ='" + email + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                c = new Customer(rs.getInt("customer_Id"), rs.getString("name"), rs.getString("email"), rs.getString("address"), rs.getInt("zipCode"));
            }
            return c;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public int getCustomerId(Customer customer) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String email = customer.getEmail();
            String SQL = "select * from `Customer` where email ='" + email + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            rs.next();
            int customerId = rs.getInt("customer_Id");
            return customerId;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public Customer getCustomerByID(int ID)throws CarportException {
        Customer customer = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Customer` where customer_Id ='" + ID + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next() ) {
                customer = new Customer(
                        rs.getInt("customer_Id"), rs.getString("name"), 
                        rs.getString("email"), rs.getString("address"), 
                        rs.getInt("zipCode"));
            }
            return customer;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws CarportException{
        
        CustomerMapper cm = new CustomerMapper();
        Customer c = cm.getCustomerByID(1);
        System.out.println(c.getName());
        
        
    }
    
}
