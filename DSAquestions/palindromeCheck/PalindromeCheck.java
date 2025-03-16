package palindromeCheck;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it’s a palindrome: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("'" + input + "' is a palindrome!");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        String cleanStr = str.toLowerCase().trim();

        int left = 0;
        int right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
