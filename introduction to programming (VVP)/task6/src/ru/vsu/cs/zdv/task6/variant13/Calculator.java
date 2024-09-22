package ru.vsu.cs.zdv.task6.variant13;

public class Calculator {
    /**
     * <p>Returns a(i) of sequence in Task 6, Variant 13 with
     * dependence of previous sequence member.</p>
     * <p>Formula: a(i) = -a(i - 1) * ((i + 1) / (i - 1)) * x</p>
     * 
     * @param i needed iteration of sequence
     * @param prevA previous sequence member
     * @param x optional parameter
     * @return next a(i) of sequence
     */
    public static double getA(int i, double prevA, double x) {
        return -prevA * (i + 1) / (i - 1) * x;
    }

    public static double getTrueValue(double x) {
        return 1 / Math.pow((1 + x), 3);
    }

    /**
     * Static method to get three sums for Task 6, Variant 13.
     * 
     * @param x the parameter between -1 and 1
     * @param n the count of overall sequence members
     * @param e the arbitrary number
     * @return double[3] array: {sumN, sumE, sumE10}
     */
    public static double[] getSums(double x, int n, double e) {
        // a - current sequence member
        double a = 1;

        double sumN = 0;
        double sumE = 0;
        double sumE10 = 0;

        boolean flagN = true;
        boolean flagE = true;
        boolean flagE10 = true;

        for (int i = 1; flagN || flagE || flagE10; i++) {
            // get sum for i < n
            if (i <= n) {
                sumN += a;
            } else {
                flagN = false;
            }

            // get sum for a(n) > e
            if (Math.abs(a) > e) {
                sumE += a;
            } else {
                flagE = false;
            }

            // get sum for a(n) > e / 10
            if (Math.abs(a) > (e / 10)) {
                sumE10 += a;
            } else {
                flagE10 = false;
            }

            // increase i and get next a
            a = getA(i + 1, a, x);
        }

        return new double[] { sumN, sumE, sumE10 };
    }
}