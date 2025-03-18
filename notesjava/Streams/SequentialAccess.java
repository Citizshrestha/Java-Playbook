package Streams;

import java.io.*;

public class SequentialAccess {

    public static void main(String[] args) {
        String filename = "sequential.txt";
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write("This is example  of sequnetial file access \n");
            writer.write("This is line2 \n");
            writer.write("This is line3");

            writer.flush();

            writer.close();
            System.out.println("Data written successfully");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
           String data;
           
           
           while((data = reader.readLine())!= null){
            System.out.println(data);
           }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
