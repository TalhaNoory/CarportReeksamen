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
public class Order {
    
    private int order_Id;
    private int employee_Id;
    private int customer_Id;
    private int material_Id;
    private int carportHeight;
    private int carportLength;
    private int carportWidth;
    private int shedLength;
    private int shedWidth;
    private int totalPrice;

    public Order(int order_Id, int employee_Id, int customer_Id, int material_Id, int height, int length, int width, int shedLength, int shedWidth, int totalPrice) {
        this.order_Id = order_Id;
        this.employee_Id = employee_Id;
        this.customer_Id = customer_Id;
        this.material_Id = material_Id;
        this.carportHeight = height;
        this.carportLength = length;
        this.carportWidth = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.totalPrice = totalPrice;
    }
    
    public Order(int employee_Id, int customer_Id, int material_Id, int height, int length, int width, int shedLength, int shedWidth, int totalPrice) {
        this.employee_Id = employee_Id;
        this.customer_Id = customer_Id;
        this.material_Id = material_Id;
        this.carportHeight = height;
        this.carportLength = length;
        this.carportWidth = width;
        this.shedLength = shedLength;
        this.shedWidth = shedWidth;
        this.totalPrice = totalPrice;
    }

    //Spørgsmål : Hvor skal vi sætte prisen inde i JSP'en, og hvordan skal metoden se ud?
    //Svar      : 
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public int getMaterial_Id() {
        return material_Id;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    
}
