package Streams;

import java.io.*;

public class PrintWriterExample {
    public static void main(String[] args) {
        File file = new File("output.txt");

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Hello, this is a PrintWriter Example");
            writer.print("Current year: ");
            writer.println(2025); // Prints an integer
            writer.printf("Formatted number: %.2f%n", 123.456); // Formatted output with 2 decimal places
            writer.println("Goodbye!");

        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Data written to " + file.getName() + " successfully.");
    }
}