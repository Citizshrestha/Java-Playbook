package notesjava.javaGenerics;


class Box<T>{
  T object;
  public Box(T object){
    this.object = object;
  }
  public T getVal(){
    return object;
  }
  public void showType(){
    System.out.println("Type of T: "+ object.getClass().getName());
  }
}
public class SimpleGenerics {
  public static void main(String[] args) {
    Box<Integer> intObj = new Box<>(20);
    intObj.showType();
    int val = intObj.getVal();
    System.out.println("Integer value: "+val);
    Box<String> strObj = new Box<>("Citiz");
    strObj.showType();
    String val2 = strObj.getVal();
    System.out.println("Integer value: "+val2);
  }
}
