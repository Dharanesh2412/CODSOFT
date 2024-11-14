import java.util.Random;
import java.util.Scanner;

public class Tasks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalRounds = 0;
        int totalScore = 0;

        while (playAgain) {
            totalRounds++;
            int attempts = 0;
            int maxAttempts = 5;
            int numberToGuess = random.nextInt(100) + 1;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + totalRounds + ": Guess the number between 1 and 100!");
            System.out.println("You have a maximum of " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1;  // More points for fewer attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score: " + totalScore);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
