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
    
    private int customer_id;
    private String username;
    private String email;
    private String address;
    private int zipCode;

    public Customer(int customer_id, String username, String email, String address, int zipCode) {
        this.customer_id = customer_id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getUsername() {
        return username;
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
