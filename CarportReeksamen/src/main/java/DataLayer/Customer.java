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
public class Customer {
    
    private int customer_Id;
    private String name;
    private String email;
    private String address;
    private int zipCode;

    public Customer(int customer_Id, String username, String email, String address, int zipCode) {
        this.customer_Id = customer_Id;
        this.name = username;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }
    
}
