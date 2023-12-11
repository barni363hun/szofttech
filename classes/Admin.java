package classes;

import java.util.Map;
import java.util.Scanner;

public class Admin extends User {

   public Admin(User user) {
      super(user);
   }

   public void AdminMenu(JsonHandler itemHandler, JsonHandler orderHandler, JsonHandler userHandler) {

        boolean exit = false;
        while (!exit) {
            Utils.printMenu("Admin", Map.of(
                    "1", "Termékek listázása",
                    "2", "Megrendelések listázása",
                    "3", "Felhasználók listázása",
                    "k", "Kilépés"));
            switch (Utils.getChar()) {
                case '1':
                    Item.printOutItems(Item.getAllItems(itemHandler));
                case '2':
                    Order.printOutOrders(Order.getAllOrders(orderHandler));
                    break;
                case '3':
                    User.printOutUsers(User.getAllUsers(userHandler));
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
   public static void makeItem(JsonHandler itemHandler) {

      System.out.print("Enter Item Name: ");
      String name = Utils.sc.next();

      System.out.print("Enter Item Price: ");
      int price = Utils.sc.nextInt();
      
      itemHandler.add(new Item(0,name,price)); // the id will be discarded
   }
   
   public static void makeUser(JsonHandler userHandler) {
  
      System.out.print("Enter User Name: ");
      String username = Utils.sc.next();
  
      System.out.print("Enter User Password: ");
      String password = Utils.sc.next();
  
      // Read User Type and validate
      boolean isValidUserType = false;
      char type = 'C';
      do {
          System.out.print("Enter User Type (C | A | V | D): ");
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
      userHandler.add(new User(0, username, password, type));
  }
  

}
