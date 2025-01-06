package ru.vsu.cs.vereschagin.lab5;

class Cone implements ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateSurfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
}
