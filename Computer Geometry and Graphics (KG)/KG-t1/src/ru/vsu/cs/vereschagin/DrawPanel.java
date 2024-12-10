package ru.vsu.cs.vereschagin;

import ru.vsu.cs.vereschagin.elements.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;
    private final static Random rnd = new Random();
    private Background back;
    private Castle castle;
    private List<Tree> trees = new ArrayList<>();
    private List<Cloud> clouds = new ArrayList<>();
    private List<Flower> flowers = new ArrayList<>();
    private Boat boat;
    private Table table;


    public DrawPanel() {
        back = new Background(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, Color.decode("#87ceeb"), Color.decode("#57aed1"), Color.decode("#6e8e44"));
        castle = new Castle(320, (int)(BACKGROUND_HEIGHT / 1.65));
        boat = new Boat(0, (int)(BACKGROUND_HEIGHT / 1.65) + 20, 60, 30);
        table = new Table(600, 500, 150, 80, "Добрый замок");


        for (int i = -10; i < 20; i++) {
            int red = rnd.nextInt(75);
            int green = 70;
            int blue = rnd.nextInt(75);

            trees.add(new Tree(
                    new Color(red,green,blue),
                    80 + rnd.nextInt(60),
                    0 + (i * 50),
                    (int)(BACKGROUND_HEIGHT / 1.9)
            ));
        }

        for (int i = 0; i < 5; i++) {
            clouds.add(new Cloud(
                    rnd.nextInt(BACKGROUND_WIDTH),
                    70 + rnd.nextInt(100),
                    40 + rnd.nextInt(20),
                    Color.WHITE
            ));
        }

        for (int i = 0; i < 60; i++) {
            flowers.add(new Flower(
                    rnd.nextInt(BACKGROUND_WIDTH),
                    BACKGROUND_HEIGHT - rnd.nextInt(100),
                    Color.GREEN,
                    new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            ));
        }

        Timer timer = new Timer(30, e -> update());
        timer.start();
    }

    private void update() {
        for (Cloud cloud : clouds) {
            cloud.setX(cloud.getX() + 1);
            if (cloud.getX() > BACKGROUND_WIDTH) {
                cloud.setX(-cloud.getR());
                cloud.setY(70 + rnd.nextInt(100));
            }
        }
        boat.move(1);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        back.draw((Graphics2D) g);
        for (Cloud cloud : clouds) {
            cloud.drawCloud((Graphics2D) g);
        }
        for (Tree tree : trees) {
            tree.draw((Graphics2D) g);
        }
        for (Flower flower : flowers) {
            flower.drawFlower((Graphics2D) g);
        }
        castle.drawCastle((Graphics2D) g, 150);
        boat.draw((Graphics2D) g);
        table.draw((Graphics2D) g);
    }
}
