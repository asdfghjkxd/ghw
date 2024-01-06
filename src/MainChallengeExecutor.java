import helloWorld.HelloWorld;
import rockPaperScissors.Game;
import sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class MainChallengeExecutor {
    private static final String[] zeroArgInput = new String[0];

    public static void main(String[] args) {
        System.out.println("Hello, World Challenge");
        System.out.println("---------------------");
        HelloWorld.main(zeroArgInput);

        System.out.println("\nRock, Paper, Scissors Challenge");
        System.out.println("-------------------------------");
        Game.main(zeroArgInput);

        System.out.println("\nSorting Method Challenge");
        System.out.println("------------------------");
        ArrayList<Integer> toSort = new ArrayList<>(new ArrayList<>(
                List.of(5, 4, 3, 2, 1)
        ));
        System.out.println("Before sorting: " + toSort);
        Sort.sort(toSort);
        System.out.println("After sorting: " + toSort);
        System.out.println("Check out SortTest for unit test cases");
    }
}
