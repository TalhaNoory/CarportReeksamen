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
public class CalculateRoof {

    //80*580, de skal overlappe hinanden
    //Plastmo pladerne er 100x600cm lange
    public int getAmountOfPlastmo(int carportWidth, int carportlength) {
        int plastmoSize = 80 * 580;
        //Jeg ganger bredden og længden så finder jeg frem til arealet af Carporten
        int roofArea = carportWidth * carportlength;
        int amountOfPlastmo = roofArea / plastmoSize;

        //The 5 added is if there should be any mistakes
        return amountOfPlastmo + 5;
    }
    
    public int getAmountOfScrewPackages (int amountOfPlastmoTiles) {
        int amountOfScrews = 50 * amountOfPlastmoTiles;
        int amountOfScrewPackages = amountOfScrews / 200 + 1;
        return amountOfScrewPackages;
    }
    
    //Jeg har valgt 1 slags stern, da alle carporte har fladt tag
    //Brædderne er 360cm lange
    public int getAmountOfSternBoards (int carportLength, int carportWidth) {
        
        //Her finder jeg frem til hvor lange de fire vægge er.
        int totalCoverLength = 2 * carportLength + 2 * carportWidth;
        //Her finder jeg ud af hvor mange brædder jeg skal bruge til de 4 vægge.
        int amountOfSternBoards = totalCoverLength / 360 + 1;
        return amountOfSternBoards;
    }
    
}
