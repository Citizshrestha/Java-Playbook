package letsgoDSA;

import java.util.Arrays;
import java.util.Scanner;

public class ColNoFixed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Asking the user for the number of rows
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        // Initializing the jagged array
        int[][] arr = new int[rows][];

        // Input each row with variable column sizes
        for (int row = 0; row < arr.length; row++) {
            System.out.print("Enter the number of columns for row " + row + ": ");
            int cols = sc.nextInt();  // Get the number of columns for each row

            // Initialize the row with the specified number of columns
            arr[row] = new int[cols];

            // Fill the row with user input
            System.out.println("Enter " + cols + " elements for row " + row + ": ");
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = sc.nextInt();
            }
        }



        // Print the array in matrix form
        System.out.println("The array is:");
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }
}
