package numbers;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilderStart = new StringBuilder("Welcome to Amazing Numbers!\n\n");
        stringBuilderStart.append("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.\n");
        System.out.print(stringBuilderStart);

        StringBuilder stringBuilderResult = new StringBuilder();

        while (!stringBuilderResult.toString().equals("\nGoodbye!")) {
            stringBuilderResult = checkBuzz(inputUser());
            System.out.print(stringBuilderResult);
        }
    }

    private static StringBuilder checkBuzz(String input) {
        StringBuilder stringBuilderResult = new StringBuilder();

        long n = Long.parseLong(input);

        // Palindromic check
        boolean palindromic = false;
        String first = input.substring(0, input.length() / 2);
        String second = input.substring((input.length() + (input.length() % 2)) / 2);
        StringBuilder secondReverse = new StringBuilder(second);
        second = secondReverse.reverse().toString();
        if (input.length() == 1 || Objects.equals(first, second)) {
            palindromic = true;
        }

        if (n == 0) {
            stringBuilderResult.append("\nGoodbye!");
        } else if (n > 0) {
            stringBuilderResult.append("\nProperties of ").append(n).append("\n");
            stringBuilderResult.append("\teven: ").append(n % 2 == 0).append("\n");
            stringBuilderResult.append("\todd: ").append(n % 2 == 1).append("\n");
            stringBuilderResult.append("\tbuzz: ").append(n >= 7 && (n % 7 == 0 || n % 10 == 7)).append("\n");
            stringBuilderResult.append("\tduck: ").append(input.indexOf('0') > 0).append("\n");
            stringBuilderResult.append("\tpalindromic: ").append(palindromic).append("\n");
        } else {
            stringBuilderResult.append("\nThe first parameter should be a natural number or zero.\n");
        }

        return stringBuilderResult;

    }

    private static String inputUser() {
        System.out.print("\nEnter a request: > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().trim();
    }
}
