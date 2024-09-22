package ru.vsu.cs.vereschagin.task1;

import java.util.Locale;
import java.util.Scanner;

public class t1n5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину стороны квадрата: ");
        double side = scanner.nextDouble();

        System.out.printf("Resoult: %.3f%n", getLastS(side));
    }
    public static double getCircleS(double d) {
        double r = d / 2;
        return Math.PI * r * r;
    }
    public static double getSquareS(double a) {
        return a * a;
    }
    public static double getLastS(double s) {
        double angleS = (getSquareS(s) - getCircleS(s)) / 4;
        return angleS * 2 + getCircleS(s);
    }
}