import java.util.Random;
import java.util.Scanner;

enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}

public class RPSLS {
    
    public static int winner(Move a, Move b) {
        if (a == b) {
            return 0; // Tie
        }
        
        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER    -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK     -> (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;
            case LIZARD   -> (b == Move.PAPER || b == Move.SPOCK) ? 1 : -1;
            case SPOCK    -> (b == Move.ROCK || b == Move.SCISSORS) ? 1 : -1;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Move[] allMoves = Move.values();
        
        int playerScore = 0;
        int computerScore = 0;
        
        System.out.println("Welcome to Rock-Paper-Scissors-Lizard-Spock!");
        
        // (c) Loop 5 rounds
        for (int i = 1; i <= 5; i++) {
            System.out.print("\nRound " + i + " - Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String input = scanner.next().toUpperCase();
            
            Move playerMove;
            try {
                playerMove = Move.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move. We will replay this round.");
                i--; 
                continue;
            }
            
            Move computerMove = allMoves[random.nextInt(allMoves.length)];
            
            System.out.println("You played: " + playerMove);
            System.out.println("Computer played: " + computerMove);
            
            int result = winner(playerMove, computerMove);
            
            if (result == 1) {
                System.out.println("Result: You win this round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Result: Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("Result: It's a tie!");
            }
        }
        
        System.out.println("\n--- Final Score ---");
        if (playerScore > computerScore) {
            System.out.println("You win " + playerScore + "–" + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins " + computerScore + "–" + playerScore);
        } else {
            System.out.println("It's a tie " + playerScore + "–" + computerScore);
        }
        
        scanner.close();
    }
}