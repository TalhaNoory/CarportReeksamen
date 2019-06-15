/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.Customer;
import DataLayer.CustomerMapper;
import DataLayer.Employee;
import DataLayer.EmployeeMapper;
import DataLayer.Material;
import DataLayer.MaterialMapper;
import DataLayer.Order;
import DataLayer.OrderMapper;
import FunctionLayer.Exceptions.CarportException;
import java.util.ArrayList;

/**
 *
 * @author Dhono
 */

//Spørgsmål   : Hvorfor vil den ikke kører? udover at den vil have en interface :(    
//Svar        : 
public class LogicFacadeImplementation implements LogicFacade {

    //    -------------------- CustomerMapper -------------------------------
    
    @Override
    public void createCustomer(String name, String email, 
            String address, int zipCode) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
            cm.createCustomer(name, email, address, zipCode);
    }

    @Override
    public Customer getCustomer(String email) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        Customer c = cm.getCustomer(email);
        return c;
    }

    @Override
    public int getCustomerId(Customer customer) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        int customerId = cm.getCustomerId(customer);
        return customerId;
    }
    
    @Override
    public Customer getCustomerByID(int ID) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        Customer customer = cm.getCustomerByID(ID);
        return customer;
    }

    //    -------------------- EmployeeMapper -------------------------------
    
    @Override
    public Employee login(String email, String password) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.login(email, password);
        return employee;
    }

    @Override
    public Employee getEmployeeByID(int EmployeeID) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.getEmployeeByID(EmployeeID);
        return employee;
    }

    //    -------------------- MaterialMapper -------------------------------
    
    @Override
    public Material getMaterialByID(int materialId) throws CarportException {
        MaterialMapper mm = new MaterialMapper();
        Material m = mm.getMaterialByID(materialId);
        return m;
    }
    
    
    //    ---------------------- OrderMapper --------------------------------
    
    @Override
    public void createOrder(
            int employeeId, int customerId, 
            int carportHeight, int carportLength, int carportWidth, 
            int shedLength, int shedWidth, int totalPrice
    ) throws CarportException {
        
        OrderMapper om = new OrderMapper();
        om.createOrder(employeeId, customerId, 
                carportHeight, carportLength, carportWidth, 
                shedLength, shedWidth, totalPrice);
    }

    @Override
    public ArrayList<Order> getShowOrders() throws CarportException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> order = om.getShowOrders();
        return order;
    }


}
