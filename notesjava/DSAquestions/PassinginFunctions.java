package letsgoDSA;

import java.util.Arrays;
import java.util.Scanner;

public class PassinginFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][2];
        System.out.println(arr.length);
        for (int row = 0; row < arr.length; row++){
            for (int col= 0; col < arr[row].length; col++ )
            {

                arr[row][col] = sc.nextInt();
            }
        }

       for (int[] elems : arr){
           System.out.println(Arrays.toString(elems));
       }
    }

}
