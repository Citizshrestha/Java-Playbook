package notesjava.javaGenerics;


class Pair<K,V>{
  K key;
  V val;
      public Pair(K key,V val){
        this.key=key;
        this.val=val;
      }
      public K getKey(){
        return key;
      }
      public V getVal(){
        return val;
      }
      public void showClass(){
        System.out.println("Type of k is: "+ key.getClass().getName());
        System.out.println("Type of V is: "+ val.getClass().getName());
      }

}
public class GenericClassParameter {
  public static void main(String[] args) {
    Pair <Integer, String> idToName = new Pair<>(101,"Citiz");
    idToName.showClass();
    System.out.println("ID: "+ idToName.getKey());
    System.out.println("Name: "+idToName.getVal());

    Pair<String, String> dictionary = new Pair<>("Java","High level Programming language");
    dictionary.showClass();
    System.out.println("Term: "+dictionary.getKey());
    System.out.println("Meaning: "+dictionary.getVal());
  }
}
