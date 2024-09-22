package ru.vsu.cs.vereschagin;

public class main {
    public static void main(String[] args) {

        System.out.println(sumator(99));
    }
    public static double sumator(int n){
        double sum = 0;
        for (int i = n; i >= 3; i= i-3){
            sum += i;
            sum = Math.sqrt(sum);
        }
        return sum;
    }
}