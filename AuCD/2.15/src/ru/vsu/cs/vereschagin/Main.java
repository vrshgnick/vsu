package ru.vsu.cs.vereschagin;

import ru.vsu.cs.vereschagin.interface_.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}