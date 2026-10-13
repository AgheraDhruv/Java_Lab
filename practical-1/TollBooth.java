import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {
        // (b) Running toll total and counters
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter vehicle number (or 'done' to stop): ");
            String number = scanner.next();
            
            if (number.equalsIgnoreCase("done")) {
                break;
            }
            
            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = scanner.next().toLowerCase();
            
            Vehicle vehicle = new Vehicle(number, type);
            
            int toll = switch (vehicle.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> {
                    System.out.println("Unknown vehicle type. Skipping...");
                    yield 0;
                }
            };
            
            if (toll > 0) {
                totalToll += toll;
                switch (vehicle.type()) {
                    case "bike" -> bikeCount++;
                    case "car" -> carCount++;
                    case "truck" -> truckCount++;
                }
            }
        }
        
        String mostFrequent = "none";
        int maxCount = 0;
        
        if (bikeCount > maxCount) {
            maxCount = bikeCount;
            mostFrequent = "bike";
        }
        if (carCount > maxCount) {
            maxCount = carCount;
            mostFrequent = "car";
        }
        if (truckCount > maxCount) {
            maxCount = truckCount;
            mostFrequent = "truck";
        }
        
        System.out.println("Total toll: " + totalToll);
        if (maxCount > 0) {
            System.out.println("Most frequent: " + mostFrequent);
        }
        
        scanner.close();
    }
}