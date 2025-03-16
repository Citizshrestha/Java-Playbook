package letsgoDSA;

public class patterns {
    public static void main(String[] args) {
     
        Pattern31(5);
    }

  
    

   
    static void Pattern31(int n){
        int newN= 2*n;
        for (int row=0; row<= newN; row++){
            for(int col=0; col<=newN; col++){
                int atEveryIdx = Math.min(Math.min(row,col), 
                Math.min(newN-row, newN-col));
                System.out.print(atEveryIdx+" ");
            }
            System.out.println();
        }
    }
    


    static void Pattern17(int n){
       // Upper part of the diamond
       for (int row = 1; row <= n; row++) {
        // Print spaces for alignment
        for (int spaces = 1; spaces <= n - row; spaces++) {
            System.out.print(" ");
        }
        // Print numbers in descending order
        for (int col = row; col >= 1; col--) {
            System.out.print(col);
        }
        // Print numbers in ascending order starting from 2
        for (int col = 2; col <= row; col++) {
            System.out.print(col);
        }
        System.out.println();
    }
        for (int row = n - 1; row >= 1; row--) {
            // Print spaces for alignment
            for (int spaces = 1; spaces <= n - row; spaces++) {
                System.out.print(" ");
            }
            // Print numbers in descending order
            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }
            // Print numbers in ascending order starting from 2
            for (int col = 2; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    
    


    static void Pattern30(int n){
        for(int row=1; row<=n; row++){
            int spaces = n - row;
            for(int s=1; s<=spaces; s++){
                System.out.print(" ");
            }
            for(int col=row; col >= 1; col--){
                System.out.print(col);
            }
            for(int col=2; col <= row; col++){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void Pattern28(int n){
        for(int row=1; row<=2*n-1; row++){
          
            int totalnoofColsineachrow = row > n ? 2*n-row : row;
            for(int spaces = 1; spaces<=n-totalnoofColsineachrow; spaces++){
                System.out.print(" ");
            }
            for(int col=1; col<=totalnoofColsineachrow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void Pattern5(int n){
        for(int row=1; row <= 2*n-1; row++){

            int totalnoofColsineachrow = row > n ? 2*n-row: row;
          
            for(int col=1; col <= totalnoofColsineachrow; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern4(int n){
        for (int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.print(col+ " ");
            }
            System.out.println();
        }
    }

    static void Pattern3(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=n-row+1; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void Pattern2(int n){
        for (int row = 1; row <= n; row++){
            for (int col= 1; col <= row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void Pattern1(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=n;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
