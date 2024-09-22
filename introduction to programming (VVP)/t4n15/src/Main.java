import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите переменную:");
        int N = scanner.nextInt();
        System.out.println("Результат:" + solution(N));
    }

    public static int solution(int N){
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += (int) Math.pow(i + 1,N - i);
        }
        result += N;
        return result;
    }
}