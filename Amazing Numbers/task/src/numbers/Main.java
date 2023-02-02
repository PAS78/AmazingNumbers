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

    private static int isCorrectInput(String[] inputArray) {
        // Check correct Input param 3 & 4
        String[] paramArray = new String[]{"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny"};
        int result = 0; // 0 - good, 2 - problem index, 3 - problem index, 4 - all index problem

        boolean result1 = false;
        boolean result2 = false;

        for (String param : paramArray) {
            if (Objects.equals(inputArray[2], param)) {
                result1 = true;
                break;
            }
        }

        if (inputArray.length == 4) {
            for (String param : paramArray) {
                if (Objects.equals(inputArray[3], param)) {
                    result2 = true;
                    break;
                }
            }

            if (result1 && result2) result = 0;
            else if (!result1 && result2) result = 2;
            else if (result1 && !result2) result = 3;
            else if (!result1 && !result2) result = 4;
            return result;

        }

//        int size = someString != null ? someString.length() : 0;
//        result = result1 && result2 ? 0 : result1 ?

        if (result1) return 0;
        else return 2;


    }

    private static boolean isSunny(long n) {
        return Math.sqrt(n + 1) % 1 == 0;
    }

    private static boolean isSquare(long n) {
        return Math.sqrt(n) % 1 == 0;
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
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.";
        System.out.println(startMessage);
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
                stringBuilderResult.append("\tsunny: ").append(isSunny(firstDigit)).append("\n");
                stringBuilderResult.append("\tsquare: ").append(isSquare(firstDigit)).append("\n");
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
                    result1 += (isSunny(i) ? "sunny " : "");
                    result1 += (isSquare(i) ? "square " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    stringBuilderResult.append(result);
                }
            }

            // Params >= 3
            if (inputArray.length >= 3) {
                // Check correct Input
                int controlInput = isCorrectInput(inputArray);
                if (controlInput == 2 || controlInput == 3) {
                    stringBuilderResult.append("The property [").append(inputArray[controlInput].toUpperCase()).append("] is wrong.").append("\n");
                    stringBuilderResult.append("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SQUARE, SUNNY]").append("\n");
                    return stringBuilderResult;
                } else if (controlInput == 4) {
                    // The properties [HOT, SUN] are wrong.
                    stringBuilderResult.append("The properties [").append(inputArray[2].toUpperCase());
                    stringBuilderResult.append(", ").append(inputArray[3].toUpperCase()).append("] are wrong.\n");
                    stringBuilderResult.append("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD, SQUARE, SUNNY]").append("\n");
                    return stringBuilderResult;
                }

                // Check Input Property
                if (inputArray.length > 3) {
                    String chekExclusive = inputArray[2] + inputArray[3];

                    if (chekExclusive.contains("sunny") && chekExclusive.contains("square") ||
                            chekExclusive.contains("spy") && chekExclusive.contains("duck") ||
                            chekExclusive.contains("even") && chekExclusive.contains("odd")) {

                        stringBuilderResult.append("The request contains mutually exclusive properties: [");
                        stringBuilderResult.append(inputArray[2].toUpperCase()).append(", ");
                        stringBuilderResult.append(inputArray[3].toUpperCase()).append("]\n");
                        stringBuilderResult.append("There are no numbers with these properties.\n");

                        return stringBuilderResult;


                    }
                }


                for (long i = firstDigit, count = 0; count < secondDigit; i++) {

                    String result = i + " is ";

                    String result1 = (isBuzz(i) ? "buzz " : "");
                    result1 += (isDuck(String.valueOf(i)) ? "duck " : "");
                    result1 += (isGapful(i) ? "gapful " : "");
                    result1 += (isEven(i) ? "even " : "");
                    result1 += (isOdd(i) ? "odd " : "");
                    result1 += (isSunny(i) ? "sunny " : "");
                    result1 += (isSquare(i) ? "square " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    if (inputArray.length == 3 && result.contains(inputArray[2])) {
                        count++;
                        stringBuilderResult.append(result);
                    } else if (inputArray.length == 4 && result.contains(inputArray[2]) && result.contains(inputArray[3])) {
                        count++;
                        stringBuilderResult.append(result);
                    }

                }

            }

        }

        return stringBuilderResult;
    }


}
