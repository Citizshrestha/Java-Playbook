public class StarPyramid {
    public static void main(String[] args) {
        int n = 5;  // Number of rows
        
        for (int row = 1; row <= n; row++) {
            // Print spaces
            for (int spaces = row; spaces < n; spaces++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
                if (col < row) {
                    System.out.print(" ");  // Add space between stars, but not after the last star
                }
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}
