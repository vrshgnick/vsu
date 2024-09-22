package ru.vsu.cs.course1;

import ru.vsu.cs.queue.CustomQueue;

public class Main {
    public static void main(String[] args){
        CustomQueue<Double> queueX = new CustomQueue<>();
        CustomQueue<Double> queueY = new CustomQueue<>();

        /*
        queueX.enqueue(1.0);
        queueX.enqueue(2.0);
        */
        queueY.enqueue(8.0);

        queueY.enqueue(4.0);
        queueY.enqueue(2.0);


        int steps = Task.customTaskDouble(queueX, queueY);
        System.out.println("Number of steps: " + steps);
        System.out.println(queueX);
    }
}
