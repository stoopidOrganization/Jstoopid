package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import variables.VariableManager;

/**
 * Main class of the Project
 */
public class Main {
    /**
     * Name of the File to be executed
     */
    public static String filename;
    /**
     * cache for all lines of the file
     */
    public static ArrayList<String> lines;
    /**
     * Manages all Variables
     */
    public static variables.VariableManager varMan;

    public static void main(String[] args) {
        varMan = new VariableManager();
        lines = new ArrayList<>();

        // Get Filename from arguments
        try {
            filename = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No file Found --- using default option for debugging");
            filename = "test.jstpd";
        }

        // load file
        Scanner reader;
        try {
            File file = new File(filename);
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find a file with the name " + filename);
            return;
        }

        // cache the code
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }

        // run the code
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] linepieces = line.split(" ");

            switch (linepieces[0]) {
                case "var":
                    if (linepieces[2].equals("=")) {
                        varMan.newVariable(linepieces[1], linepieces[3]);
                    }
                    break;

                case "out":
                    System.out.println(varMan.getVariable(linepieces[1]));
                    break;

                case "goto":
                    i = Integer.parseInt(linepieces[1]) - 2;
                    break;
            
                default:
                    break;
            }
        }
        
        reader.close();
    }
}
