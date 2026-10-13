class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class CounterRaceFixed {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        int numberOfThreads = 10;
        int incrementsPerThread = 100000;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }

            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int expected = numberOfThreads * incrementsPerThread;

        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + counter.count);
    }
}