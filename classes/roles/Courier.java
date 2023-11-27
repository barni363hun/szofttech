package classes.roles;

import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class Courier extends User {
    }

    public Courier(User u) {
        super(u);
        // TODO Auto-generated constructor stub
    }

    Scanner sc = new Scanner(System.in);
    Order order = new Order();

    static public static void Menu() {
        // menüpontok:
        // - megrendelés lekérdezés
        // |- Sikeres / sikertelen kézbesítés
        System.out.println("=====Courier=====");
        System.out.print("Csomagazonosito: ");
        String csomagAzon = sc.nextLine();
        // (csomagAzon, "Futar");
        order.track(csomagAzon, "Futar");
        order.updateTrack();
    }
}
