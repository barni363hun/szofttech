package classes;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    public static Scanner sc = new Scanner(System.in);
    
    public static char getChar() {
        while (true) {
            System.out.println("Adj meg egy karaktert!");
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Ez nem egy karaktert!");
            }
        }
    }

    public static void printMenu(String title, Map<String, String> menupoints) {
        System.out.println("====" + title + "====");
        if (menupoints.size() > 0) {
            for (Map.Entry<String, String> entry : menupoints.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("");
        }
    }

    public static String getTime(){
        // Get the current date and time
        LocalDateTime localDateTime = LocalDateTime.now();

        // Format the date and time using a specific pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);

        System.out.println("Timestamp created: " + formattedDateTime);

        // If you also want to include the time zone information
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String formattedZonedDateTime = zonedDateTime.format(formatter);

        return formattedZonedDateTime;
    }

}
