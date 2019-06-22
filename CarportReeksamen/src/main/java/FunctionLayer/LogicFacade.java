/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.Customer;
import DataLayer.Employee;
import DataLayer.Material;
import DataLayer.Order;
import FunctionLayer.Exceptions.CarportException;
import FunctionLayer.Exceptions.LoginException;
import java.util.ArrayList;

/**
 *
 * @author Dhono
 */
public interface LogicFacade { 
    
//    -------------------- CustomerMapper -------------------------------
    
    void createCustomer (String name, String email, String address, 
            int zipCode) throws CarportException;
    
    Customer getCustomer(String email) throws CarportException;
    
    int getCustomerId(Customer customer) throws CarportException;
    
    Customer getCustomerByID(int ID)throws CarportException;
    
//    -------------------- EmployeeMapper -------------------------------
        
    Employee login (String email, String password) throws LoginException;
    
    Employee getEmployeeByID (int EmployeeID) throws CarportException;
    
//    -------------------- MaterialMapper -------------------------------
    
    Material getMaterialByID(int materialId) throws CarportException;

    ArrayList<Material> getAllMaterials()throws CarportException;
    
//    ---------------------- OrderMapper --------------------------------
    
    void createOrder (
            int employeeId, int customerId, 
            int carportHeight, int carportLength, int carportWidth, 
            int shedLength, int shedWidth, int totalPrice
    ) throws CarportException;
    
    ArrayList<Order> getOrders() throws CarportException;
    
}
