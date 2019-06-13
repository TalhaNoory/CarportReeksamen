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
public class CarportMalcBuilder {

    MaterialCalc mc = new MaterialCalc();
    LogicFacade lf = new LogicFacadeImplementation();
    int BeslagSkruer;
    int x45x50mm;
    int x45x70mm;
    int PlastmoSkruer;

    public void BuildItemList(Order o) throws CarportException {
        mc.BuildDoor(o);
        mc.BuildPoles(o);

        // returnere først antal beslagskruer, bagefter antal 4,5x50mm skruer og til sidst 4,5x70mm skruer.
        if (!(o.getShedWidth() == 0)) {
            int[] BlandetSkruer = mc.buildShed(o);
            BeslagSkruer += BlandetSkruer[0];
            x45x50mm += BlandetSkruer[1];
            x45x70mm += BlandetSkruer[2];
        }

        if (!(o.getRoofType().equals("fladt"))) {
            //returnere antal 4,5x50mm skruer og 4,5x70mm skruer.
            int[] BlandetSkruer2 = mc.buildGable(o);
            x45x50mm += BlandetSkruer2[0];
            x45x70mm += BlandetSkruer2[1];

            mc.GetTiles(o);

            //amountofPremadeRafters
            int amountofPremadeRafters = mc.buildTriangle(o);

            //Returnere antal beslagskruer til at montere lægter på spær.
            BeslagSkruer += mc.buildAngleRoofStructure(o, amountofPremadeRafters);
        } else {
            mc.buildFlatRoofStructure(o);
            int plader = mc.buildFlatRoof(o);
            int amountofRafters = o.getCarportLength() / 100;

            // 1 skruer pr 3cm
            PlastmoSkruer += amountofRafters * (o.getCarportLength() / 3);

            if (PlastmoSkruer / 200 == 0) {
                lf.createLineItem(30, o.getOrderId(), 1, 0, 0, 0, "Skruer til tagplader");
            } else {
                lf.createLineItem(30, o.getOrderId(), PlastmoSkruer / 200 + 1, 0, 0, 0, "Skruer til tagplader");

            }
        }

        //Udregner alle pakker med skruer
        if (!(BeslagSkruer == 0)) {
            if (BeslagSkruer / 250 == 0) {
                lf.createLineItem(21, o.getOrderId(), 1, 0, 0, 0, "Til montering af universalbeslag + toplægte");
            } else {
                lf.createLineItem(21, o.getOrderId(), BeslagSkruer / 250 + 1, 0, 0, 0, "Til montering af universalbeslag + toplægte");
            }
        }
        if (!(x45x50mm == 0)) {
            if (x45x50mm / 350 == 0) {
                lf.createLineItem(25, o.getOrderId(), 1, 0, 0, 0, "til montering af inderste bræt ved beklædning");
            } else {
                lf.createLineItem(25, o.getOrderId(), x45x50mm / 350 + 1, 0, 0, 0, "til montering af inderste bræt ved beklædning");
            }
        }
        if (!(x45x70mm == 0)) {
            if (x45x70mm / 250 == 0) {
                lf.createLineItem(26, o.getOrderId(), 1, 0, 0, 0, "til montering af inderste bræt ved beklædning");
            } else {
                lf.createLineItem(26, o.getOrderId(), x45x70mm / 250 + 1, 0, 0, 0, "til montering af inderste bræt ved beklædning");
            }
        }

    }
}
