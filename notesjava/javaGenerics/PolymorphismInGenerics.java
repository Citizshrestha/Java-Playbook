package notesjava.javaGenerics;

interface Animal{
    void talk();

}
class Dog implements Animal{
    public void talk() {
        System.out.println("Bhau Bhau");

    }
}
class Cat implements Animal{
    public void talk() {
        System.out.println("Meow Meow");
    }
}

public class PolymorphismInGenerics<T extends Animal> {

    T type;
    PolymorphismInGenerics(T type) {
        this.type = type;
    }
    void makeItTalk(){
        type.talk();
    }
    public static void main(String[] args) {
        PolymorphismInGenerics<Animal> Cat = new PolymorphismInGenerics<>(new Cat());
        Cat.makeItTalk();
        Cat = new PolymorphismInGenerics<>(new Dog());
        Cat.makeItTalk();
    }
}
