package notesjava.javaGenerics;

class test{
  private double value;
  <T extends Number> test(T num){
    value = num.doubleValue();
    System.out.println("Called with constructor: "+ value);
  }
  public void showData(){
    System.out.println("Stored value: "+ value);
  }
} 
public class GenericConstructor {
  public static void main(String[] args) {
    test obj1 = new test(10);
    obj1.showData();

    test obj2 = new test(10.44);
    obj2.showData();

    test obj3 = new test(20.3f);
    obj3.showData();
  }
}
