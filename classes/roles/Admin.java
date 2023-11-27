package classes.roles;

import java.util.Scanner;

import classes.classes_from_data.User;

public class Admin extends User {
    }

    private void adminMenu() {
        System.out.println("=====Admin=====");
        System.out.println("1. Megrenelesek");
        System.out.println("2. Termeklista");
        System.out.println("3. Termek hozzaad");
        System.out.println("4. Termek torol");
        String menupont = sc.nextLine();
        switch (menupont) {
            case "1":
                // listMegrendelesek();
                break;
            case "2":
                // i.listItems();
                break;
            case "3":
                // addItem();
                break;
            case "4":
                System.out.print("IemId: ");
                int itemId = Integer.parseInt(sc.nextLine());
                // removeItem(itemId);
                break;
            default:
                break;
        }
    }
}
