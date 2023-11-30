package classes;

import java.util.Map;

public class ViewUtils {
    
    static public char getChar() {
        while (true) {
            System.out.println("Adj meg egy karatert!");
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Ez nem egy karakter!");
            }
        }
    }

    static public void printMenu(String title, Map<String, String> menupoints) {
        System.out.println("====" + title + "====");
        if (menupoints.size() > 0) {
            for (Map.Entry<String, String> entry : menupoints.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("");
        }
    }
}
