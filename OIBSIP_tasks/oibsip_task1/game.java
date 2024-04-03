import java.util.Scanner;
import java.util.Random;

public class game {
    public static void main(String[] args) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 5;
        int score = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number game!");

        while (true) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between " + MIN_NUMBER + " and " + MAX_NUMBER
                    + ". You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                score += MAX_ATTEMPTS - attempts;
            } else {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}

