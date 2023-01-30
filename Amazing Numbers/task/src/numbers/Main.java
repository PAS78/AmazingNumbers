package numbers;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printStartMessage();

        StringBuilder stringBuilderResult = new StringBuilder();

        while (!stringBuilderResult.toString().equals("\nGoodbye!")) {
            // If empty enter - Instruction
            if (stringBuilderResult.toString().equals("Instruction")) {
                printStartMessage();
            }
            stringBuilderResult = check(inputUser());
            System.out.print(stringBuilderResult);
        }
    }

    private static StringBuilder check(String[] inputArray) {
        StringBuilder stringBuilderResult = new StringBuilder();

        String input1 = inputArray[0];

        // If empty enter
        if (input1.equals("")) {
            return stringBuilderResult.append("Instruction");
        }

        long n = Long.parseLong(input1);

        // If one param
        if (inputArray.length == 1) {

            // If no input = show Menu
            if (input1.trim().equals("")) {
                printStartMessage();
            } else if (n == 0) {
                stringBuilderResult.append("\nGoodbye!");
            } else if (n > 0) {
                stringBuilderResult.append("\nProperties of ").append(n).append("\n");
                stringBuilderResult.append("\teven: ").append(isEven(n)).append("\n");
                stringBuilderResult.append("\todd: ").append(isOdd(n)).append("\n");
                stringBuilderResult.append("\tbuzz: ").append(isBuzz(n)).append("\n");
                stringBuilderResult.append("\tduck: ").append(isDuck(input1)).append("\n");
                stringBuilderResult.append("\tpalindromic: ").append(isPalindromic(input1)).append("\n");
                stringBuilderResult.append("\tgapful: ").append(isGapful(n)).append("\n");
            } else {
                stringBuilderResult.append("\nThe first parameter should be a natural number or zero.\n");
            }
        } else {
            // If more (2) param
            String input2 = inputArray[1];
            long n2 = Long.parseLong(input2);

            // Check second param on Natural
            if (n2 < 1) {
                stringBuilderResult.append("The second parameter should be a natural number.\n");
            } else {
                for (long i = n; i < n + n2; i++) {

                    String result = i + " is ";

                    String result1 = (isBuzz(i) ? "buzz " : "");
                    result1 += (isDuck(String.valueOf(i)) ? "duck " : "");
                    result1 += (isGapful(i) ? "gapful " : "");
                    result1 += (isEven(i) ? "even " : "");
                    result1 += (isOdd(i) ? "odd " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    stringBuilderResult.append(result);
                }
            }

        }

        return stringBuilderResult;

    }

    private static String[] inputUser() {
        System.out.print("\nEnter a request: > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().split(" ");
    }

    private static void printStartMessage() {
        String startMessage = "Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.";
        System.out.println(startMessage);
    }

    private static boolean isBuzz(long n) {
        return n >= 7 && (n % 7 == 0 || n % 10 == 7);
    }

    private static boolean isDuck(String input1) {
        return input1.indexOf('0') > 0;
    }

    private static boolean isOdd(long n) {
        return n % 2 == 1;
    }

    private static boolean isEven(long n) {
        return n % 2 == 0;
    }

    private static boolean isPalindromic(String input1) {
        // Palindromic check
        boolean palindromic = false;
        String first = input1.substring(0, input1.length() / 2);
        String second = input1.substring((input1.length() + (input1.length() % 2)) / 2);
        StringBuilder secondReverse = new StringBuilder(second);
        second = secondReverse.reverse().toString();
        if (input1.length() == 1 || Objects.equals(first, second)) {
            palindromic = true;
        }
        return palindromic;
    }

    private static boolean isGapful(long n) {
        String stringN = String.valueOf(n);
        if (stringN.length() > 2) {
            String firstN = stringN.substring(0, 1);
            String endN = stringN.substring(stringN.length() - 1, stringN.length());

            if (n % Long.parseLong(firstN + endN) == 0) {
                return true;
            } else {
                return false;
            }

        } else return false;

    }

}
