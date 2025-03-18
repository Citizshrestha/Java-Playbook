package Streams;

import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
       try(BufferedReader reader = new BufferedReader(new FileReader("citiz.txt"))) {

        String data;

        while((data = reader.readLine())!=null){
            System.out.println(data);
        }

       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
    }
}