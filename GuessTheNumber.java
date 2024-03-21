import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void play() {
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        String play = "yes";

        while (play.equals("yes")) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100...");
            System.out.println("Can you guess it?");
            
            int randNum = rand.nextInt(100) + 1;
            int guess = -1;
            int tries = 0;

            while (guess != randNum) {
                System.out.print("Enter your guess: ");
                guess = reader.nextInt();
                tries++;

                if (guess == randNum) {
                    System.out.println("Congratulations! You guessed the number!");
                    System.out.println("It took you " + tries + " guesses.");
                    break;
                } else if (guess > randNum) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Too low! Try a higher number.");
                }
            }

            System.out.print("Would you like to play again? (Yes/No): ");
            play = reader.next().toLowerCase();
        }
        System.out.println("Thank you for playing! Goodbye.");
        reader.close();
    }
}