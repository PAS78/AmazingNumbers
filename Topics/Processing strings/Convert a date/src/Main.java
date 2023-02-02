import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");

        System.out.print(input[1] + "/" + input[2] + "/" + input[0]);

    }
}