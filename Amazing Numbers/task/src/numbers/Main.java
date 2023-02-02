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

        String firstInputString = inputArray[0];

        // If empty enter
        if (firstInputString.equals("")) {
            return stringBuilderResult.append("Instruction");
        }

        // Need Try-catche on not digital ?
        long firstDigit = Long.parseLong(firstInputString);

        // If one param
        if (inputArray.length == 1) {

            // If no input = show Menu
            if (firstInputString.trim().equals("")) {
                printStartMessage();
            } else if (firstDigit == 0) {
                stringBuilderResult.append("\nGoodbye!");
            } else if (firstDigit > 0) {
                stringBuilderResult.append("\nProperties of ").append(firstDigit).append("\n");
                stringBuilderResult.append("\teven: ").append(isEven(firstDigit)).append("\n");
                stringBuilderResult.append("\todd: ").append(isOdd(firstDigit)).append("\n");
                stringBuilderResult.append("\tbuzz: ").append(isBuzz(firstDigit)).append("\n");
                stringBuilderResult.append("\tduck: ").append(isDuck(firstInputString)).append("\n");
                stringBuilderResult.append("\tpalindromic: ").append(isPalindromic(firstInputString)).append("\n");
                stringBuilderResult.append("\tgapful: ").append(isGapful(firstDigit)).append("\n");
                stringBuilderResult.append("\tspy: ").append(isSpy(firstInputString)).append("\n");
            } else {
                stringBuilderResult.append("\nThe first parameter should be a natural number or zero.\n");
            }
        }

        // More 1 params
        if (inputArray.length > 1) {
            // If 2 param
            String secondInputString = inputArray[1];
            // Need try-catch to Int from String?
            long secondDigit = Long.parseLong(secondInputString);

            // Check second param on Natural
            if (secondDigit < 1) {
                stringBuilderResult.append("The second parameter should be a natural number.\n");
                return stringBuilderResult;
            }

            // 2 params
            if (inputArray.length == 2) {
                for (long i = firstDigit; i < firstDigit + secondDigit; i++) {

                    String result = i + " is ";

                    String result1 = (isBuzz(i) ? "buzz " : "");
                    result1 += (isDuck(String.valueOf(i)) ? "duck " : "");
                    result1 += (isGapful(i) ? "gapful " : "");
                    result1 += (isEven(i) ? "even " : "");
                    result1 += (isOdd(i) ? "odd " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    stringBuilderResult.append(result);
                }
            }

            // 3 params
            if (inputArray.length == 3) {
                // If 3 param
                // Check correct Input param3
                String[] paramArray = new String[]{"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd"};
                Boolean status = false;
                for (String param : paramArray) {
                    if ((inputArray[2].contains(param))) {
                        status = true;
                        break;
                    }
                }

                if (!status) {
                    stringBuilderResult.append("The property [").append(inputArray[2].toUpperCase()).append("] is wrong.").append("\n");
                    stringBuilderResult.append("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]").append("\n");

                    return stringBuilderResult;
                } else {
                    for (long i = firstDigit, count = 0; count < secondDigit; i++) {

                        String result = i + " is ";

                        String result1 = (isBuzz(i) ? "buzz " : "");
                        result1 += (isDuck(String.valueOf(i)) ? "duck " : "");
                        result1 += (isGapful(i) ? "gapful " : "");
                        result1 += (isEven(i) ? "even " : "");
                        result1 += (isOdd(i) ? "odd " : "");
                        result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                        result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                        result1 = result1.trim();
                        result1 = result1.replace(" ", ", ");

                        result += result1 + "\n";

                        if (result.contains(inputArray[2])) {
                            count++;
                            stringBuilderResult.append(result);
                        }
                    }
                }

            }

        }

        return stringBuilderResult;
    }

    private static boolean isSpy(String input1) {

        char[] charArray = input1.toCharArray();

        long summ = 0;
        long proizveden = 1;

        for (int i = 0; i < charArray.length; i++) {
            long x = Long.parseLong(String.valueOf(charArray[i]));
            summ += x;
            proizveden *= x;
        }

        return summ == proizveden;
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

    private static String[] inputUser() {
        System.out.print("\nEnter a request: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase().trim().split(" ");
    }

    private static void printStartMessage() {
        String startMessage = "Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.";
        System.out.println(startMessage);
    }

}
