package classes.roles;

import java.util.Scanner;

public class Warehouse extends Depot {

    private void warehouseMenu() {
        // menüpontok:
        // - megrendelés lekérdezés
        // |- Sikeres / sikertelen kézbesítés
        System.out.println("=====Warehouse=====");
        System.out.println("1. Csomagkovetes");
        System.out.println("2. Megrendelesek");
        String menupont = sc.next();
        switch (menupont) {
            case "1":

                // (csomagAzon, "Futar");
                System.out.print("Csomagazonosito: ");
                String csomagAzon = sc.next();
                order.track(csomagAzon, "Raktar");
                order.updateTrack();
                break;
            case "2":
                // item.listItems();
                break;
            default:
                break;
        }
        // (csomagAzon, "Futar");
    }
}
