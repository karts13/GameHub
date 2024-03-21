import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Game Menu:");
        System.out.println("1. Play Rock Paper Scissors");
        System.out.println("2. Play Connect 4");
        System.out.println("3. Play Guess the Number");
        System.out.println("4. Play Another Game");
        System.out.println("Enter the corresponding number to select the game:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                RockPaperScissor.play();
                break;
            case 2:
                Connect4.play();
                break;
            case 3:
                GuessTheNumber.play();
                break;
            case 4:
                TicTacToe.play();
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }
}