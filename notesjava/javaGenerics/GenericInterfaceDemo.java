package notesjava.javaGenerics;
  
public class GenericInterfaceDemo {
    
    public static void main(String[] args) {
        
        Integer[] array = new Integer[]{5, 2, 3};
        GenClass<Integer> obj = new GenClass<>(array);
        obj.display();
    }
    
}

interface GenInterface<T> {
    void display() ;
}

class GenClass<T> implements GenInterface<T> {

    T[] array;

    public GenClass(T[] arr) {
        this.array = arr;
    }
    
    public void display() {
        
        for (T item : array) {
            System.out.println("Elements in array is: "+ item);
        }
    }
    
}