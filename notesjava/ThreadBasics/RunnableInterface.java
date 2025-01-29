package thread.CodeWithHarry;

class RunnableThread1 implements Runnable {
  @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
          System.out.println("Hello from thread1");
      }
  }
}
class RunnableThread2 implements Runnable {
  @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
          System.out.println("Hello from thread2");
      }
  }
}

public class RunnableInterface {
    public static void main(String[] args) {
        RunnableThread1 rthread1 = new RunnableThread1();
        Thread obj1 = new Thread(rthread1);
        obj1.start();

        RunnableThread2 rthread2 = new RunnableThread2();

        Thread obj2 =  new Thread(rthread2);
        obj2.start();
    }
}
