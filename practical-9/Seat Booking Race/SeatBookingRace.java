class Cinema {

    private int seatsLeft = 5;

    public synchronized boolean book(String name) {

        if (seatsLeft > 0) {

            seatsLeft--;

            System.out.println(
                    name + " booked a seat."
            );

            return true;
        }

        System.out.println(
                name + " failed. No seats available."
        );

        return false;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }
}

class BookingThread extends Thread {

    private Cinema cinema;

    public BookingThread(Cinema cinema, String name) {
        super(name);
        this.cinema = cinema;
    }

    @Override
    public void run() {

        cinema.book(getName());
    }
}

public class SeatBookingRace {

    public static void main(String[] args)
            throws InterruptedException {

        Cinema cinema = new Cinema();

        BookingThread[] threads =
                new BookingThread[10];

        for (int i = 0; i < 10; i++) {

            threads[i] =
                    new BookingThread(
                            cinema,
                            "User-" + (i + 1)
                    );

            threads[i].start();
        }

        for (BookingThread thread : threads) {
            thread.join();
        }

        System.out.println();
        System.out.println(
                "Seats left: " + cinema.getSeatsLeft()
        );
    }
}