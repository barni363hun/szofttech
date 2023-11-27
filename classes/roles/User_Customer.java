package classes.roles;
import java.util.Scanner;

import classes.Order;
import classes.classes_from_data.User;

public class User_Customer extends User{

    Scanner sc = new Scanner(System.in);
Order order = new Order();
private void customerMenu(){
        //menüpontok:
        //- add to cart
        //- remove from cart
        //- list itemsa
        System.out.println("=====Customer=====");
        System.out.println("1. Csomagkovetes");
        System.out.println("2. Rendeles");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                 
        //(csomagAzon, "Futar");
                System.out.print("Csomagazonosito: ");
                String csomagAzon = sc.nextLine();
                order.track(csomagAzon,"user");

                break;
            case "2":
                //item.listItems();
                System.out.println("=====Szallitasi adatok=====");
                System.out.println("Nev: ");
                String nev = sc.nextLine();
                System.out.println("Cim ");
                String cim = sc.nextLine();
                System.out.println("Telefonszam: ");
                String tel = sc.nextLine();
                order.makeTrackNum(nev, cim, tel);
                break;
            default:
                break;
        }

    }
}