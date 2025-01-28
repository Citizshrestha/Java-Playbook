package letsgoDSA;

import java.util.Scanner;

public class MaxandMincheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sumNatural(num);
    }

    static void sumNatural(int n) {
        // Initialize sum outside the loop
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            sum += i; // Add current number to sum
        }
        System.out.println("Sum of the first " + n + " natural numbers is: " + sum);
    }
}
