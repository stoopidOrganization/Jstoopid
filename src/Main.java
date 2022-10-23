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
            System.out.println(line);
        }

        reader.close();
    }
}
