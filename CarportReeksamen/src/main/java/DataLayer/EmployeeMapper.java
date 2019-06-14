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
public class EmployeeMapper {
    
    //Spørgsmål : Efter hvilken rækkefølge følger man? Databasen, eller Class Employee
    //Svar      :
    public void createEmployee (Employee employee) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Employee (`Password`, Email, `Name`) values (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getEmail());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException( ex.getMessage());
        }
    }
    
    //Spørgsmål : Hvorfor bruger vi ikke "Statement.RETURN_GENERATED_KEYS" som ved createEmployee
    //Svar      :
    public Employee login (String email, String password) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from Employee "
                    + "where Email=? and Password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next() ) {
                //Spørgsmål : Her tjekker vi om det er en Admin, eller en Customer?
                //Svar      :                 
                String name = rs.getString("name");
                int employeeId = rs.getInt("EmployeeID");
                boolean admin = rs.getBoolean("Admin");
                Employee employee = new Employee(employeeId, email, name, password, admin);
                return employee;
            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException (ex.getMessage());
        }
    }
    
    //Skal have fundet ud af hvordan vi implementere ID'et på hjemmesiden    
    public Employee getEmployeeByID (int EmployeeID) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select * from Employee where EmployeeID = " + EmployeeID + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            if (rs.next() ) {
                return new Employee(rs.getString("email"), rs.getString("username"), rs.getString("password"));
            } else {
                throw new CarportException("Not Found");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
}
                
