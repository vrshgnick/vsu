package ru.vsu.cs.vereschagin.elements;

import java.awt.*;

public class Boat {
    private int x;  // Положение по оси X
    private int y;  // Положение по оси Y
    private int width;  // Ширина корабля
    private int height; // Высота корабля

    public Boat(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Метод для отрисовки корабля
    public void draw(Graphics2D g) {
        g.setPaint(Color.decode("#8B4513")); // Коричневый цвет для корабля
        int[] xBoatPoints = {x,x+50,x+75,x-25};
        int[] yBoatPoints = {y + 40,y + 40,y+20,y+20};
        g.fillPolygon(xBoatPoints, yBoatPoints, 4);
        g.setPaint(Color.decode("#FFFFFF")); // Белый цвет для паруса
        int[] xParusPoints = {x + 25,x + 25,x+ 60};
        int[] yParusPoints = {y + 20,y - 50,y+20};
        g.fillPolygon(xParusPoints, yParusPoints, 3);
        g.setPaint(Color.decode("#d4d4d4"));
        int[] xParus2Points = {x + 25,x + 25,x - 5};
        int[] yParus2Points = {y + 20,y - 40,y+20};
        g.fillPolygon(xParus2Points, yParus2Points, 3);
    }

    // Метод для обновления позиции корабля
    public void move(int dx) {
        x += dx;
        // Перезапускаем корабль, если он вышел за пределы экрана
        if (x > 800) { // Замените 800 на ширину вашего экрана
            x = -width; // Перемещаем корабль обратно влево
        }
    }
}
