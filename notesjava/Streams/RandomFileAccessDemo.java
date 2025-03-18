package Streams;

import java.io.*;

public class RandomFileAccessDemo {
    public static void main(String[] args) {
        String fileName = "random.txt";

        // Writing data
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            long pos1 = raf.getFilePointer(); // Start of first string (0)
            raf.writeUTF("First Line of RAF \n");
            long pos2 = raf.getFilePointer(); // After first string
            raf.writeUTF("Second Line of RAF\n");
            long pos3 = raf.getFilePointer(); // After second string x
            raf.writeUTF("Third Line of RAF\n");

            System.out.println("Data written successfully to: " + fileName);

            // Reading data using tracked positions
            raf.seek(pos1); // Seek to start of first string
            System.out.println("First: " + raf.readUTF());

            raf.seek(pos2); // Seek to start of second string
            System.out.println("Second: " + raf.readUTF());

            raf.seek(pos3); // Seek to start of third string
            System.out.println("Third: " + raf.readUTF());

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}