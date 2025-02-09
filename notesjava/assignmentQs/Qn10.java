package assignmentQs;

class SharedResource {
    private boolean isProcessed = false;

    public synchronized void produce() {
        try {
            while (isProcessed) {
                wait(); // Wait until consumption is done
            }
            System.out.println(Thread.currentThread().getName() + " produced an item.");
            isProcessed = true;
            notifyAll(); // Notify all waiting threads
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    public synchronized void consume() {
        try {
            while (!isProcessed) {
                wait(); // Wait until production is done
            }
            System.out.println(Thread.currentThread().getName() + " consumed an item.");
            isProcessed = false;
            notifyAll(); // Notify all waiting threads
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.produce();
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.consume();
        }
    }
}

public class Qn10 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource), "Producer");
        Thread consumerThread = new Thread(new Consumer(resource), "Consumer");

        producerThread.start();
        consumerThread.start();

        // Ensure the main thread terminates last
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Main thread terminates last.");
    }
}



