/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Dhono
 */
public class CalculatePrice {

    public int calculatePrice(
            
            int amountOfSternBoards, int amountOfPoles,
            int amountOfPlastmo, int amountOfRoofScrewPackages,
            int amountofShedBoards, int amountOfShedScrewPackages) {
        int totalPrice = amountOfSternBoards * 200 
                + amountOfPoles * 90 
                + amountOfPlastmo * 300 
                + amountOfRoofScrewPackages * 50 
                + amountofShedBoards * 75 
                + amountOfShedScrewPackages * 150;
        return totalPrice;
    }
}
