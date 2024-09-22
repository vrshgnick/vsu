package ru.vsu.kodintsev.a.v;

import java.util.Scanner;

import static ru.vsu.kodintsev.a.v.Solution.image;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение h = ");
        int h = scanner.nextInt();
        System.out.print("Введите значение w = ");
        int w = scanner.nextInt();
        image(h,w);
    }
}
