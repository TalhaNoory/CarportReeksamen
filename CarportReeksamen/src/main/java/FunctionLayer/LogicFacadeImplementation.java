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
import DataLayer.Order;
import DataLayer.OrderMapper;
import FunctionLayer.Exceptions.CarportException;

/**
 *
 * @author Dhono
 */

//Spørgsmål   : Hvorfor vil den ikke kører? udover at den vil have en interface :(    
//Svar        : 
public class LogicFacadeImplementation implements LogicFacade {

    //    -------------------- CustomerMapper -------------------------------
    
    @Override
    public boolean createCustomer(String name, String email, 
            String address, int zipCode) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        try {
            cm.createCustomer(name, email, address, zipCode);
            return true;
        } catch (CarportException ex) {
            return false;
        }
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

    //    -------------------- EmployeeMapper -------------------------------
    
    @Override
    public Employee createEmployee(String email, String username, String password) throws CarportException {
        Employee employee = new Employee(email, username, password);
        EmployeeMapper em = new EmployeeMapper();
        em.createEmployee(employee);
        return employee;
    }

    @Override
    public Employee login(String email, String password) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.login(email, password);
        em.createEmployee(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeByID(int EmployeeID) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.getEmployeeByID(EmployeeID);
        return employee;
    }

    //    -------------------- MaterialMapper -------------------------------
    
    //    TOMT!!!
    //    Skal lige have fundet ud af hvad jeg gør med CreateMaterialException Class
    
    //    ---------------------- OrderMapper --------------------------------
    
    @Override
    public Order createOrder(
            int employeeId, int customerId, int materialId, 
            int carportHeight, int carportLength, int carportWidth, 
            int shedLength, int shedWidth, int totalPrice
    ) throws CarportException {
        Order order = new Order(
                employeeId, customerId, materialId, 
                carportHeight, carportLength, carportWidth, 
                shedLength, shedWidth, totalPrice);
        OrderMapper om = new OrderMapper();
        om.createOrder(order);
        return order;
    }

    //Spørgsmål   :     
    //Svar        :   
    @Override
    public int setTotalPrice(int totalPrice, Order order) throws CarportException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
