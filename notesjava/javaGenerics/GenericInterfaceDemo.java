package notesjava.javaGenerics;
  
interface testInterface<T> {

    public void display();

}
class test<T> implements testInterface<T>{
    T[] array;
    test(T[] arr){
        this.array = arr;

    }
    public void display(){
        for (T item : array){
            System.out.print( item + " ");
        }
    }
}

public class GenericInterfaceDemo{
    public static void main(String[] args) {
        System.out.println("Elements in array: ");
        
        Integer[] intArr = new Integer[]{1,2,3,4};
        test<Integer> obj1 = new test<>(intArr);
        obj1.display();

        String[] strArr  = new String[] {"Citiz", "Shrestha"};
        test<String> obj2 = new test<>(strArr);
        obj2.display();
    }
}