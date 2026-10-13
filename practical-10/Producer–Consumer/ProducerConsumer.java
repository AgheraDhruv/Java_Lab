class Buffer {

    private int item;
    private boolean available = false;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (available) {
            wait();
        }

        item = value;
        available = true;

        System.out.println(
                "Produced: " + value
        );

        notify();
    }

    public synchronized int consume()
            throws InterruptedException {

        while (!available) {
            wait();
        }

        int value = item;
        available = false;

        System.out.println(
                "Consumed: " + value
        );

        notify();

        return value;
    }
}

class Producer extends Thread {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 5; i++) {

                buffer.produce(i);

                Thread.sleep(200);
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 5; i++) {

                buffer.consume();

                Thread.sleep(300);
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args)
            throws InterruptedException {

        Buffer buffer = new Buffer();

        Producer producer =
                new Producer(buffer);

        Consumer consumer =
                new Consumer(buffer);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "Production and consumption completed."
        );
    }
}