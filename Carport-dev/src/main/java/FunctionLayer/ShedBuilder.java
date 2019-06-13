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
public class ShedBuilder {
    
  
    public int getTotalSurfaceLength(int shedLength, int shedWidth){
        return (shedLength+shedWidth)*2;
    }
    public int getNumberOfBoards(int shedSurface){
        double surface = shedSurface/6.0;
        if(surface%1 == 0){
            return (int)surface;
        }else{
            return (int)surface +1;
        }
    }
}
