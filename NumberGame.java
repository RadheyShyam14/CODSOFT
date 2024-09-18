import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain;

        do {
            int maxAttempts = 5;
            int attempts = 0;
            int numberToGuess = random.nextInt(100) + 1;
            boolean guessedCorrectly = false;
            rounds++;

            System.out.println("Round " + rounds + ": Guess the number between 1 and 100.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }

            int roundScore = maxAttempts - attempts + (guessedCorrectly ? 1 : 0);
            totalScore += roundScore;
            System.out.println("Your score for this round: " + roundScore);
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over. Your final score is: " + totalScore);
    }
}
