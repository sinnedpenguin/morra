import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean play = true;

        while (play) {
            int playerPickedNumber = getPlayerPickedNumber(scanner);
            int playerGuessedSum = getPlayerGuessedSum(scanner);
            int cpuPickedNumber = generateCpuPickedNumber();
            int cpuGuessedSum = generateCpuGuessedSum();

            System.out.println("You picked " + playerPickedNumber + " and guessed " + playerGuessedSum);
            System.out.println("Computer picked " + cpuPickedNumber + " and guessed " + cpuGuessedSum);

            int sum = playerPickedNumber + cpuPickedNumber;

            if (sum == playerGuessedSum && sum != cpuGuessedSum) {
                System.out.println("The sum is " + sum + ". You won!");
            } else if (sum == cpuGuessedSum && sum != playerGuessedSum) {
                System.out.println("The sum is " + sum + ". Computer wins!");
            } else if (sum == playerGuessedSum && sum == cpuGuessedSum) {
                System.out.println("The sum is " + sum + ". It's a draw!");
            } else {
                System.out.println("The sum is " + sum + ". No one wins!!");
            }

            play = playAgain(scanner);
        }
        scanner.close();
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("Play again? (y/n): ");
        String input = scanner.nextLine().toLowerCase();

        while (!input.equals("y") && (!input.equals("n"))) {
            System.out.print("Invalid input. Please enter 'y' or 'n': ");
            input = scanner.nextLine().toLowerCase();
        }
        return input.equals("y");
    }

    private static int getPlayerPickedNumber(Scanner scanner) {
        int playerPickedNumber;

        do {
            System.out.print("Pick a number between 1 and 5: ");
            String input = scanner.nextLine();
            try {
                playerPickedNumber = Integer.parseInt(input);
                if (playerPickedNumber < 1 || playerPickedNumber > 5) {
                    System.out.println("Number must be between 1 and 5. Please try again...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please try again...");
                playerPickedNumber = 0;
            }
        } while (playerPickedNumber < 1 || playerPickedNumber > 5);

        return playerPickedNumber;
    }

    private static int getPlayerGuessedSum(Scanner scanner) {
        int playerGuessedSum;

        do {
            System.out.print("Guess the sum between 2 and 10: ");
            String input = scanner.nextLine();
            try {
                playerGuessedSum = Integer.parseInt(input);
                if (playerGuessedSum < 2 || playerGuessedSum > 10) {
                    System.out.println("Sum must be between 2 and 10. Please try again...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please try again...");
                playerGuessedSum = 0;
            }
        } while (playerGuessedSum < 2 || playerGuessedSum > 10);

        return playerGuessedSum;
    }

    private static int generateCpuPickedNumber() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    private static int generateCpuGuessedSum() {
        Random rand = new Random();
        return rand.nextInt(9) + 2;
    }
}