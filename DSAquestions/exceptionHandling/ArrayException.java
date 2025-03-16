package letsgoDSA.exceptionHandling;

class InvalidArrayElementException extends Exception {
    public InvalidArrayElementException(String message) {
        super(message); 
    }
}

public class ArrayException {

    public static void main(String[] args) {
        int[] arr = {12, 32, 43, 41};
        System.out.println("Array length: " + arr.length);
        
        try {
            // Step 2: Call the method to check the array for a specific condition
            checkArray(arr);
        } catch (InvalidArrayElementException e) {
            // Step 3: Catch and handle the user-defined exception
            System.out.println("Caught exception: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch standard ArrayIndexOutOfBoundsException if occurs
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } finally {
            // Step 4: Always executed
            System.out.println("Ended");
        }
    }

    // Step 5: Method to check the array
    public static void checkArray(int[] arr) throws InvalidArrayElementException {
        // If the second element is 32, throw the user-defined exception
        if (arr.length > 1 && arr[1] == 32) {
            throw new InvalidArrayElementException("Second element can't be 32");
        }
    }
}
