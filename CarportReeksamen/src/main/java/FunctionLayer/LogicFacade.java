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

/**
 *
 * @author Dhono
 */
public interface LogicFacade {
    
      //Spørgsmål   : Hvorfor kører vi ikke public her?/Hvorfor Boolean ved createrCustomer?    
      //Svar        :    
    
//    -------------------- CustomerMapper -------------------------------
    
    void createCustomer (String name, String email, String address, 
            int zipCode) throws CarportException;
    
    Customer getCustomer(String email) throws CarportException;
    
    int getCustomerId(Customer customer) throws CarportException;
    
//    -------------------- EmployeeMapper -------------------------------
        
    Employee login (String email, String password) throws CarportException;
    
    Employee getEmployeeByID (int EmployeeID) throws CarportException;
    
//    -------------------- MaterialMapper -------------------------------
    
    Material getMaterialByID(int materialId) throws CarportException;
    
//    ---------------------- OrderMapper --------------------------------
    
    void createOrder (
            int employeeId, int customerId, 
            int carportHeight, int carportLength, int carportWidth, 
            int shedLength, int shedWidth, int totalPrice
    ) throws CarportException;
    
}
