package armstrongCheck;


import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int input = sc.nextInt();
        boolean ans = isArmstrong(input);
        System.out.println(ans);
     System.out.println(input + " is armstrong number");
          for (int i = 1000; i<10000;i++){
              if (isArmstrong(i)){
                  System.out.println(i + " ");
              }
          }
          sc.close();
    }


    static boolean isArmstrong(int num) {
        int orginal = num;
        int sum, rem;
        sum =0;

        int noofdigits = String.valueOf(num).length();

        while (num!=0){
            rem = num % 10;
            sum += Math.pow(rem,noofdigits);
            num /= 10;
        }
        return orginal == sum;
    }
}