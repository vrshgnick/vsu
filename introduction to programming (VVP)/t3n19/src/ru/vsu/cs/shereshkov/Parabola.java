package ru.vsu.cs.shereshkov;

public class Parabola {
    public double x0;
    public double y0;
    public double a;

    public Parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointUpOfParabola(double x, double y) {

        return y > a * Math.pow(x - x0, 2) + y0;
    }

    public boolean isPointRightOfParabola(double x, double y) {

        return x > a * Math.pow(y - y0, 2) + x0;
    }
}