package classes;

import java.util.Map;
import java.util.Scanner;

import classes.json.JsonHandler;

public class Admin extends User {

   public Admin(User user) {
      super(user);
   }

   public void AdminMenu(JsonHandler<Item> itemHandler, JsonHandler<Order> orderHandler, JsonHandler<User> userHandler) {

        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Admin", Map.of(
                    "1", "Termékek listázása",
                    "2", "Megrendelések listázása",
                    "3", "Felhasználók listázása",
                    "4", "Termék felvétele",
                    "5", "Felhasználó felvétele",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Utils.printMenu("Termékek", Map.of());
                    Item.printOutItems(itemHandler.list);
                    break;
                case '2':
                    Utils.printMenu("Megrendelések", Map.of());
                    Order.printOutOrders(orderHandler.list);
                    break;
                case '3':
                    Utils.printMenu("Felhasználók", Map.of());
                    User.printOutUsers(userHandler.list);
                    break;
                case '4':
                    makeItem(itemHandler);
                    break;
                case '5':
                    makeUser(userHandler);
                    break;
                case 'k':
                    exit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
                break;
            }
        }
   }

   // Static method to read data for Item
   public static void makeItem(JsonHandler<Item> itemHandler) {

      System.out.println("Enter Item Name: ");
      String name = Utils.sc.next();

      System.out.println("Enter Item Price: ");
      int price = Utils.sc.nextInt();
      
      itemHandler.list.add(new Item(itemHandler.getBiggestId()+1,name,price)); // the id will be discarded
      itemHandler.writeAllToJsonFile();
   }
   
   public static void makeUser(JsonHandler<User> userHandler) {
  
      System.out.println("Enter User Name: ");
      String username = Utils.sc.next();
  
      System.out.println("Enter User Password: ");
      String password = Utils.sc.next();
  
      // Read User Type and validate
      boolean isValidUserType = false;
      char type = 'C';
      do {
          System.out.println("Enter User Type (C | A | V | D): ");
          char userTypeInput = Utils.sc.next().charAt(0);
  
          // Validate user type
          if (userTypeInput == 'C' || userTypeInput == 'A' || userTypeInput == 'V' || userTypeInput == 'D') {
              type = userTypeInput;
              isValidUserType = true;
          } else {
              System.out.println("Invalid user type. Please enter C, A, V, or D.");
          }
      } while (!isValidUserType);
  
      // Assuming User class has a constructor that takes Object[]
      userHandler.list.add(new User(userHandler.getBiggestId()+1, username, password, type));
      userHandler.writeAllToJsonFile();
  }
  

}
