package notesjava.javaGenerics;

// Bounded paramter
class Bounded<T extends Number>{
    T data;
    public Bounded(T val){
        data =  val;
    }
    public void print(){
        System.out.println("Keshu is  writing......."+ data);
    }

}
public class GenericsDay2 {
    public static void main(String[] args) {
        Bounded<Number> b1 = new Bounded<>(20);
        b1.print();
    }
}
