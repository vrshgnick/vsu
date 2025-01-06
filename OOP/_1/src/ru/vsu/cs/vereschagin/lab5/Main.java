package ru.vsu.cs.vereschagin.lab5;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование TwoDimensionalShape ===");
        TwoDimensionalShape square = new Square(5);
        System.out.println("Площадь квадрата со стороной 5: " + square.calculateArea());
        System.out.println("Периметр квадрата со стороной 5: " + square.calculatePerimeter());

        System.out.println("\n=== Тестирование ThreeDimensionalShape (Cylinder) ===");
        ThreeDimensionalShape cylinder = new Cylinder(3, 7);
        System.out.println("Площадь поверхности цилиндра с радиусом 3 и высотой 7: " + cylinder.calculateSurfaceArea());
        System.out.println("Объём цилиндра с радиусом 3 и высотой 7: " + cylinder.calculateVolume());

        System.out.println("\n=== Тестирование ThreeDimensionalShape (Cone) ===");
        ThreeDimensionalShape cone = new Cone(3, 7);
        System.out.println("Площадь поверхности конуса с радиусом 3 и высотой 7: " + cone.calculateSurfaceArea());
        System.out.println("Объём конуса с радиусом 3 и высотой 7: " + cone.calculateVolume());
    }
}
