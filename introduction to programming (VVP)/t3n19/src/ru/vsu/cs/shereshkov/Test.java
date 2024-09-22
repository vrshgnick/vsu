package ru.vsu.cs.shereshkov;
public class Test {

    public static void printColorForPoint (double x, double y) {
        System.out.printf("(%.3f, %.3f) - %s%n", x, y, Solution.getColor(x, y));
    }
    public static void test1() {

        printColorForPoint(-1,0); // BLUE
        printColorForPoint(2.5, 10); // BLUE
        printColorForPoint(2.2,10); // YELLOW
        printColorForPoint(2.2, 9.5); // YELLOW
        printColorForPoint(2, 9.5); // WHITE
        printColorForPoint(2, 0); // WHITE
        printColorForPoint(-7,-2); //GREY
        printColorForPoint(2,1); //GREY
    }
}