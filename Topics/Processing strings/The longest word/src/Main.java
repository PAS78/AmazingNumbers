import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        String[] stringsArray = string.split(" ");

        String result = "";
        for (String s : stringsArray) {
            if (s.length() > result.length()) {
                result = s;
            }
        }
        System.out.print(result);

    }
}