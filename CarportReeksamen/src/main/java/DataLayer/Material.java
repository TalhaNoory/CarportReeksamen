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
public class Material {
    
    private int material_Id;
    private String name;
    private int costPrice;

    public Material(int material_Id, String name, int costPrice) {
        this.material_Id = material_Id;
        this.name = name;
        this.costPrice = costPrice;
    }
    
    public Material(String name, int costPrice) {
        this.name = name;
        this.costPrice = costPrice;
    }
    

    public int getMaterial_Id() {
        return material_Id;
    }

    public String getName() {
        return name;
    }

    public int getCostPrice() {
        return costPrice;
    }
    
}
