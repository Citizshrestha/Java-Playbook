package fibonacci;

import java.util.Scanner;

public class FibonacciCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of counts for fibonacci Series: ");
        int count = sc.nextInt();

        if (count <= 0) {
            System.out.println("Please enter a positive number");
        } else {
            System.out.println("Fibonacci Numbers with " + count + " numbers are");
            fibonacciFun(count);
        }
        sc.close();
    }

    static void fibonacciFun(int count) {
        int first = 0;
        int second = 1;

        if (count >= 1) {
            System.out.print(first + " "); // Print first number without newline
          
        } 
        if (count >= 2) {
            System.out.print(second + " "); // Print second number without newline
          
        }

        for (int i = 3; i <= count; i++) {
            int next = first + second;
            System.out.print(next + " "); // Print next number 
            first = second;
            second = next;
        }
        System.out.println(); // Final newline after all numbers
    }
}