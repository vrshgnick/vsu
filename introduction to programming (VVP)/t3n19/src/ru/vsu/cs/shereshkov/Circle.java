package ru.vsu.cs.shereshkov;

public class Circle {
    public double x0;
    public double y0;
    public double r;

    public Circle(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean inCircle(double x, double y) {
        return this.r * this.r >= (x - this.x0) * (x - this.x0) + (y - this.y0) * (y - this.y0);
    }
}