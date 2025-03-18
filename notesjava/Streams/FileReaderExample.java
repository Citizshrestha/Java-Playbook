package Streams;

import java.io.*;

public class FileReaderExample {
    private static final int EOF = -1;


    public static void main(String[] args) {
    String FileName = "file.txt";

        try(FileReader reader = new FileReader(FileName)) {
            
            int character;
            while((character = reader.read())!=EOF){
                System.out.print((char)character);
            }
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("File Read succesfully");
    }
}
