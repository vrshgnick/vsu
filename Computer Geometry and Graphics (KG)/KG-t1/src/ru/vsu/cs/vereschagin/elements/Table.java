package ru.vsu.cs.vereschagin.elements;

import java.awt.*;

public class Table {
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;

    public Table(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(255, 224, 189));
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fm = g.getFontMetrics();
        int textX = x + (width - fm.stringWidth(text)) / 2;
        int textY = y + (height + fm.getAscent()) / 2;
        g.drawString(text, textX, textY);

        g.setColor(new Color(139, 69, 19));
        g.fillRect(x + width / 2 - 5, y + height, 10, 30);
    }
}
