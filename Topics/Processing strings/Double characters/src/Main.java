import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String out = "";

        for (int i = 0; i < inputString.length(); i++) {
            out += inputString.substring(i, i + 1) + inputString.substring(i, i + 1);
        }

        System.out.print(out);

    }
}