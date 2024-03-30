import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Game Menu:");
        System.out.println("1. Play Rock Paper Scissors");
        System.out.println("2. Play Connect 4");
        System.out.println("3. Play Guess the Number");
        System.out.println("4. Play Tic-Tac-Toe");
        System.out.println("Enter the corresponding number to select the game:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                RockPaperScissor.main(args);
                break;
            case 2:
                Connect4.main(args);;
                break;
            case 3:
                GuessTheNumber.main(args);;
                break;
            case 4:
                TicTacToe.main(args);;
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
}
