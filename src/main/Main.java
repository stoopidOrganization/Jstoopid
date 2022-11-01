package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidKeywordException;
import exceptions.VariableNotFoundException;
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
        while (reader.hasNextLine()) lines.add(reader.nextLine());

        reader.close();
        
        // run the code
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] linepieces = line.split(" ");
            
            try {
                switch (linepieces[0]) {
                    /**
                     * Syntax:
                     * var {name} = {value}
                     */
                    case "var":
                        if (linepieces[2].equals("=")) varMan.newVariable(linepieces[1], Utils.getValue(Utils.combineArgs(linepieces, 3)));
                        break;
                    
                    /**
                     * Syntax:
                     * out {value}
                     */
                    case "out":
                        System.out.println(Utils.getValue(Utils.combineArgs(linepieces, 1).replaceAll("\"", "")));
                        break;
                    
                    /**
                     * Syntax:
                     * goto {line}
                     */
                    case "goto":
                        i = Integer.parseInt(linepieces[1]) - 2;
                        break;
                
                    default:
                        /**
                         * Check For Variable Change
                         * Syntax:
                         * {name} = {value}
                         */
                        if (linepieces.length > 1 && linepieces[1].equals("=")) {
                            if (varMan.isVariable(linepieces[0])) varMan.changeVariable(linepieces[0], Utils.getValue(Utils.combineArgs(linepieces, 2)));
                            else throw new VariableNotFoundException(linepieces[0]);
                        }

                        if (linepieces[0].equals("")) break;
                        else if (linepieces[0].startsWith("#")) break;

                        throw new InvalidKeywordException(linepieces[0]);
                }
            } catch (Exception e) {
                System.err.println("Your Script crashed in line " + i + ":\n\t" + e);
                return;
            }
        }
    }
}
