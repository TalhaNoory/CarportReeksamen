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

    public int getAmountOfPlastmo(int cover) {
        int plastmoSize = 100 * 600;
        int amountOfPlastmo = cover / plastmoSize;

        //The 5 added is if there should be any mistakes
        return amountOfPlastmo + 5;
    }
}
