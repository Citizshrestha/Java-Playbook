package Streams;

import java.io.*;

public class CopyFile {
    private static final int EOF = -1;
    public static void main(String[] args) {
        try {
            copyFile("file.txt","file4.txt");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    static void copyFile(String sourceFile,String desFile){
      
        try {
            FileReader reader = new FileReader(sourceFile);
            FileWriter writer = new FileWriter(desFile);

            int len;
            while ((len = reader.read())!=EOF) {
                writer.write(len);
            }
            writer.flush();
            writer.close();
            reader.close();
            System.out.println("Data copied from: "+sourceFile + " to "+desFile);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
