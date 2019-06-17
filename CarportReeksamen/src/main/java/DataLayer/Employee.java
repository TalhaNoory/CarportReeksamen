/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

/**
 *
 * @author Dhono
 */
public class Employee {
    
    private int employee_Id;
    private String email;
    private String username;
    private String password;
    
    public Employee(int employee_Id, String email, String username, String password) {
        this.employee_Id = employee_Id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
