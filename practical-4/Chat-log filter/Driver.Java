import java.util.Scanner;
class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Keyword :");
        String keyword = sc.nextLine();
        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob How are you?",
            "badline"
        };
        ChatFilter filter = new ChatFilter();

        filter.filter(logs, keyword);
    }
}