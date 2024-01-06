package rockPaperScissors;

import java.util.Random;

public enum InputState {
    ROCK,
    PAPER,
    SCISSORS,
    EXIT;

    private static final Random randomizer = new Random();
    
    public static InputState of(String s) {
        String lowercase = s.toLowerCase();
        
        switch (lowercase) {
            case "rock":
            case "r":
                return InputState.ROCK;
            case "paper":
            case "p":
                return InputState.PAPER;
            case "scissor":
            case "scissors":
            case "s":
                return InputState.SCISSORS;
            case "q":
            case "quit":
                return InputState.EXIT;
            default:
                throw new IllegalArgumentException("Invalid state: " + s);
        }
    }
    
    public static InputState of(int value) {
        switch (value) {
            case 0:
                return InputState.ROCK;
            case 1:
                return InputState.PAPER;
            case 2:
                return InputState.SCISSORS;
            case 3:
                return InputState.EXIT;
            default:
                throw new IllegalArgumentException("Invalid value: " + value);
        }
    }

    public static boolean isWinningAgainst(InputState current, InputState other) {
        if (current.equals(InputState.EXIT)) {
            throw new IllegalStateException("Cannot evaluate the winning condition of an exit command!");
        }

        switch (current) {
            case PAPER:
                return other.equals(InputState.ROCK);
            case ROCK:
                return other.equals(InputState.SCISSORS);
            case SCISSORS:
                return other.equals(InputState.PAPER);
            default:
                throw new IllegalStateException("Illegal input state");
        }
    }

    public static InputState getRandomState() {
        // machine cannot quit the program
        return InputState.of(randomizer.nextInt( 3));
    }
}
