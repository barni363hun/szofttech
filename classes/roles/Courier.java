package classes.roles;

import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class Courier extends User{
    }
    Scanner sc = new Scanner(System.in);
 Order order = new Order();
private void Menu(){
        //menüpontok:
        //- megrendelés lekérdezés
        //  |- Sikeres / sikertelen kézbesítés
        System.out.println("=====Currier=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        //(csomagAzon, "Futar");
        order.track(csomagAzon,"Futar");
        order.updateTrack();
    }
}
