package letsgoDSA;


public class Scope {
    public static void main(String[] args) {
     
      boolean ans = armstrongCheck(153);
        System.out.println(ans);
    }

    static void  sumNatural(int  n) {
        int sum=0;
        for (int i =1; i<=n; i++){
      
            sum += i;
        

        }
        System.out.println("sum of n natural number is :" + sum);
    }

    static boolean armstrongCheck(int n) {
        int originalNumber = n;  
        int rem, sum = 0;
       

        while (n > 0) {
            rem = n % 10;        
            sum += rem; 
            n /= 10;         
        }

        if (sum == originalNumber) {
           return true;
        } else {
            return false;
        }
    }
}
