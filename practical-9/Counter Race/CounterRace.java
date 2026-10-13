class Counter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterWorker extends Thread {

    private Counter counter;
    private int times;

    public CounterWorker(Counter counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    @Override
    public void run() {

        for (int i = 0; i < times; i++) {
            counter.increment();
        }
    }
}

public class CounterRace {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        int numberOfThreads = 10;
        int incrementsPerThread = 1000;

        CounterWorker[] workers =
                new CounterWorker[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {

            workers[i] =
                    new CounterWorker(
                            counter,
                            incrementsPerThread
                    );

            workers[i].start();
        }

        for (CounterWorker worker : workers) {
            worker.join();
        }

        System.out.println(
                "Final counter value: "
                        + counter.getCount()
        );

        System.out.println(
                "Expected value: "
                        + (numberOfThreads * incrementsPerThread)
        );
    }
}