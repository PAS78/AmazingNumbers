import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split("");
        String result = "";

        for (int i = 0, count = 1; i < strings.length; i++) {

            // Check on not last
            if (i + 1 != strings.length) {
                if (strings[i].equals(strings[i + 1])) {
                    count++;
                } else {
                    result += strings[i] + count;
                    count = 1;
                }
                // Last
            } else {
                result += strings[i] + count;
            }

        }

        System.out.print(result);

    }
}