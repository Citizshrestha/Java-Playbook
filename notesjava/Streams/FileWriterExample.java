package Streams;



import java.io.*;

public class FileWriterExample {


    public static void main(String[] args) {
    String FileName = "file3.txt";

        try(FileWriter writer = new FileWriter(FileName)) {
            
           writer.write("Hey This is the example of FileWriter \n");
           writer.write("all good  \n");
           
           writer.flush();
           writer.close();
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("File Written to: "+FileName + " succesfully ");
    }
}
