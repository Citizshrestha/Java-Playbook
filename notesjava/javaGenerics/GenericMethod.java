package notesjava.javaGenerics;



public class GenericMethod {
  public static <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.print(element + " ");
    }
    System.out.println();
}
  public static void main(String[] args) {
      Integer[] intArr = {1, 2, 3};
      String[] strArr = {"Java", "Generics"};

      printArray(intArr);
      printArray(strArr);
  }
}

