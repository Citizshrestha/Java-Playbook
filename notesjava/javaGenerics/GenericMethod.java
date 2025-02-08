package notesjava.javaGenerics;

public class GenericMethod {

  public static <T> void printArray(T[] arr){
    for (T element: arr){
      System.out.println("Elements in array are: "+ element);
    }
  }
  public static void main(String[] args) {
    Integer[] intArr = new Integer[] {1,2,3};
    printArray(intArr);

    String[] strArr = new String[] {"I", "AM","OK"};
    printArray(strArr);
  }
}

