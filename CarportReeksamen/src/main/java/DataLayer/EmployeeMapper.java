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
    
    //d.15-06
    //Spørgsmål : Hvorfor bruger vi ikke "Statement.RETURN_GENERATED_KEYS" som ved createEmployee
    //Svar      : I den her henter vi noget fra DB, hvorimod metode foroven, der putter vi noget ind i DB
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
                //Hvis den kører videre, henter den name og EmployeeID eller kører den "else"
                String name = rs.getString("username");
                int employeeId = rs.getInt("employee_Id");
                Employee employee = new Employee(employeeId, email, name, password);
                return employee;
            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException (ex.getMessage());
        }
    }
    
    //d.15-06
    //Skal have fundet ud af hvordan vi implementere ID'et på hjemmesiden    
    public Employee getEmployeeByID (int EmployeeID) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "Select * from Employee where EmployeeID = " + EmployeeID + ";";
            ResultSet rs = con.createStatement().executeQuery(SQL);
            if (rs.next() ) {
                //d.15-06
                // Samme princip som med linje 49 metoden foroven!
                return new Employee(rs.getInt("employee_Id"), rs.getString("email"), rs.getString("username"), rs.getString("password"));
            } else {
                throw new CarportException("Not Found");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }
    
}
                
