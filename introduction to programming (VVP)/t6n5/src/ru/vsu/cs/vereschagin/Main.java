package ru.vsu.cs.vereschagin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x (-1 < x < 1): ");
        double x = scanner.nextDouble();

        System.out.print("Введите количество слагаемых n: ");
        int n = scanner.nextInt();

        System.out.print("Введите значение e: ");
        double e = scanner.nextDouble();

        double sum = 0;
        double sumAbsGreaterE = 0;
        double sumAbsGreaterEOver10 = 0;

        for (int i = 1; i <= n; i++) {
            double term = Math.pow(x, 2 * i - 1) / (2 * i - 1);
            sum += term;

            if (Math.abs(term) > e) {
                sumAbsGreaterE += term;
            }

            if (Math.abs(term) > e / 10) {
                sumAbsGreaterEOver10 += term;
            }
        }

        double result = 2 * sum;

        System.out.println("Сумма n слагаемых: " + result);
        System.out.println("Сумма слагаемых с абсолютной величиной больше e: " + sumAbsGreaterE);
        System.out.println("Сумма слагаемых с абсолютной величиной больше e/10: " + sumAbsGreaterEOver10);
        System.out.println("Значение функции с помощью методов Math: " + Math.log((1 + x) / (1 - x)));

    }
}