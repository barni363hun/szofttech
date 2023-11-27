package classes.roles;

import java.util.Scanner;

public class Warehouse extends Depot{

 Scanner sc = new Scanner(System.in);
private void warehouseMenu(){
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
        System.out.println("=====Warehouse=====");
        System.out.println("1. Csomagkovetes");
        System.out.println("2. Megrendelesek");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                 
        //(csomagAzon, "Futar");
                System.out.print("Csomagazonosito: ");
                String csomagAzon = sc.nextLine();
                order.track(csomagAzon,"Raktar");
                order.updateTrack();
                break;
            case "2":
                //item.listItems();
                break;
            default:
                break;
        }
        //(csomagAzon, "Futar");
    }
}
