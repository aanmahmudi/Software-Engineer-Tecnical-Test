import java.util.Scanner;

public class SwapValuesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input X: ");
        int x = scanner.nextInt();

        System.out.print("Input Y: ");
        int y = scanner.nextInt();

        // Swap values without a new variable
        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("Output: X=" + x + ", Y=" + y);

        scanner.close();
    }
}
