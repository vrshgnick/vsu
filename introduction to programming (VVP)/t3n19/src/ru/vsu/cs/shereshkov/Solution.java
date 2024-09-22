package ru.vsu.cs.shereshkov;

public class Solution {
    public static final Circle LEFT_CIRCLE = new Circle(-7, -4, 2);
    public static final Circle RIGHT_CIRCLE = new Circle(5, 0, 3);
    public static final Parabola RIGHT_PARABOLA = new Parabola(4, 6, 1);
    public static final Parabola LEFT_PARABOLA = new Parabola(-1, 4, 0.5);
    public static final Rectangle RECTANGLE = new Rectangle(-1,-5,7,4);

    public static SimpleColor getColor(double x, double y) {
    if (LEFT_PARABOLA.isPointUpOfParabola(x,y) && RIGHT_PARABOLA.isPointUpOfParabola(x,y)) {
        return SimpleColor.YELLOW;
    }if (LEFT_PARABOLA.isPointUpOfParabola(x,y)) {
        return SimpleColor.WHITE;
        }if (RIGHT_PARABOLA.isPointUpOfParabola(x,y)) {
        return SimpleColor.BLUE;
        }if (LEFT_CIRCLE.inCircle(x,y)){
        return SimpleColor.GRAY;
        }if (RIGHT_CIRCLE.inCircle(x,y) && RECTANGLE.isPointInsideRectangle(x,y)) {
        return SimpleColor.WHITE;
        }if (RECTANGLE.isPointInsideRectangle(x,y)){
        return SimpleColor.GRAY;
        }if (RIGHT_CIRCLE.inCircle(x,y) && !RECTANGLE.isPointInsideRectangle(x,y)) {
        return SimpleColor.BLUE;
        }return SimpleColor.BLUE;
    }
}