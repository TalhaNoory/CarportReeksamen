/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.Exceptions.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dhono
 */
public class EmployeeMapper {
    
    public Employee login (String email, String password) throws LoginException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from Employee "
                    + "where Email=? and Password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next() ) {
                //Hvis den kører videre, henter den name og EmployeeID ellers kører den "else"
                String name = rs.getString("username");
                int employeeId = rs.getInt("employee_Id");
                Employee employee = new Employee(employeeId, email, name, password);
                return employee;
            } else {
                throw new LoginException("Could not validate user");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginException (ex.getMessage());
        }
    }
    
    public Employee getEmployeeByID (int ID) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select * from Employee where employee_Id = " + ID + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            if (rs.next() ) {
                // Samme princip som med linje 49 metoden foroven!
                return new Employee(rs.getInt("employee_Id"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
            } else {
                throw new CarportException("Employee Not Found");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws LoginException, CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee e = em.getEmployeeByID(1);
        System.out.println(e.getUsername());
    }
    
}
                
