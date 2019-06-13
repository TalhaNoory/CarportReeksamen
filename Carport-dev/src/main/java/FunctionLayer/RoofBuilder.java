/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author frede
 */
public class RoofBuilder {
    
    public Double getRafterSideLength(int carportWidth, int roofAngle){
        //+15 pga 15cm tagudhæng i hver side af carporten
        int katete = carportWidth/2+15;
        double hypotenuse = katete/Math.cos(Math.toRadians(roofAngle));
        return hypotenuse;
    }
    
    public Double getRoofArea(int carportLength, int carportWidth, int roofAngle){
        double hypotenuse = getRafterSideLength(carportWidth, roofAngle);
        //+60 fordi taget skal have et 30cm udhæng på gavlene i hver ende
        double roofArea = (carportLength+60)*hypotenuse*2;
        return roofArea;
    }
    
    // en plade plastmo er 100x600 men overlapper 20cm på begge led
    public int getAmountOfPlastmo(int area){
        int PlastmoSize = 80*580;
        int amountOfPlastmo = area/PlastmoSize;
        
        // giver en extra med, så der er plads til fejl
        return amountOfPlastmo + 1;
    }
    
    public int getAmountOfRoofTiles(int roofArea){
        //tager udgangspunkt i Højslev Vingetegl (ikke dem fog bruger)
        //målene på teglene er 40,5cm i længden og 24,7cm i bredden, men de overlapper hinanden
        int roofTileCoverLength = 33;
        int roofTileCoverWidth = 22;
        int coverArea = roofTileCoverLength*roofTileCoverWidth;
        int tileAmount;
        //hvis tileAmount ikke bliver et helt tal ligge vi en tile til, så resten ikke bare bliver skåret af
        if (roofArea%coverArea == 0){
         tileAmount = roofArea/coverArea;           
        }
        else {
            tileAmount = roofArea/coverArea +1;
        }
        return tileAmount;
    }
    //rygningssten på dansk
    //tager udgangspunkt i "Ny Højslev rygningssten"
    //rygningsstenene har en længde på 38 cm, men de overlapper hinanden
    public int getAmountOfRidgeTiles(int roofLength){
        int coverLength = 33;
        int ridgetileAmount;
        if (roofLength%coverLength == 0){   
        ridgetileAmount = roofLength/coverLength;
        }
        else {
        ridgetileAmount = roofLength/coverLength + 1;
        }
        return ridgetileAmount;
    }
    
    //base height på alle carporte er 225cm
    public Double getCarportHeight(int carportWidth, int roofAngle){
        double hypotenuse = getRafterSideLength(carportWidth, roofAngle);
        double height = Math.sin(Math.toRadians(roofAngle))*hypotenuse+225;
        return height;
    }
}
