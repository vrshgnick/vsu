package ru.vsu.cs.vereschagin.elements;

import java.awt.*;

public class Castle {
    private int x;
    private int y;

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

    public Castle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawTower(Graphics2D g, int xOffset, int yOffset) {
        // флажок
        g.setPaint(Color.decode("#d9d3c4"));
        int[] xFlagPoints = {x + xOffset - 15, x + xOffset - 15, x + xOffset + 15};
        int[] yFlagPoints = {y + yOffset - 240, y + yOffset - 260, y + yOffset - 250};
        g.fillPolygon(xFlagPoints, yFlagPoints, 3);

        // палка флажка
        g.setPaint(Color.decode("#a49874"));
        g.drawLine(x + xOffset - 15, y + yOffset - 240, x + xOffset - 15, y + yOffset - 260);

        // конус сверху
        g.setPaint(Color.decode("#a49874"));
        int[] xLeftTopBackSideOfTowerPoints = {x + xOffset - 50, x + xOffset - 15, x + xOffset + 20};
        int[] yLeftTopBackSideOfTowerPoints = {y + yOffset - 170, y + yOffset - 240, y + yOffset - 170};
        g.fillPolygon(xLeftTopBackSideOfTowerPoints, yLeftTopBackSideOfTowerPoints, 3);

        // левая сторона башни
        g.setPaint(Color.decode("#EBE7D6"));
        int[] xLeftSideOfTowerPoints = {x + xOffset - 30, x + xOffset - 45, x + xOffset - 45, x + xOffset - 30};
        int[] yLeftSideOfTowerPoints = {y + yOffset - 150, y + yOffset - 160, y + yOffset - 10, y + yOffset};
        g.fillPolygon(xLeftSideOfTowerPoints, yLeftSideOfTowerPoints, 4);

        // верхняя часть башни
        int[] xLeftTopSideOfTowerPoints = {x + xOffset - 30, x + xOffset - 30, x + xOffset - 50, x + xOffset - 50};
        int[] yLeftTopSideOfTowerPoints = {y + yOffset - 150, y + yOffset - 170, y + yOffset - 180, y + yOffset - 160};
        g.fillPolygon(xLeftTopSideOfTowerPoints, yLeftTopSideOfTowerPoints, 4);

        // перед башни
        g.setPaint(Color.decode("#D1CBB9"));
        g.fillRect(x + xOffset - 30, y + yOffset - 150, 30, 150);
        g.fillRect(x + xOffset - 30, y + yOffset - 170, 30, 20);

        // правая сторона башни
        g.setPaint(Color.decode("#bdb49a"));
        int[] xRightSideOfTowerPoints = {x + xOffset, x + xOffset + 15, x + xOffset + 15, x + xOffset};
        int[] yTowerPoints = {y + yOffset - 150, y + yOffset - 160, y + yOffset - 10, y + yOffset};
        g.fillPolygon(xRightSideOfTowerPoints, yTowerPoints, 4);

        int[] xRightTopSideOfTowerPoints = {x + xOffset, x + xOffset, x + xOffset + 20, x + xOffset + 20};
        int[] yRightTopSideOfTowerPoints = {y + yOffset - 150, y + yOffset - 170, y + yOffset - 180, y + yOffset - 160};
        g.fillPolygon(xRightTopSideOfTowerPoints, yRightTopSideOfTowerPoints, 4);

        // Окна
        g.setColor(Color.decode("#474244"));
        g.fillRect(x + xOffset - 20, y + yOffset - 130, 10, 15);
        g.fillRect(x + xOffset - 20, y + yOffset - 100, 10, 15);
    }

    public void drawCastle(Graphics2D g, int wallWidth) {
        g.setPaint(Color.decode("#D1CBB9"));
        g.fillRect(x, y - 100, wallWidth, 90);

        g.setPaint(Color.decode("#474244"));
        int windowSize = 10;
        int spacing = 15;
        int startX = x + spacing + 15;
        int endX = x + wallWidth - 15;

        for (int i = startX; i < endX - windowSize; i += windowSize + spacing) {
            g.fillRect(i, y - 80, windowSize, windowSize);
        }

        int doorWidth = 50;
        int doorHeight = 50;
        int doorArc = 25;
        int wallCenterX = x + wallWidth / 2;
        g.setPaint(Color.decode("#726337"));
        g.fillRoundRect(wallCenterX - doorWidth / 2, y - 60, doorWidth, doorHeight, doorArc, doorArc);
        g.fillRect(wallCenterX - doorWidth / 2, y - 30, doorWidth, 20);

        drawTower(g, 0, 0);
        drawTower(g, wallWidth + 30, 0);
    }
}
