import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the figure s (s >= 2) = ");
        int s = scanner.nextInt();
        drawPattern(s);
    }

    public static void drawPattern(int s) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j <= s - i; j++) {
                if ((i == j || j == s - i) && i != s / 2) continue;
                System.out.print(" *");
            }
            System.out.println("|");
        }
        for (int i = s - 1; i >= 0; i--) {
            for (int j = s - 1; j >= i; j--) {
                if ((j == i || j == s - i - 1) && i != s / 2 - 1) continue;
                System.out.print("*");
            }
            System.out.println("|");
        }
    }
}
