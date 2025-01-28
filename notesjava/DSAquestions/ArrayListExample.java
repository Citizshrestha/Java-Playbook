package letsgoDSA;


import java.util.Arrays;


public class ArrayListExample {
    public static void main(String[] args) {
        int[] arr = {1,5,32,105,222,93};
     int ans =   MaxVal(arr,0,5);
        System.out.println(ans);
    }
  static int MaxVal(int[] arr, int start, int end){
        int max = arr[start];
        for(int i = start; i<=end; i++){
            if (arr[i]> max){
                    max  = arr[i];
            }
        }
        return max;
  }

}
