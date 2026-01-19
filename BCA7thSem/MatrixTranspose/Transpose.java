import java.util.Scanner;

public class Transpose {

    // method to display a matrix
    public static void displayMatrix(int[][]matrix, int rows, int cols){
       for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            System.out.print(matrix[i][j] + "\t");
         }
         System.out.println();
       }
    }

    // method to find transpose of matrix
    public static int[][] transposeMatrix(int[][] matrix, int rows, int cols) {
        int[][] transpose  = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Matrix Transpose");

        System.out.println("Enter number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        
        // input matrix elements
        System.out.println("Enter elements of matrix");
         for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Element[" + (i+1)+"]["+(j+1)+"]");
                matrix[i][j] = sc.nextInt();
            }
         }

         System.out.println("\nOriginal Matrix (with rows: " + rows + " and cols: " + cols + ")");
         displayMatrix(matrix, rows, cols);

         int[][] transpose = transposeMatrix(matrix, rows, cols);
         System.out.println("\n Transpose matrix("+ cols +"x" + rows+ ")");
         displayMatrix(transpose, cols, rows);

         sc.close();
    }
}