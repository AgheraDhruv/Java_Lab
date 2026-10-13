public class ParkingLot {
    private int twoWheelers = 0;
    private int fourWheelers = 0;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public boolean park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked successfully.");
                return true;
            } else {
                System.out.println("Full: No space for two-wheelers.");
                return false;
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked successfully.");
                return true;
            } else {
                System.out.println("Full: No space for four-wheelers.");
                return false;
            }
        } else {
            System.out.println("Invalid vehicle type.");
            return false;
        }
    }

    public void leave(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("A two-wheeler left the parking lot.");
            } else {
                System.out.println("No two-wheelers are currently parked.");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("A four-wheeler left the parking lot.");
            } else {
                System.out.println("No four-wheelers are currently parked.");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

     public static void main(String[] args) {
        // Create a parking lot with capacity for 2 two-wheelers and 1 four-wheeler
        ParkingLot lot = new ParkingLot(2, 1);
        
        System.out.println("--- Parking Simulation Started ---");
        
        lot.park("two");
        lot.park("two");
        lot.park("two");
        
        System.out.println();
        
        lot.park("four");
        lot.park("four");
        
        System.out.println();
        
        lot.leave("two");
        
        lot.park("two");
        
        lot.leave("four");
        lot.leave("four"); 
        
        System.out.println("\n--- Final Status ---");
        System.out.println("Two-wheelers parked: " + lot.getTwoWheelers() + " / " + lot.twoCap);
        System.out.println("Four-wheelers parked: " + lot.getFourWheelers() + " / " + lot.fourCap);
        System.out.println("Total Revenue: Rs. " + ParkingLot.getRevenue());
        
    }
}