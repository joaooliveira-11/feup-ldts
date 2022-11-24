package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map_Reader {
    private File file;
    private Scanner scanner;

    public ArrayList<String> MAP1_READER() throws FileNotFoundException {
        ArrayList<String> map1lines = new ArrayList<>();
        file = new File("level1.txt");
        scanner = new Scanner(file);
        String line = "";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            map1lines.add(line);
        }
        return map1lines;
    }
}
