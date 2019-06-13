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
public class Material {
    private int materialId;
    private String name;
    private int msrp;
    private int costPrice;

    public Material(int materialId, String name, int msrp, int costPrice) {
        this.materialId = materialId;
        this.name = name;
        this.msrp = msrp;
        this.costPrice = costPrice;
    }

    public Material(String name, int msrp, int costPrice) {
        this.name = name;
        this.msrp = msrp;
        this.costPrice = costPrice;
    }

    public int getMaterialId() {
        return materialId;
    }

    public String getName() {
        return name;
    }

    public int getMsrp() {
        return msrp;
    }

    public int getCostPrice() {
        return costPrice;
    }
}
