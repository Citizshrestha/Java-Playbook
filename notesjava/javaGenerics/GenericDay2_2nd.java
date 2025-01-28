package notesjava.javaGenerics;

interface Myinterface<T> {
    void show(T object);

}
class MyClass<T> implements Myinterface<T>{
    T object;

    public MyClass(T object) {
        this.object = object;
    }

    @Override
    public void show(T object){
        System.out.println("Show value: "+ object);
    }
}
public class GenericDay2_2nd {
    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<Integer>(1);
        myClass.show(Integer.valueOf(1));
        myClass.show(Integer.valueOf(2));

    }
}
