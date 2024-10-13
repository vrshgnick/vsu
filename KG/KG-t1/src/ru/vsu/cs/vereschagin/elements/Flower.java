package ru.vsu.cs.vereschagin.elements;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Flower {
    private int x, y;
    private Color grassColor, flowerColor;

    public Color getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(Color flowerColor) {
        this.flowerColor = flowerColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getGrassColor() {
        return grassColor;
    }

    public void setGrassColor(Color grassColor) {
        this.grassColor = grassColor;
    }

    public Flower(int x, int y, Color grassColor, Color flowerColor) {
        this.x = x;
        this.y = y;
        this.grassColor = grassColor;
        this.flowerColor = flowerColor;
    }

    public void drawFlower(Graphics2D g) {
        Color oldColor = g.getColor();

        // Draw the stem
        g.setColor(grassColor);
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.curveTo(x - 5, y, x - 10, y - 10, x - 15, y - 20);
        path.moveTo(x, y);
        path.curveTo(x + 5, y, x + 10, y - 10, x + 15, y - 20);
        path.moveTo(x, y);
        path.lineTo(x, y - 30); // Shortened stem
        g.draw(path);

        // Draw the flower petals
        g.setColor(flowerColor);
        int[] xPoints = {x, x - 10, x - 12, x + 12, x + 10};
        int[] yPoints = {y - 20, y - 30, y - 40, y - 40, y - 30}; // Adjusted y-coordinates for smaller flower
        g.fillPolygon(xPoints, yPoints, 5);

        g.setColor(oldColor);
    }

}