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
public class CustomerMapper {

    public void createCustomer(String name, String email, String address,
            int zipcode, String phonenumber) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Customer (`name`, Email, Adresse, Zipcode, Phonenumber) values (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setInt(4, zipcode);
            ps.setString(5, phonenumber);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
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

    public Customer getCustomer(String email) throws CarportException {
        Customer c = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Customer` where Email ='" + email + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                c = new Customer(rs.getString("name"), rs.getString("Email"), rs.getString("Adresse"), rs.getInt("Zipcode"), rs.getString("Phonenumber"), rs.getInt("CustomerID"));
            }
            return c;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public Customer getCustomerID(int ID) throws CarportException {
        Customer c = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `Customer` where CustomerID ='" + ID + "';";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                c = new Customer(rs.getString("name"), rs.getString("Email"), rs.getString("Adresse"), rs.getInt("Zipcode"), rs.getString("Phonenumber"), rs.getInt("CustomerID"));
            }
            return c;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public ArrayList<Customer> Customerlist() throws CarportException {
        ArrayList<Customer> Customerlist = new ArrayList();
        try {
            Connection con = DBConnector.connection();
            String query = "select * from `Customer`;";
            ResultSet rs = con.createStatement().executeQuery(query);
            while (rs.next()) {
                Customer c = new Customer(rs.getString("name"), rs.getString("Email"), rs.getString("Adresse"), rs.getInt("Zipcode"), rs.getString("Phonenumber"), rs.getInt("CustomerID"));
                Customerlist.add(c);
            }
            return Customerlist;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public void deleteCustomer(int customerId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "delete from Customer where CustomerID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, customerId);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
}
