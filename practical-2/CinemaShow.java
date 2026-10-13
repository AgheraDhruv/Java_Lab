
class cinemashow{
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked=0;

    public cinemashow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

     public cinemashow(String title) {
        this(title, 100);
    }

    int book(int seats) {
        if (seats <= seatsAvailable) {
            seatsAvailable -= seats;
            totalBooked += seats;
            return seats;
        } else {
            System.out.println("Not enough seats available.");
            return 0;
        }
    }

    int cancel(int seats) {
        if (seats <= (capacity - seatsAvailable)) {
            seatsAvailable += seats;
            totalBooked -= seats;
            return seats;
        } else {
            System.out.println("Cannot cancel more seats than booked.");
            return 0;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        cinemashow show1 = new cinemashow("toxic", 150);
        cinemashow show2 = new cinemashow("spider man the brand new show");

        System.out.println("--- Booking seats ---");
        show1.book(50);
        show2.book(30);

        System.out.println("Seats available in " + show1.title + ": " + show1.getSeatsAvailable());
        System.out.println("Seats available in " + show2.title + ": " + show2.getSeatsAvailable());
        System.out.println("Total seats booked: " + cinemashow.getTotalBooked());

        System.out.println("--- Canceling seats ---");
        show1.cancel(20);
        show2.cancel(10);

        System.out.println("Seats available in " + show1.title + ": " + show1.getSeatsAvailable());
        System.out.println("Seats available in " + show2.title + ": " + show2.getSeatsAvailable());
        System.out.println("Total seats booked: " + cinemashow.getTotalBooked());
    }

}