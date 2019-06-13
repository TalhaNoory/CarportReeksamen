/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;


import FunctionLayer.Exceptions.CarportException;
import DBAccess.Order;

/**
 *
 * @author frederik
 */
public class MaterialCalc {
    LogicFacade lf = new LogicFacadeImplementation();
    RoofBuilder rb = new RoofBuilder();
    PoleBuilder pb = new PoleBuilder();
    ShedBuilder sb = new ShedBuilder();
    
    public void BuildPoles (Order o) throws CarportException{ 
        lf.createLineItem(4, o.getOrderId(), pb.getAmountOfPoles(o.getCarportLength()), 300, 0, 0, "Stolper til carport");
        lf.createLineItem(5, o.getOrderId(), 2, o.getCarportLength(), 0, 0, "Remme til siderne");
        lf.createLineItem(23, o.getOrderId(), pb.getAmountOfPoles(o.getCarportLength())*2, 0, 0, 0, "Bolt til Rem på stolper");
        lf.createLineItem(24, o.getOrderId(), pb.getAmountOfPoles(o.getCarportLength())*2, 0, 0, 0, "Skive til bolt");  
    }
    
    public void BuildDoor(Order o) throws CarportException{
        lf.createLineItem(28,o.getOrderId(), 1, 540, 0, 0, "til z på bagside af dør");
        lf.createLineItem(17, o.getOrderId(), 1, 0, 0, 0, "til dør i skur");
        lf.createLineItem(18, o.getOrderId(), 2, 0, 0, 0, "til dør i skur");
    }
    
    public void GetTiles(Order o) throws CarportException{
        double area = rb.getRoofArea(o.getCarportLength(), o.getCarportWidth(), o.getRoofAngle());
        int amountTiles = rb.getAmountOfRoofTiles((int) area);
        lf.createLineItem(10, o.getOrderId(), amountTiles, 0, 0, 0, "monteres på taglægter");
        lf.createLineItem(11, o.getOrderId(), rb.getAmountOfRidgeTiles(o.getCarportLength()), 0, 0, 0, "monteres på toplægte");
        lf.createLineItem(13, o.getOrderId(), rb.getAmountOfRidgeTiles(o.getCarportLength()), 0, 0, 0, "Til montering af rygsten");
    }
    
    public int[] buildShed(Order o) throws CarportException{
        int area = sb.getTotalSurfaceLength(o.getShedLength(), o.getShedWidth());
        int amountofBoards = sb.getNumberOfBoards(area);
        int surface = (o.getShedWidth()*o.getShedLength())*2;
        lf.createLineItem(7, o.getOrderId(), amountofBoards, 210, 0, 0, "Beklædning til skur");
        lf.createLineItem(6, o.getOrderId(), 6, o.getShedLength(), 0, 0, "Løsholter til længden");
        lf.createLineItem(6, o.getOrderId(), 6, o.getShedWidth(), 0, 0, "Løsholter til bredde");
        lf.createLineItem(19, o.getOrderId(), 24, 0, 0, 0, "Vinkelbeslag til løsholter");
        lf.createLineItem(4, o.getOrderId(), 4, 300, 0, 0, "Stolper til skur");
        lf.createLineItem(23, o.getOrderId(), 4*2, 0, 0, 0, "Bolt til Rem på stolper");
        lf.createLineItem(24, o.getOrderId(), 4*2, 0, 0, 0, "Skive til bolt");
        // returnere først antal beslagskruer, bagefter antal 4,5x50mm skruer og til sidst 4,5x70mm skruer.
        int[] skruer ={24 * 8, ((amountofBoards/2)*3), ((amountofBoards/2)*6)};
        return skruer;
    }
    
    public int buildAngleRoofStructure(Order o, int amountofPremadeRafters) throws CarportException{
        double sidelength = rb.getRafterSideLength(o.getCarportLength(), o.getRoofAngle());
        int actualLength = (int)sidelength +1;
        int amountofRafters = actualLength/30;
        lf.createLineItem(9, o.getOrderId(), amountofRafters, o.getCarportLength(), 0, 0, "Lægter");
        lf.createLineItem(9, o.getOrderId(), 1, o.getCarportLength(), 0, 0, "toplægte til montering af rygsten ");
        lf.createLineItem(12, o.getOrderId(), amountofRafters, 0, 0, 0, "toplægteholder");
        lf.createLineItem(3, o.getOrderId(), 2, o.getCarportLength(), 0, 0, "Sternbrædder til siderne Carport");
        lf.createLineItem(3, o.getOrderId(), 2, o.getCarportLength(), 0, 0, "Vindskeder på rejsning");
        //Returnere antal beslagskruer til at montere lægter på spær.
        int skruer = amountofRafters * amountofPremadeRafters;
        return skruer;
    }
    
    public int buildTriangle(Order o) throws CarportException{
        int amountofPremadeRafters = o.getCarportLength()/100;
        lf.createLineItem(35, o.getOrderId(), amountofPremadeRafters, 0, 0, 0, "byg-selv spær (skal samles)");
        lf.createLineItem(15, o.getOrderId(), amountofPremadeRafters*2, 0, 0, 0, "Til montering af spær på rem");
        lf.createLineItem(15, o.getOrderId(), amountofPremadeRafters*2, 0, 0, 0, "Til montering af spær på rem");
        return amountofPremadeRafters;
    }
    
    public int[] buildGable(Order o) throws CarportException{
        int surfaceLength = o.getCarportWidth()*2;
        int amountofBoards = sb.getNumberOfBoards(surfaceLength);
        lf.createLineItem(7, o.getOrderId(), amountofBoards, 240, 0, 0, "beklædning af gavle 1 på 2");
        //returnere antal 4,5x50mm skruer og 4,5x70mm skruer.
        int[] skruer = {((amountofBoards/2)*3), ((amountofBoards/2)*6)};
        return skruer;
    }
    
    public int buildFlatRoof(Order o) throws CarportException{
        int area = (o.getCarportLength()) * (o.getCarportWidth());
        int amountOfPlastmo = rb.getAmountOfPlastmo(area);
        lf.createLineItem(29, o.getOrderId(), amountOfPlastmo , 600, 100, 0, "tagplader monteres på spær");
        return amountOfPlastmo;
    }
    
    public void buildFlatRoofStructure(Order o) throws CarportException{
       int amountofRafters = o.getCarportLength()/100;
       lf.createLineItem(5, o.getOrderId(), amountofRafters, 0, 0, 0, "");
       lf.createLineItem(50, o.getOrderId(), 4, o.getCarportWidth()+30, 0, 0, "understernbrædder til for & bag ende");
       lf.createLineItem(50, o.getOrderId(), 4, o.getCarportLength()+30, 0, 0, "understernbrædder til siderne");
       lf.createLineItem(51, o.getOrderId(), 2, o.getCarportWidth(), 0, 0, "oversternbrædder til forenden");
       lf.createLineItem(51, o.getOrderId(), 4, o.getCarportWidth(), 0, 0, "oversternbrædder til siderne");
       int skruer = amountofRafters * 10;
       if (skruer / 200 == 0) {
            lf.createLineItem(25, o.getOrderId(), 1, 0, 0, 0, "til montering af stern & spær");
        } else {
            lf.createLineItem(25, o.getOrderId(), skruer / 200 + 1, 0, 0, 0, "til montering af stern & spær");
        }
    }
}


