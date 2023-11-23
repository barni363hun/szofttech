import java.util.Scanner;

public class TransportApp {
    
    Scanner sc;
    Customer[] customerList;
    User currentUser;
    // customerList
    // User currentUser=null;

    public TransportApp() {
        sc = new Scanner(System.in);
    }

    // public TransportApp(FileManager fileManager) {
    //     fileManager.getUsers()
    //     fileManager.getCustomers()
    // }

    public void startMenu(){
    // select your role...
    // Enter your User Name:
    // ha kell akkor pwd
    System.out.print("Type in your role:");    
    System.out.print("customer / admin / courier / depot");

    String role = sc.nextLine();
    if (roleCheck(role)) {
        if(role != "customer"){
            System.out.print("Input your username");
            String username = sc.nextLine();
            if (login(username)) {
                switch (role) {
                    case "customer":
                        currentUser = user
                        adminMenu();
                        break;
                    case "admin":
                        // currentUser = ...
                        adminMenu();
                        break;
                    default:
                        break;
                }
            }

        }
    } else {
        System.out.println("User found!");
    }
    System.out.print("Enter your User Name: ");
    }

    private boolean login(String username) {
        return false;
    }
    private boolean roleCheck(String role) {
        return true;
    }

    private customerMenu(){
        //menüpontok:
        //- add to cart
        //- remove from cart
        //- list items

    }
    
    public void adminMenu(){
        //...
    }
}
