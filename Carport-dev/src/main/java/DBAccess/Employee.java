/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

/**
 *
 * @author frede
 */
public class Employee {

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", password=" + password + ", email=" + email + ", name=" + name + ", admin=" + admin + '}';
    }
    private int employeeId;
    private String password;
    private String email;
    private String name;
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public Employee(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
    }
    
    public Employee(int employeeId, String password, String email, String name, boolean admin) {
        this.employeeId = employeeId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.admin = admin;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
