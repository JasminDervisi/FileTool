import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTool {

    public static String promptFilename() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        return scanner.nextLine();
    }

    public static String promptTextInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type: ");
        return scanner.nextLine();
    }

    public static void createFile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file);
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filename, ArrayList<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            for (String item : list) {
                fileWriter.write(item + "\n");
            }
            fileWriter.close();
            System.out.println("Successfully wrote to: " + filename);
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filename, String data) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(data + "\n");
            fileWriter.close();
            System.out.println("Successfully wrote to: " + filename);
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
