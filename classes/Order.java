package classes;
import java.util.*;
import java.io.*;
import java.nio.file.*;

import classes.classes_from_data.*;
import classes.file.FileRead;
import classes.roles.*;

public class Order {
    public User keeper;
    public Courier c;
    
    public static String csvLoc(){
         String csvFile = "D://softtech-backup/softtech/szofttech/data/database.parcell.csv";
         return csvFile;
    }

    public String getState(String id){
        //return state;
    }

    public static void track(String search, String setK) {
        // String csvFile = csvLoc();
        // String line = "";
        // String cvsSplitBy = ",";
       
        // //FileRead fileread = new FileRead("item");
        // try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        //     int i = 0;
        //     while ((line = br.readLine()) != null) {
        //         String[] row = line.split(cvsSplitBy);
        //         if (row[0].equals(search)) {
        //             if (setK != "Kezbesitve"){
        //             if (setK != "user"){
        //             System.out.println("====" + row[0] + " csomag====");
        //                 if (setK != "Depo"){
        //                     System.out.println("Cimzett: "+row[1]);
        //                     System.out.println("Elerhetoseg: "+row[3]);
        //                 }
        //                 System.out.println("Cim: "+row[2]);
        //             } else {
        //                 System.out.print("Csomag állapota/helyzete: ");
        //                 System.out.println(row[4]);
        //             }}
        //             if (setK != "" && setK != "user"){
        //                 setKeeper(setK, i);
                    
        //             }
        //             return;

        //         }
        //         i++;
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
 
    }
    public void setKeeper(Courier k) {
        keeper = k;
        
        // String csvFile = csvLoc();
        // String tempFile = "D://softtech-backup/softtech/szofttech/data/database.Tempparcell.csv";
        // String cvsSplitBy = ",";
      
        //        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
        //      PrintWriter pw = new PrintWriter(new File(tempFile))) {
        //     String line;
        //     int rowIndex = 0;
        //     while ((line = br.readLine()) != null) {
        //         List<String> row = new ArrayList<>(Arrays.asList(line.split(cvsSplitBy)));
        //         if (rowIndex == targetRow && row.size() >= 4) {
        //             row.set(4, keeper);
        //         }
        //         pw.println(String.join(cvsSplitBy, row));
        //         rowIndex++;
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // // Az ideiglenes fájl átnevezése az eredeti fájl nevére
        
    }
    public void updateTrack() {
        //  String csvFile = csvLoc();
        // String tempFile = "D://softtech-backup/softtech/szofttech/data/database.Tempparcell.csv";
        System.out.println("\n\n========\nCsomag allapota frissult\n========\n\n");

        // try {
        //     Files.move(Paths.get(tempFile), Paths.get(csvFile), StandardCopyOption.REPLACE_EXISTING);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    public static void makeTrackNum(String nev, String cim,String tel) {
        // String csvFile = csvLoc();
        // int id = 99;
      

        // try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        //     while (br.readLine() != null) {
        //         id++;
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
        //      String newLine = id + "," + nev + "," +  cim + "," + tel + ",Feldolgozas alatt";
        //     bw.newLine();
        //     bw.write(newLine);
        //     System.out.println("\n====Sikeres rendeles====\nCsomag azonositoja: "+ id + "\n");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    public static void listOrders(){
        // String csvFile = csvLoc();
        // String line = "";
        // String cvsSplitBy = ",";

        // try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        //         System.out.println("====Folyamatban levo rendelesek====");
        //     while ((line = br.readLine()) != null) {
        //       String[] row = line.split(cvsSplitBy);
        //       if (row[4].equals("Kezbesitve") || row[4].equals("currentLocation")){
        //         }else{
        //         System.out.println(row[0] + "-as szamu csomag itt: " + row[4]);
        //        }
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

}