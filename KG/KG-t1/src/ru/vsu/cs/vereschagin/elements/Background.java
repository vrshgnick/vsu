package ru.vsu.cs.vereschagin.elements;

import java.awt.*;

public class Background {
    private int width;
    private int height;
    private Color skyColor;
    private Color riverColor;
    private Color groundColor;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getSkyColor() {
        return skyColor;
    }

    public void setSkyColor(Color skyColor) {
        this.skyColor = skyColor;
    }

    public Color getRiverColor() {
        return riverColor;
    }

    public void setRiverColor(Color riverColor) {
        this.riverColor = riverColor;
    }

    public Color getGroundColor() {
        return groundColor;
    }

    public void setGroundColor(Color groundColor) {
        this.groundColor = groundColor;
    }

    public Background(int width, int height, Color skyColor, Color riverColor, Color groundColor) {
        this.width = width;
        this.height = height;
        this.skyColor = skyColor;
        this.riverColor = riverColor;
        this.groundColor = groundColor;
    }

    public  void draw(Graphics2D g) {
        g.setPaint(skyColor);
        g.fillRect(0,0,width,height);
        g.setPaint(groundColor);
        g.fillRect(0,(int) (height/1.9), width, (int) (height/1.65));
        g.setPaint(riverColor);
        g.fillRect(0, (int) (height/1.65), width, 135);
    }
}