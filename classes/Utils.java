package classes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Utils {

    public static Scanner sc = new Scanner(System.in);
    
    public static char getChar() {
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

    public static void printMenu(String title, Map<String, String> menupoints) {
        System.out.println("====" + title + "====");
        if (menupoints.size() > 0) {
            for (Map.Entry<String, String> entry : menupoints.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("");
        }
    }

    //TODO ez mehet át a JsonHandler-be?
    // public static <T> Object[] transformsToObjArr(T obj) {
    //     if (obj == null) {
    //         return null; // or throw an exception, depending on your requirements
    //     }
    //     Field[] fields = obj.getClass().getDeclaredFields();
    //     List<Object> objList = new ArrayList<>();

    //     try {
    //         for (Field field : fields) {
    //             field.setAccessible(true);
    //             Object value = field.get(obj);
    //             objList.add(value);
    //         }
    //     } catch (IllegalAccessException e) {
    //         e.printStackTrace(); // Handle the exception based on your needs
    //     }

    //     return objList.toArray();
    // }

}
