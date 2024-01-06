package rng;

import java.util.Random;
import java.util.Scanner;

public class RNG {
    private static final Random rng = new Random();
    private static Scanner scanner;

    public static void main(String[] args) {
        pollNumber();
    }

    public static void pollNumber() {
        System.out.print("Enter in how many number to generate: ");
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(rng.nextInt());
        }
    }
}
