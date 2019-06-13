/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Exceptions.CarportException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frede
 */
public class CustomerMapperTest {
    private static Connection testConnection;    
    private static String URL = "jdbc:mysql://167.99.222.192:3306/CarportTest";
    private static final String USERNAME = "reader";
    private static final String PASSWORD = "something123";
    
    public CustomerMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() throws CarportException {
    }

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
         if (testConnection == null)
            {
                Class.forName("com.mysql.jdbc.Driver");
                testConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                DBConnector.setConnection(testConnection);
            }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createCustomer method, of class CustomerMapper.
     */
    @Test
    public void testCreateCustomer() throws Exception {
        System.out.println("createCustomer");
        String name = "testName";
        String email = "testEmail";
        String address = "testAddress";
        int zipcode = 0;
        String phonenumber = "testPhonenumber";
        CustomerMapper instance = new CustomerMapper();
        instance.createCustomer(name, email, address, zipcode, phonenumber);
        Customer customer = instance.getCustomer(email);
        assertEquals(customer.getName(), name);
        instance.deleteCustomer(customer.getCustomerId());
    }
    
    @Test (expected = CarportException.class)
    public void testCreateCustomerWithNullName() throws Exception {
        System.out.println("createCustomer");
        String name = null;
        String email = "testEmail";
        String address = "testAddress";
        int zipcode = 0;
        String phonenumber = "testPhonenumber";
        CustomerMapper instance = new CustomerMapper();
        instance.createCustomer(name, email, address, zipcode, phonenumber);
        Customer customer = instance.getCustomer(email);
        assertEquals(customer.getName(), name);
        instance.deleteCustomer(customer.getCustomerId());
    }

    /**
     * Test of getCustomerId method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomerId() throws Exception {
        System.out.println("getCustomerId");
        String name = "name";
        String email = "email";
        String address = "adresse";
        int zipcode = 1;
        String phonenumber = "phonenumber";
        Customer customer = new Customer(name, email, address, zipcode, phonenumber);
        CustomerMapper instance = new CustomerMapper();
        int expResult = 1;
        int result = instance.getCustomerId(customer);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomer method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        String email = "email";
        CustomerMapper instance = new CustomerMapper();
        int expResult = 1;
        int result = instance.getCustomer(email).getCustomerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerID method, of class CustomerMapper.
     */
    @Test
    public void testGetCustomerID() throws Exception {
        System.out.println("getCustomerID");
        int ID = 1;
        CustomerMapper instance = new CustomerMapper();
        String expResult = "name";
        String result = instance.getCustomerID(ID).getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of Customerlist method, of class CustomerMapper.
     */
    @Test
    public void testCustomerlist() throws Exception {
        System.out.println("Customerlist");
        CustomerMapper instance = new CustomerMapper();
        String expResult = "name";
        ArrayList<Customer> customers = instance.Customerlist();
        String result = customers.get(0).getName();
        assertEquals(expResult, result);
    }

}
