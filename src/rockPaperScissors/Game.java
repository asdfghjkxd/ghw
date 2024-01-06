package rockPaperScissors;

import java.util.Scanner;

public class Game {
    private static void start() {
        InputState command = null;
        int userScore = 0;
        Scanner inputScanner = new Scanner(System.in);

        printGreeting();
        while (command == null || !command.equals(InputState.EXIT)) {
            command = obtainInput(inputScanner);
            
            if (command.equals(InputState.EXIT)) {
                continue;
            }
            
            InputState computerInput = InputState.getRandomState();

            if (InputState.isWinningAgainst(command, computerInput)) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("You lose!");
            }
        }

        printExit(userScore);
    }

    private static void printGreeting() {
        System.out.println("Rock Paper Scissors");
        System.out.println("------------------");
        System.out.println("Type in your game input below (r for rock, p for paper and s for scissors) or q to quit:");
    }

    private static void printExit(int score) {
        System.out.println("Your score: " + score);
    }

    private static InputState obtainInput(Scanner inputScanner) {
        InputState parsedState = null;
        
        while (parsedState == null) {
            try {
                System.out.print(">>> ");
                String input = inputScanner.nextLine().toLowerCase();
                parsedState = InputState.of(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("Sorry, I do not recognise the input! Make sure to use r, p or s as inputs!");
            };
        }

        return parsedState;
    }

    public static void main(String[] args) {
        Game.start();
    }
}
