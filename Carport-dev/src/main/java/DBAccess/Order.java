/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

/**
 *
 * @author frede
 */
public class Order {
    private int orderId;
    private int employeeId;
    private int customerId;
    private int carportHeight;
    private int carportWidth;
    private int carportLength;
    private String roofType;
    private int roofAngle;
    private int shedWidth;
    private int shedLength;
    private String customerComment;
    private int totalCost;
    private int totalSale;
    private String status;

    public Order(int orderId, int employeeId, int customerId, int carportHeight, int carportWidth, int carportLength, String roofType, int roofAngle, int shedWidth, int shedLength, String customerComment, int totalCost, int totalSale, String status) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.carportHeight = carportHeight;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roofType = roofType;
        this.roofAngle = roofAngle;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.customerComment = customerComment;
        this.totalCost = totalCost;
        this.totalSale = totalSale;
        this.status = status;
    }

    public Order(int employeeId, int customerId, int carportHeight, int carportWidth, int carportLength, String roofType, int roofAngle, int shedWidth, int shedLength, String customerComment, int totalCost, int totalSale) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.carportHeight = carportHeight;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.roofType = roofType;
        this.roofAngle = roofAngle;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.customerComment = customerComment;
        this.totalCost = totalCost;
        this.totalSale = totalSale;
    }
    
    public void setTotalSale(int totalSale){
        this.totalSale = totalSale;
    }
    
    public void setTotalCost(int totalCost){
        this.totalCost = totalCost;
    }
    
    public int getTotalSale() {
        return totalSale;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public String getRoofType() {
        return roofType;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String Status){
        this.status = Status;
    }
}
