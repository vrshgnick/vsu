package ru.vsu.cs.zdv.task6.variant13;

import java.util.Scanner;

public class InputHandler {
    public static final Scanner scanner = new Scanner(System.in);

    public static double getDouble(String msg) {
        System.out.print(msg);
        return scanner.nextDouble();
    }

    public static int getInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }
}