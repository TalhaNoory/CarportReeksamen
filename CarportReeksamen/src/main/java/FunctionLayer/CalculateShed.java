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
public class CalculateShed {
    
    public int getAmountofBoards(int shedLength, int shedWidth) {
        
        //Den totale længde for skuret 4 vægge.
        int totalCoverLength = 2 * shedLength + 2 * shedWidth;
        //Fordi hver brædt dækker 6cm, jeg lægger 5 til så man har råd til fejl.
        int amountOfBoards = totalCoverLength / 6 + 5;
        return amountOfBoards;
    }
    
    public int getAmountOfScrewPackages(int amountOfBoards) {
        
        //400 er de antal skruer der er i pakken
        //Jeg har vurderet at man skal bruge 10 skruer pr brædt.
        int amountOfScrews = 10 * amountOfBoards;
        int amountOfScrewPackages = amountOfScrews / 400 + 1;
        return amountOfScrewPackages;
    }
    
}
