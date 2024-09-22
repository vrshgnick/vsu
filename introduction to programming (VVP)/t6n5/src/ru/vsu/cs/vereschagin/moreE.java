package ru.vsu.cs.vereschagin;

public class moreE {
    public static double getSumMoreThanE(double x, double e) {
        double sum = 0;                    // сумма слагаемых
        int i = 1;                         // переменная чтобы определить номер слагаемого
        double term = (Math.pow(-1, i - 1) * Math.pow(x, 2 * i - 1)) / (2 * i - 1); // текущее слагаемое

        while (Math.abs(term) > e) {       // выполняем сумму, пока модуль больше е
            sum += term;
            i++;
            term = (Math.pow(-1, i - 1) * Math.pow(x, 2 * i - 1)) / (2 * i - 1);
        }

        return sum;
    }
}