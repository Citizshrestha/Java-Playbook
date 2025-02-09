package notesjava.javaGenerics;

interface test<T>{
  public void addItem(T item);
  T getItem();
}
    
  class IntegerBox implements test<Integer>{
     Integer item;
     public void addItem(Integer item){
      this.item = item;
     }
     public Integer getItem(){
      return item;
     }
  }

  class StringBox implements test<String>{
    String item;
    public void addItem (String item){
      this.item = item;
    }
    public String getItem(){
      return item;
    }
  }
public class GenericPolymorpishm {
  public static void main(String[] args) {
    test<Integer> intTest = new IntegerBox();
    intTest.addItem(34);
    System.out.println("Integer value is: " +intTest.getItem());

    test<String> strTest = new StringBox();
    strTest.addItem("CItiz");
    System.out.println("Integer value is: " + strTest.getItem());

  }
}
