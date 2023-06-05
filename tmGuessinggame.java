// Programmer: Nguyen Toan Tam
// Class: CS& 145
// Date: 4/5/2023
// Assignment: Guessing game
// Purpose: This program allows you to play a guessing game.
// source: from CS&141 last quarter
import java.util.Scanner;

public class tmGuessinggame {
    // Constant for the maximum number used in the guessing game
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        introduceGame();

        int totalGames = 0;
        int totalGuesses = 0;
        int bestGuesses = MAX_NUMBER + 1;

        boolean playAgain = true;
        while (playAgain) {
            totalGames++;

            // Generate a random number for this game
            int answer = (int) (Math.random() * MAX_NUMBER) + 1;

            int numGuesses = playGame(answer);
            totalGuesses += numGuesses;
            bestGuesses = Math.min(bestGuesse s, numGuesses);

            System.out.println("Do you want to play again? ");
            System.out.println("Y or y to play again");
            System.out.println("N or n to stop play");
            Scanner input = new Scanner(System.in);
            String answerString = input.next();
            char firstChar = answerString.toLowerCase().charAt(0);
            playAgain = (firstChar == 'y');
        }

        reportResults(totalGames, totalGuesses, bestGuesses);
    }

    // Method that introduces the game to the user
    private static void introduceGame() {
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + ".");
        System.out.println("Try to guess what it is.");
        System.out.println("I will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the right answer is higher or lower than your guess.");
    }

    // Method to play one game with the user (just one game, not multiple games)
    private static int playGame(int answer) {
        int guess;
        int numGuesses = 0;

        do {
            System.out.print("Your guess? ");
            Scanner input = new Scanner(System.in);
            guess = input.nextInt();
            numGuesses++;

            if (guess < answer) {
                System.out.println("It's higher.");
            } else if (guess > answer) {
                System.out.println("It's lower.");
            }
        } while (guess != answer);

        if (numGuesses == 1) {
            System.out.println("You got it right in 1 guess");
        } else {
            System.out.println("You got it right in " + numGuesses + " guesses");
        }

        return numGuesses;
    }

    // Method to report overall results to the user
    private static void reportResults(int totalGames, int totalGuesses, int bestGuesses) {
        double averageGuesses = (double) totalGuesses / totalGames;
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/game  = %.1f\n", averageGuesses);
        System.out.println("Best game     = " + bestGuesses + " guesses");
    }
}
