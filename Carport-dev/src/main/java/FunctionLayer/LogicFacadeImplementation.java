/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;
import DBAccess.Customer;
import DBAccess.CustomerMapper;
import DBAccess.Employee;
import DBAccess.EmployeeMapper;
import DBAccess.LineItem;
import DBAccess.LineItemMapper;
import DBAccess.Material;
import DBAccess.MaterialMapper;
import DBAccess.Order;
import DBAccess.OrderMapper;
import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class LogicFacadeImplementation implements LogicFacade {

    @Override
    public Order createOrder(int employeeId, int customerId,
            int carportHeight, int carportWidth, int carportLength,
            String roofType, int roofAngle,
            int shedWidth, int shedLength,
            String customerComment, int totalCost, int totalSale) throws CarportException {
        Order order = new Order(employeeId, customerId,
                carportHeight, carportWidth, carportLength,
                roofType, roofAngle,
                shedWidth, shedLength,
                customerComment, totalCost, totalSale);
        OrderMapper om = new OrderMapper();
        om.createOrder(order);
        return order;
    }

    @Override
    public Order getOrder(int orderId) throws CarportException {
        OrderMapper om = new OrderMapper();
        Order order = om.getOrder(orderId);
        return order;
    }

    @Override
    public ArrayList<Order> getAllOrders() throws CarportException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> orders = om.getAllOrders();
        return orders;
    }

    @Override
    public Order getPremadeOrder(int orderId) throws CarportException {
        OrderMapper om = new OrderMapper();
        Order order = om.getPremadeOrder(orderId);
        return order;
    }
    
    @Override
    public Order getNewestOrder() throws CarportException{
        OrderMapper om = new OrderMapper();
        Order order = om.getNewestOrder();
        return order;
    }

    @Override
    public boolean createCustomer(String name, String email, String address,
            int zipcode, String phonenumber) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        try {
            cm.createCustomer(name, email, address, zipcode, phonenumber);
            return true;
        } catch (CarportException ex) {
            return false;
        }
    }

    @Override
    public int getCustomerId(Customer customer) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        int customerId = cm.getCustomerId(customer);
        return customerId;
    }

    @Override
    public Employee createEmployee(String password, String email, String name) throws CarportException {
        Employee employee = new Employee(password, email, name);
        EmployeeMapper em = new EmployeeMapper();
        em.createEmployee(employee);
        return employee;
    }

    @Override
    public Employee login(String email, String password) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee employee = em.login(email, password);
        return employee;
    }

    @Override
    public ArrayList<Customer> Customerlist() throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        ArrayList<Customer> CL = cm.Customerlist();
        return CL;

    }

    @Override
    public Customer getCustomer(String email) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        Customer c = cm.getCustomer(email);
        return c;
    }

    @Override
    public Customer getCustomerID(int ID) throws CarportException {
        CustomerMapper cm = new CustomerMapper();
        Customer c = cm.getCustomerID(ID);
        return c;
    }

    @Override
    public Material getMaterial(int materialId) throws CarportException {
        MaterialMapper mm = new MaterialMapper();
        Material material = mm.getMaterial(materialId);
        return material;
    }
    
    @Override
    public ArrayList<Material> getAllMaterials() throws CarportException{
        MaterialMapper mm = new MaterialMapper();
        ArrayList<Material> materials = mm.getAllMaterials();
        return materials;
    }
    
    @Override
    public void createMaterial( Material material ) throws CarportException{
        MaterialMapper mm = new MaterialMapper();
        mm.createMaterial(material);
    }
    
    @Override
    public void editMaterial(int materialId, String newName, int newMSRP, int newCostPrice) throws CarportException{
        MaterialMapper mm = new MaterialMapper();
        mm.editMaterial(materialId, newName, newMSRP, newCostPrice);
    }

    @Override
    public ArrayList<Order> getOrdersFromCustomer(int customerId) throws CarportException {
        OrderMapper om = new OrderMapper();
        ArrayList<Order> OfC = om.getOrdersFromCustomer(customerId);
        return OfC;
    }

    @Override
    public void createLineItem(int materialId, int orderId, int qty, double length,
            double width, double height, String comment) throws CarportException {
        LineItemMapper lim = new LineItemMapper();
        lim.createLineItem(materialId, orderId, qty, length, width, height, comment);
    }
    @Override
    public ArrayList<LineItem> getFullListofMaterial (int OrderID) throws CarportException{
        LineItemMapper lim = new LineItemMapper();
        ArrayList<LineItem> LT = new ArrayList();
        LT = lim.FullListofMaterial(OrderID);
        return LT;
    }
    @Override
    public void createMaterialList(Order o) throws CarportException{
        CarportMalcBuilder cmb = new CarportMalcBuilder();
        cmb.BuildItemList(o);
        
    }

    @Override
    public Material getNewestMaterial() throws CarportException {
        MaterialMapper mm = new MaterialMapper();
        Material m = mm.getNewestMaterial();
        return m;
    }

    @Override
    public int setTotalCostPrice(ArrayList<LineItem> LT, Order o) throws CarportException {
        int TotalCostPrice = 0;
        MaterialMapper mm = new MaterialMapper();
        OrderMapper om = new OrderMapper();
        for(LineItem LI : LT){
            Material m = mm.getMaterial(LI.getMaterialId());
            TotalCostPrice += m.getMsrp() * LI.getQty();
        }
        om.setTotalCostPrice(TotalCostPrice, o);
        return TotalCostPrice;
    }

    @Override
    public int setTotalSalePrice(ArrayList<LineItem> LT, Order o) throws CarportException {
        int TotalSalesPrice = 0;
        MaterialMapper mm = new MaterialMapper();
        OrderMapper om = new OrderMapper();
        for(LineItem LI : LT){
            Material m = mm.getMaterial(LI.getMaterialId());
            TotalSalesPrice += m.getCostPrice() * LI.getQty();
        }
        om.setTotalSalesPrice(TotalSalesPrice, o);
        return TotalSalesPrice;
    }

    @Override
    public Employee getEmployeeByID(int EmployeeID) throws CarportException {
        EmployeeMapper em = new EmployeeMapper();
        Employee Employee = em.getEmployeeByID(EmployeeID);
        return Employee;
    }
    
    @Override
    public void deleteMaterial(int materialId) throws CarportException {
        MaterialMapper mm = new MaterialMapper();
        mm.deleteMaterial(materialId);
    }

    @Override
    public void setOrderStatus(String status, Order o) throws CarportException {
       OrderMapper om = new OrderMapper();
       om.setOrderStatus(status, o);
    }

}
