package ru.vsu.cs.vereschagin;

import java.util.Locale;

public class main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = InputHandler.getDouble("Input x (-1 < x < 1): ");
        int n = InputHandler.getInt("Input n (n >= 1): ");
        double e = InputHandler.getDouble("Input e: ");

        if ((x <= -1) || (x >= 1)) {
            System.out.println("Invalid x value.");
            System.exit(1);
        } else if (n < 1) {
            System.out.println("Invalid n value.");
            System.exit(1);
        }

        double[] sums = Calculator.getSums(x, n, e);

        double sumN = sums[0];
        double sumE = sums[1];
        double sumE10 = sums[2];
        double trueValue = Calculator.getTrueValue(x);

        System.out.printf("1) %.10f%n", sumN);
        System.out.printf("2) %.10f%n", sumE);
        System.out.printf("3) %.10f%n", sumE10);
        System.out.printf("4) %.10f%n", trueValue);
    }
}