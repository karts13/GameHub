import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors) or 'quit' to exit: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("quit")) {
                break;
            } else if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                continue;
            }

            int randomIndex = random.nextInt(choices.length);
            String computerChoice = choices[randomIndex];

            System.out.println("Computer's choice: " + computerChoice);

            // Determine the winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
