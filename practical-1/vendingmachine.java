import java.util.Scanner;

enum Coin {
    ONE, TWO, FIVE, TEN
}

public class vendingmachine {
    public static void main(String[] args) {
        int snackPrice = 15;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert coins (ONE, TWO, FIVE, TEN). Snack price is 15.");

        
        while (total < snackPrice) {
            System.out.print("Insert coin: ");
            String input = scanner.next().toUpperCase();
            
            try {
                Coin coin = Coin.valueOf(input);
                
               
                int coinValue = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };
                
                total += coinValue;
                System.out.println("Total so far: " + total);
                
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coin! Please use ONE, TWO, FIVE, or TEN.");
            }
        }

   
        int change = total - snackPrice;
        System.out.println("Paid. Change: " + change);
        
        scanner.close();
    }
}