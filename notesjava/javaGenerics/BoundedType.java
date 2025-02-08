package notesjava.javaGenerics;

class A {
  public void display() {
    System.out.println("Super class A");
  }
}

class B extends A {
  public void display() {
    System.out.println(" class B");
  }
}

class C extends A {
  public void display() {
    System.out.println(" class C");
  }
}

class Box<T extends A> {
  T obj;

  public Box(T obj) {
    this.obj = obj;
  }

  public void doTest() {
    this.obj.display();
  }
}

public class BoundedType {
  public static void main(String[] args) {
    Box<C> BoxC = new Box<C>(new C());
    BoxC.doTest();

    Box<B> BoxB = new Box<B>(new B());
    BoxB.doTest();

    Box<A> BoxA = new Box<A>(new A());
    BoxA.doTest();
  }
}
