package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map_Reader {
    private File file;
    private Scanner scanner;

    public void MAP1_READER() throws FileNotFoundException {
        file = new File("level1.txt");
        scanner = new Scanner(file);
        String line = "";
        //while(scanner.hasNextLine()){}
    }
}
