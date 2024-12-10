package ru.vsu.cs.vereschagin.elements;

import java.awt.*;

public class Cloud {
    private int x, y, r;
    private Color c;

    public Cloud(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void drawCloud(Graphics2D g){
        Color oldColor = g.getColor();
        Stroke oldStroke = g.getStroke();

        g.setColor(c);
        g.fillOval(x-r, y-r, r*2, r);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawOval(x-r, y-r, r*2, r);

        g.setColor(oldColor);
        g.setStroke(oldStroke);
    }
}