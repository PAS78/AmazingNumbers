package numbers;

import java.util.*;

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

    private static ArrayList<String> checkInput(String[] inputArray) {
        String[] paramArray = new String[]{"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny", "jumping", "happy", "sad"};
        ArrayList<String> result = new ArrayList<>();

        boolean equals = false;

        for (int i = 2; i < inputArray.length; i++) {

            for (String s : paramArray) {
                String sMinus = "-" + s;
                if (s.equals(inputArray[i]) || sMinus.equals(inputArray[i])) {
                    equals = true;
                    break;
                } else {
                    equals = false;
                }
            }

            if (!equals) {
                result.add(inputArray[i]);
            }

        }

        return result;
    }

    static boolean isHappyNumber(long n) {
        HashSet<Long> st = new HashSet<>();
        while (true) {
            n = numSquareSum(n);
            if (n == 1)
                return true;
            if (st.contains(n))
                return false;
            st.add(n);
        }
    }

    static long numSquareSum(long n) {
        int squareSum = 0;
        while (n != 0) {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

    private static boolean isJumping(long n) {
        String raw = Long.toString(n);
        int[] num = new int[raw.length()];

        for (int i = 0; i < raw.length(); i++) {
            num[i] = raw.charAt(i) - '0';
        }

        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] - num[i + 1] != 1 && num[i] - num[i + 1] != -1) {
                return false;
            }

        }

        return true;
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
        return scanner.nextLine().toLowerCase().trim().split("\\s+");
    }

    private static void printStartMessage() {
        String startMessage = "Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
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

        // Check & convert Input first digit
        long firstDigit;
        try {
            firstDigit = Long.parseLong(firstInputString);
        } catch (NumberFormatException e) {
            return stringBuilderResult.append("\nThe first parameter should be a natural number or zero.\n");
        }

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
                stringBuilderResult.append("\tjumping: ").append(isJumping(firstDigit)).append("\n");
                stringBuilderResult.append("\thappy: ").append(isHappyNumber(firstDigit)).append("\n");
                stringBuilderResult.append("\tsad: ").append(!isHappyNumber(firstDigit)).append("\n");
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
                    result1 += (isJumping(i) ? "jumping " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                    if (isHappyNumber(i)) {
                        result1 += "happy ";
                    } else {
                        result1 += "sad ";
                    }
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    stringBuilderResult.append(result);
                }
            }

            // Params >= 3
            if (inputArray.length >= 3) {
                // Check correct Input
                ArrayList<String> checkInput = checkInput(inputArray);
                if (checkInput.size() == 1) {
                    stringBuilderResult.append("The property ").append(checkInput.toString().toUpperCase()).append(" is wrong.").append("\n");
                    stringBuilderResult.append("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]").append("\n");
                    return stringBuilderResult;
                } else if (checkInput.size() > 1) {
                    stringBuilderResult.append("The properties ").append(checkInput.toString().toUpperCase());
                    stringBuilderResult.append(" are wrong.\n");
                    stringBuilderResult.append("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]").append("\n");
                    return stringBuilderResult;
                }

                // Check Input Property
                if (inputArray.length > 3) {
                    if (Arrays.asList(inputArray).contains("even") && Arrays.asList(inputArray).contains("odd")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [EVEN, ODD]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("duck") && Arrays.asList(inputArray).contains("spy")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [DUCK, SPY]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("sunny") && Arrays.asList(inputArray).contains("square")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [SUNNY, SQUARE]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("sad") && Arrays.asList(inputArray).contains("happy")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [SAD, HAPPY]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("-even") && Arrays.asList(inputArray).contains("-odd")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [-EVEN, -ODD]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("-duck") && Arrays.asList(inputArray).contains("-spy")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [-DUCK, -SPY]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    if (Arrays.asList(inputArray).contains("-sad") && Arrays.asList(inputArray).contains("-happy")) {
                        stringBuilderResult.append("The request contains mutually exclusive properties: [-SAD, -HAPPY]");
                        stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                        return stringBuilderResult;
                    }
                    // [GAPFUL, -GAPFUL]
                    for (String s : inputArray) {
                        if (Arrays.asList(inputArray).contains("-" + s)) {
                            stringBuilderResult.append("The request contains mutually exclusive properties: [");
                            stringBuilderResult.append(s.toUpperCase()).append(", -").append(s.toUpperCase()).append("]");
                            stringBuilderResult.append("\nThere are no numbers with these properties.\n");
                            return stringBuilderResult;

                        }
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
                    result1 += (isJumping(i) ? "jumping " : "");
                    result1 += (isPalindromic(String.valueOf(i)) ? "palindromic " : "");
                    result1 += (isSpy(String.valueOf(i)) ? "spy " : "");
                    if (isHappyNumber(i)) {
                        result1 += "happy ";
                    } else {
                        result1 += "sad ";
                    }
                    result1 = result1.trim();
                    result1 = result1.replace(" ", ", ");

                    result += result1 + "\n";

                    // Check Output
                    boolean findResult = false;
                    for (int j = 2; j < inputArray.length; j++) {
                        if (!inputArray[j].startsWith("-")) {
                            if (result.contains(inputArray[j])) {
                                findResult = true;
                            } else {
                                findResult = false;
                                break;
                            }
                        } else if (result.contains(inputArray[j].substring(1))) {
                            findResult = false;
                            break;
                        } else {
                            findResult = true;
                        }

                    }

                    if (findResult) {
                        count++;
                        stringBuilderResult.append(result);
                    }

                }

            }

        }

        return stringBuilderResult;
    }

}