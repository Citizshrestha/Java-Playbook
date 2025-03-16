package letsgoDSA.exceptionHandling;

import javax.naming.InsufficientResourcesException;

public class ThrowsException {

    public static void checkBalance(int balance) throws InsufficientResourcesException{
        if(balance < 10){
            throw new InsufficientResourcesException("Please recharge your balance it is less than Rs 10");
        } else{
            System.out.println("Balance is " + balance);
        }
    }
    public static void main(String[] args) {
        try{
            checkBalance(5);
        }catch(InsufficientResourcesException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Program ended");
        }
    }




}
