package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilderResult = new StringBuilder(checkBuzz(inputUser()));

        System.out.print(stringBuilderResult);
    }

    private static StringBuilder checkBuzz(String input) {
        StringBuilder stringBuilderResult = new StringBuilder();

        // Need check Exception From String & Char to Int?
        int fullDigit = Integer.parseInt(input);

        stringBuilderResult.append("Properties of ").append(fullDigit).append("\n");

        // Not natural
        if (fullDigit <= 0) {
            stringBuilderResult.append("This number is not natural!");
            return stringBuilderResult;
        }

        // Even or Odd
        if (fullDigit % 2 == 0) {
            stringBuilderResult.append("even: true\n");
            stringBuilderResult.append("odd: false\n");
        } else {
            stringBuilderResult.append("even: false\n");
            stringBuilderResult.append("odd: true\n");
        }

        // One Digit
        if (input.length() == 1) {
            if (fullDigit == 7) {
                stringBuilderResult.append("buzz: true\n");
            } else {
                stringBuilderResult.append("buzz: false\n");
            }
        } else {
            // For Big digit
            int lastDigit = Integer.parseInt(input.substring(input.length() - 1));
            int firstDigit = Integer.parseInt(input.substring(0, input.length() - 1));

            // Buzz Odd
            if (lastDigit == 7) {
                stringBuilderResult.append("buzz: true\n");
            }

            // Buzz Even (14)
            if (fullDigit % 7 == 0) {
                stringBuilderResult.append("buzz: true\n");
            } else {
                stringBuilderResult.append("buzz: false\n");
            }
        }

        // Duck check
        boolean duck = false;
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) == '0') {
                duck = true;
                i = input.length();
            }
        }
        stringBuilderResult.append("duck: ").append(duck).append("\n");


        // Result
        return stringBuilderResult;

    }

    private static String inputUser() {
        System.out.print("Enter a natural number:\n> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().trim();
    }
}
