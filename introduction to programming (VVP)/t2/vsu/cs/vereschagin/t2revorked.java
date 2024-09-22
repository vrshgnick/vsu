//file 2 number 20 [2.20]

package vsu.cs.vereschagin;

import java.util.Scanner;

public class t2revorked {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите количество голов первой команды: ");
        int goalsTeam1 = scanner.nextInt();
        System.out.printf("Введите количество голов второй команды: ");
        int goalsTeam2 = scanner.nextInt();

        int pointsTeam1 = teamPoint(goalsTeam1, goalsTeam2);
        int pointsTeam2 = teamPoint(goalsTeam2, goalsTeam1);

        System.out.println("Команда 1 заработала " + pointsTeam1 + " очков.");
        System.out.println("Команда 2 заработала " + pointsTeam2 + " очков.");
    }

    public static int teamPoint(int t1, int t2) {
        if (t1 > t2) {
            return 3;
        }
        else if (t1 < t2) {
            return 0;
        }
        else {
            return 1;
        }
    }
}