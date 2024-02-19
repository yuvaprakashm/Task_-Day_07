import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    private static final String[] words = {"testing", "hello", "world", "java", "programming"};

    public static void main(String[] args) {
        String secretWord;

        if (args.length == 1) {
            secretWord = args[0].toLowerCase();
        } else {
            Random rand = new Random();
            secretWord = words[rand.nextInt(words.length)].toLowerCase();
        }

        boolean[] guessedCharacters = new boolean[secretWord.length()];
        int trials = 0;

        System.out.println("Java WordGuess " + secretWord);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!allCharactersGuessed(guessedCharacters)) {
                System.out.print("Key in one character or your guess word: ");
                String userInput = scanner.nextLine().toLowerCase();

                if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
                    char guessedChar = userInput.charAt(0);
                    trials++;

                    if (secretWord.indexOf(guessedChar) != -1) {
                        updateGuessedCharacters(secretWord, guessedCharacters, guessedChar);
                    }

                    printTrialResult(secretWord, guessedCharacters, trials);
                } else if (userInput.equals(secretWord)) {
                    System.out.println("Congratulations!");
                    System.out.println("You got it in " + trials + " trials");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid character or guess the entire word.");
                }
            }
        }
    }

    private static boolean allCharactersGuessed(boolean[] guessedCharacters) {
        for (boolean guessed : guessedCharacters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }

    private static void updateGuessedCharacters(String secretWord, boolean[] guessedCharacters, char guessedChar) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guessedChar) {
                guessedCharacters[i] = true;
            }
        }
    }

    private static void printTrialResult(String secretWord, boolean[] guessedCharacters, int trials) {
        System.out.print("Trail " + trials + ": ");
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(guessedCharacters[i] ? secretWord.charAt(i) : '_');
        }
        System.out.println();
    }
}
