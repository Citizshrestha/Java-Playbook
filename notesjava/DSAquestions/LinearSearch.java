package letsgoDSA;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {124, 3458, 22, 64, 7896};
        int ans = findNumbers(arr);
        System.out.println(ans);
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }
        return count;
    }

    static boolean even(int n) {
        int numberOfDigits = (n == 0) ? 1 : (int) (Math.log10(Math.abs(n)) + 1);
        return numberOfDigits % 2 == 0;
    }
}
