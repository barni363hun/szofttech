package classes.roles;

import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class Depot extends User{
    }
    Scanner sc = new Scanner(System.in);
    Order order = new Order();
private void depotMenu(){
        //menüpontok:
        //- Csomaglekerdezes
        //- Statuszmodositas
        System.out.println("=====Depo=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        //(csomagAzon, "Futar");
        order.track(csomagAzon,"Depo");
        order.updateTrack();

    }
}
