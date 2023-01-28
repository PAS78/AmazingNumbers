package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilderResult = new StringBuilder(checkBuzz(inputUser()));

        System.out.print(stringBuilderResult.toString());
    }

    private static StringBuilder checkBuzz(String input) {
        StringBuilder stringBuilderResult = new StringBuilder();

        // Need check Exception From String & Char to Int?
        int fullDigit = Integer.parseInt(input);

        // Not natural
        if (fullDigit <= 0) {
            stringBuilderResult.append("This number is not natural!");
            return stringBuilderResult;
        }

        // Even or Odd
        if (fullDigit % 2 == 0) {
            stringBuilderResult.append("This number is Even.\n");
        } else {
            stringBuilderResult.append("This number is Odd.\n");
        }

        // One Digit
        if (input.length() == 1) {
            if (fullDigit == 7) {
                stringBuilderResult.append("It is a Buzz number.\n");
                stringBuilderResult.append("Explanation:\n");
                stringBuilderResult.append(input + " is divisible by 7 and ends with 7.");

                return stringBuilderResult;

            } else {
                stringBuilderResult.append("It is not a Buzz number.\n");
                stringBuilderResult.append("Explanation:\n");
                stringBuilderResult.append(input + " is neither divisible by 7 nor does it end with 7.");


                return stringBuilderResult;
            }
        } else {
            // For Big digit
            int lastDigit = Integer.parseInt(input.substring(input.length() - 1));
            int firstDigit = Integer.parseInt(input.substring(0, input.length() - 1));

            // Buzz Odd
            if (lastDigit == 7) {
                stringBuilderResult.append("It is a Buzz number.\n");
                stringBuilderResult.append("Explanation:\n");
                if (fullDigit % 7 == 0) {
                    stringBuilderResult.append(input + "is divisible by 7 and ends with 7");
                } else {
                    stringBuilderResult.append(input + " ends with 7.");
                }

                return stringBuilderResult;
            }

            // Buzz Even (14)
            if (fullDigit % 7 == 0) {
                stringBuilderResult.append("It is a Buzz number.\n");
                stringBuilderResult.append("Explanation:\n");
                stringBuilderResult.append(input + " is divisible by 7.");

                return stringBuilderResult;
            } else {
                stringBuilderResult.append("It is not a Buzz number.\n");
                stringBuilderResult.append("Explanation:\n");
                stringBuilderResult.append(input + " is neither divisible by 7 nor does it end with 7.");

                return stringBuilderResult;
            }
        }

    }

    private static String inputUser() {
        System.out.print("Enter a natural number:\n> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().trim();
    }
}
