package assignmentQs;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        while (count < 100) {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented to: " + count);
            notify();
            try {
                if (count < 100) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}

public class Qn8 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
