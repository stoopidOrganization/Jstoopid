import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String filename;

    public static void main(String[] args) {
        try {
            filename = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No file Found --- using default option for debugging");
            filename = "test.jstpd";
        }

        Scanner reader;

        try {
            File file = new File(filename);
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find a file with the name " + filename);
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            String[] linepieces = line.split(" ");

            switch (linepieces[0]) {
                case "var":
                    if (lib.isNumber(linepieces[3])) {
                        System.out.println("Variable is a number");
                    } else if (lib.isBool(linepieces[3])) {
                        System.out.println("Variable is a boolean");
                    } else {
                        System.out.println("Variable is a string");
                    }
                    break;

                case "out":
                    System.out.println("print statement");
                    break;
            
                default:
                    break;
            }
        }

        reader.close();
    }
}
