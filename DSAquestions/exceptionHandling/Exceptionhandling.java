package letsgoDSA.exceptionHandling;

public class Exceptionhandling {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        try {
            // Attempt to divide
//            divide(a, b);

            // Custom exception logic
            String name = "Citiz";
            if (name.equals("Citiz")) {
                throw new MyException("Name is Citiz");
            }
        } catch (MyException e) {
            System.out.println("Exception " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception Caught");
        } finally {
            System.out.println("This will always execute");
        }
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by zero");
        }
        return a / b;
    }
}
