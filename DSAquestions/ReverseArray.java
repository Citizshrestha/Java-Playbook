package DSAquestions;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {5,3,54,87,23,9,4};
        System.out.println("Original Array: " + Arrays.toString(arr));
      reverse(arr);
        System.out.println("Reversed Array: "+ Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        // int start = 0;
        // int end = arr.length -1;
        // while(start < end) {
        //     int temp = arr[start];
        //     arr[start] = arr[end];
        //     arr[end] = temp;
        //     start++;
        //     end -- ;

        // }

        //   for (int i = 0;  i<arr.length/2; i++){
        //     int temp = arr[i];
        //     arr[i] = arr[arr.length -1 -i];
        //     arr[arr.length -1 -i] = temp;

        //   }


        int[] tempArr = arr.clone(); // Create a copy of the original array
        int index = arr.length - 1;  // Start from the end

        for (int num : tempArr) {
            arr[index] = num;        // Place elements in reverse order
            index--;
        }
        
    }
}
