import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        System.out.println("This is a guessing game!");

        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello " + name);

        System.out.println("Shall we start: ");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");

        int beginNumber = sc.nextInt();

        while (beginNumber != 1) {

            System.out.println("Shall we start: ");
            System.out.println("\t1. Yes");
            System.out.println("\t2. No");

            beginNumber = sc.nextInt();
        }

        Random random = new Random();
        int number = random.nextInt(20) + 1;
        System.out.println("Please guess a number between 0 and 20");
        int userNumber = sc.nextInt();

        int timeTried = 0;
        boolean hasWon = false;
        boolean shouldFinish = false;

        while (!shouldFinish) {
            timeTried++;
            if (timeTried < 5) {
                System.out.println("You tried: " + timeTried + " times.");
                System.out.println("You have " + (5 - timeTried) + " chance left!");
                if (userNumber == number) {
                    hasWon = true;
                    shouldFinish = true;
                } else if (userNumber < number) {
                    System.out.println("Guess higher");
                    userNumber = sc.nextInt();
                } else {
                    System.out.println("Gues lower");
                    userNumber = sc.nextInt();
                }
            } else {
                shouldFinish = true;
            }
        }

        if (hasWon) {
            System.out.println("You won after tried: " + timeTried + " times." + "Number was: " + number);
        } else {
            System.out.println("Game is over! and number was: " + number);
        }

    }
}
