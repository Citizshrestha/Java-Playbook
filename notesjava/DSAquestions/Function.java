package letsgoDSA;

import java.util.Arrays;
import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  number");
        int num1 = sc.nextInt();
      boolean ans = CheckPrimeNum(num1);
        System.out.println(ans);
        if (ans == true){
            System.out.println("Prime number");
        } else{
            System.out.println("Not Prime number");
        }
    }
    static boolean CheckPrimeNum(int n) {
        if (n <= 1){
            return false;
        }
        if (n == 2){
            return true;
        }
        if (n % 2 == 0){
            return false;
        }
        for (int i = 3; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

}
