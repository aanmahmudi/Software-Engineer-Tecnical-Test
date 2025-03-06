import java.util.Scanner;

public class CreateStarApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input tinggi segitiga: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // Print numbers
            for (int j = i; j <= n; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        scanner.close();
    }
}
