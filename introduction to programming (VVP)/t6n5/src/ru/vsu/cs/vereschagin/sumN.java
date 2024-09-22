package ru.vsu.cs.vereschagin;

public class sumN {
    public static double getSumN(double x, int n) {
        double sum = 0;                   // сумма слагаемых

        for (int i = 1; i <= n; i++) {    // i - номер слагаемого, от 1 и до n
            sum += (Math.pow(-1, i - 1) * Math.pow(x, 2 * i - 1)) / (2 * i - 1);   // вычисляем по an
        }

        return sum;
    }
}