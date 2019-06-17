/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;

/**
 *
 * @author Dhono
 */
public class CalculatePoles {
    
    public double getPoleDistance(int length)throws CarportException {
    //Width of the first pole
    double validLength = length - 9.7;
    //validLength is then divide with 210 because,
    //the distance between each pole is 200cm and each pole is 10 cm wide.
    Double amountOfPoles = validLength /209.7;
    //I then withdraw 10 from the number to remove the pole from the width, 
    //so I am left with the width between the poles.
    double distanceOfThePoles = validLength / amountOfPoles.intValue() - 9.7;
    return distanceOfThePoles;
    }
    
    public int getAmountOfPoles(int carportLength) throws CarportException {
    /* Here i divide the length(200) with 209.7 because the distance between each pole is 200 cm, and the width of the pole itself is 9.7
       I add 1 to it, because it doesnt take notice that it needs to start with 1 pole 
       Crucial: I multiply with 2 to get the amount of poles on each side of the Carport */
    
    Double amountPolesForOneSideOnly =((carportLength - 9.7) / 209.7) +1 ;
    int amountOfPoles = amountPolesForOneSideOnly.intValue() * 2;
    return amountOfPoles;
    }
}
