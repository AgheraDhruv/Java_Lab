
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
            "Rahul", "Priya", "Amit", "Rahul",
            "Neha", "Priya", "Karan"
        );

        HashSet<String> uniqueUsers = new HashSet<>();
        LinkedHashSet<String> orderedUsers =
            new LinkedHashSet<>();

        for (String name : logins) {
            uniqueUsers.add(name);
            orderedUsers.add(name);
        }

        System.out.println(
            "Unique visitor count: " + uniqueUsers.size());

        System.out.println("First three distinct names:");

        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
