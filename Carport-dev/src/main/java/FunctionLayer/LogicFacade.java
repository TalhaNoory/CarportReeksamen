/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;
import DBAccess.Customer;
import DBAccess.Employee;
import DBAccess.LineItem;
import DBAccess.Material;
import DBAccess.Order;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public interface LogicFacade {

    Order createOrder(
            int employeeId, int customerId,
            int carportHeight, int carportWidth, int carportLength,
            String roofType, int roofAngle,
            int shedWidth, int shedLength,
            String customerComment, int totalCost, int totalSale) throws CarportException;

    Order getOrder(int orderId) throws CarportException;

    ArrayList<Order> getAllOrders() throws CarportException;

    Order getPremadeOrder(int orderId) throws CarportException;
    
    Order getNewestOrder()throws CarportException;

    boolean createCustomer(String name, String email, String address,
            int zipcode, String phonenumber) throws CarportException;

    int getCustomerId(Customer customer) throws CarportException;

    Employee createEmployee(String password, String email, String name) throws CarportException;

    Employee login(String email, String password) throws CarportException;

    ArrayList<Customer> Customerlist() throws CarportException;

    Customer getCustomer(String email) throws CarportException;

    public Customer getCustomerID(int ID) throws CarportException;

    Material getMaterial(int materialId) throws CarportException;
    
    void createMaterial( Material material ) throws CarportException;
    
    void editMaterial(int materialId, String newName, int newMSRP, int newCostPrice) throws CarportException;
    
    ArrayList<Material> getAllMaterials() throws CarportException;

    ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException;
   
    void createLineItem(int materialId, int orderId, int qty, double length, double width, double height, String comment)throws CarportException;
            
    ArrayList<LineItem> getFullListofMaterial (int OrderID) throws CarportException;
    
     void createMaterialList(Order o) throws CarportException;
     
     Material getNewestMaterial() throws CarportException;
     
     int setTotalCostPrice(ArrayList<LineItem> LT, Order o) throws CarportException;
     
     int setTotalSalePrice(ArrayList<LineItem> LT, Order o) throws CarportException;
     
     Employee getEmployeeByID(int EmployeeID) throws CarportException;
     
     void deleteMaterial(int materialId) throws CarportException;
     
     void setOrderStatus(String status, Order o) throws CarportException;
}
