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
            String SQL = "insert into Customer (`name`, Email, Adresse, Zipcode, Phonenumber) values (?, ?, ?, ?);";
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
            String SQL = "select * from `Customer` where Email ='" + email + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                c = new Customer(rs.getString("name"), rs.getString("Email"), rs.getString("Adresse"), rs.getInt("Zipcode"));
            }
            return c;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    //Spørgsmål : Find ud af hvordan det foregår på hjemmesiden
    //Svar      : 
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
