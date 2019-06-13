/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Exceptions.CarportException;

/**
 *
 * @author frede
 */
public class PoleBuilder {
    
    public double getDistanceBetweenPoles(int length) throws CarportException{
        if (length <= 19.4) throw new CarportException("carport length is too short to place poles");
        //usefullLength er længde - bredden på den første stolpe
        double usefullLength = length - 9.7;
        //usefullLength divideres med 210 fordi minimum mellemrum mellem stolper er 200cm og hver stolpe er 10 cm brede
        Double numberOfPoles = usefullLength / 209.7;
        //-10 til sidst for at fjerne stolpernes bredde, så vi sidder tilbage med bredden mellem stolperne
        double spaceBetweenPoles = usefullLength / numberOfPoles.intValue() - 9.7;
        return spaceBetweenPoles;
    }
    
    public int getAmountOfPoles(int carportLength) throws CarportException{
        //man dividere længden med 209.7 fordi der minimum skal være 200cm mellem hver stolpe og stolperne i sig selv er 9.7cm
        //man ligger 1 til fordi den ikke tager højde for at side skal starte med en stople
        //man ganger med 2 for at få antal stolper for begge sider af carporten
        Double amountOfPolesForOneSide = ((carportLength-9.7)/209.7)+1;
        int amountOfPoles = amountOfPolesForOneSide.intValue()*2;
        return amountOfPoles;
    }
}
