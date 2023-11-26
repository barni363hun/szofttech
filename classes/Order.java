package classes;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import classes.file.FileRead;

public class Order {
    

    public static void track(String search, String setK) {
        String csvFile = "D://softtech/szofttech/data/database.parcell.csv";
        String line = "";
        String cvsSplitBy = ",";
       
        //FileRead fileread = new FileRead("item");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                if (row[0].equals(search)) {
                    if (setK != "user"){
                    System.out.println(line);
                    } else {
                        System.out.print("Itt a csomag: ");
                        System.out.println(row[3]);
                    }
                    if (setK != "" && setK != "user"){
                        setKeeper(setK, i);
                    }
                    return;

                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    public static void setKeeper(String keeper, int targetRow) {
        String csvFile = "D://softtech/szofttech/data/database.parcell.csv";
        String tempFile = "D://softtech/szofttech/data/database.tempParcell.csv";
        String cvsSplitBy = ",";
      
               try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             PrintWriter pw = new PrintWriter(new File(tempFile))) {
            String line;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                List<String> row = new ArrayList<>(Arrays.asList(line.split(cvsSplitBy)));
                if (rowIndex == targetRow && row.size() >= 4) {
                    row.set(3, keeper);
                }
                pw.println(String.join(cvsSplitBy, row));
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Az ideiglenes fájl átnevezése az eredeti fájl nevére
        
    }
    public static void updateTrack() {
         String csvFile = "D://softtech/szofttech/data/database.parcell.csv";
        String tempFile = "D://softtech/szofttech/data/database.tempParcell.csv";

        try {
            Files.move(Paths.get(tempFile), Paths.get(csvFile), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}