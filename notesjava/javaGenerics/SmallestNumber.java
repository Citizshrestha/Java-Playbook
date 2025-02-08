package notesjava.javaGenerics;

import java.util.Scanner;

public class SmallestNumber {

  public static <T extends Comparable<T>>T findSmallest(T[] arr){
    T smallest = arr[0];
    for(T elem : arr){
      if (elem.compareTo(smallest) <= 0){
        smallest = elem;
      }
    }
    return smallest;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer[] nums = new Integer[10];
    System.out.println("Enter 10 numbers");
    for(int i =0; i<10; i++){
      nums[i] = sc.nextInt();
    }
    System.out.println("Smallest Number is "+findSmallest(nums));
  }
}
