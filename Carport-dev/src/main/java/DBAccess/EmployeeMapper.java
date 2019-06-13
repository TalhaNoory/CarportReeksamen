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

/**
 *
 * @author frede
 */
public class EmployeeMapper {
    
    public void createEmployee( Employee employee ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "insert into Employee (`Password`, Email, `Name`) values (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, employee.getPassword());
            ps.setString( 2, employee.getEmail());
            ps.setString( 3, employee.getName());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public Employee login( String email, String password ) throws CarportException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM Employee "
                    + "WHERE Email=? AND Password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String name = rs.getString( "Name" );
                int employeeId = rs.getInt("EmployeeID");
                boolean admin = rs.getBoolean("Admin");
                Employee employee = new Employee(employeeId, password, email, name, admin);
                return employee;
            } else {
                throw new CarportException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CarportException(ex.getMessage());
        }
    }
    
    public void deleteEmployee(int employeeId) throws CarportException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "delete from Employee where EmployeeID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, employeeId);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CarportException( ex.getMessage() );
        }
    }
    
    public Employee getEmployeeByID(int EmployeeID) throws CarportException{
        try{
             Connection con = DBConnector.connection();
             String SQL = "Select * FROM Employee WHERE EmployeeID = " + EmployeeID + ";";
             ResultSet rs = con.createStatement().executeQuery(SQL);
             if(rs.next()){
             return new Employee(rs.getString("password"), rs.getString("Email"), rs.getString("Name"));
             }else{
                throw new CarportException("Not Found");
                }
        }catch( SQLException | ClassNotFoundException ex ){
            throw new CarportException( ex.getMessage() );
        }
    }            
}
