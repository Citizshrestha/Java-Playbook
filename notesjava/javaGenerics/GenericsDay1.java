package notesjava.javaGenerics;

public class GenericsDay1 {


    public static void main(String[] args) {
        GenericVal <Integer> obj= new GenericVal<>(500);
        obj.display(20);

        GenericMethod methodObj = new GenericMethod();
        Integer[] list = {1,23,3,45,54};
        methodObj.showAlldata(list);
    }
}
class GenericVal<T>{
    T value;
    public void display(T value){
        System.out.println("Value is: "+value);
    }
    public GenericVal(T value){
        this.value = value;
    }
}

class GenericMethod{
    public <Lists> void showAlldata(Lists[] array){
        for (Lists items: array){
            System.out.println("Items: "+ items);
        }
    }
}