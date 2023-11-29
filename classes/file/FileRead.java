package classes.file;

import java.io.*;

import java.lang.*;

import java.util.*;

public class FileRead {

    public static final String token = "[,;]";

    static final String filePath = "data/database.";

    static final String fileExtension = ".csv";

    LinkedList<String> lineList = new LinkedList<>();

    public FileRead(String filename) {

        File data = new File(this.filePath + filename + this.fileExtension);

        if (data.exists()) {

            // System.out.println("Opening File: "+data.getName());

            // System.out.println("Path: "+data.getAbsolutePath());

        } else {

            System.out.println("File does not exist.");

        }

        try {
            BufferedReader inFile = new BufferedReader(new FileReader(data));
            String input = null;
            while ((input = inFile.readLine()) != null) {
                lineList.add(input);
            }
            System.out.println(data.getName() + " loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getListSize() {

        return lineList.size();

    }

    public LinkedList<String> getList() {

        return lineList;

    }

    public String getLine(int number) {

        return lineList.get(number);

    }

    public String[] splitLine(int number) {

        String[] splittedLine = lineList.get(number).split(this.token);

        return splittedLine;

    }

    public int splittedLineSize(String[] splittedLine) {

        return splittedLine.length;

    }

    public int getMaxElements() {

        int max_elements = 0;

        for (int i = 0; i < this.getListSize(); i++) {

            if (max_elements < this.splitLine(i).length) {

                max_elements = this.splitLine(i).length;

            }
        }
        return max_elements;

    }

    public String[][] getTable() {
        String[][] table = new String[this.getListSize()][this.getMaxElements()];

        String[] current_line;

        int elements_count;

        for (int i = 0; i < this.getListSize(); i++) {

            current_line = this.splitLine(i);

            elements_count = current_line.length;

            for (int j = 0; j < current_line.length; j++) {

                table[i][j] = current_line[j];

            }

        }

        return table;

    }

    public String[] getRow(int r) {

        String[] row = new String[this.getListSize()];

        for (int i = 0; i < this.getListSize(); i++) {

            row[i] = this.splitLine(i)[r];

        }

        return row;

    }

}