package ru.vsu.cs.course1;


import ru.vsu.cs.queue.CustomQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Task {

    public static int customTaskDouble(CustomQueue<Double> queueX, CustomQueue<Double> queueY) {
        int steps = 0;

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            double x = queueX.dequeue();
            double y = queueY.dequeue();

            if (x < y) {
                queueX.enqueue(x + y);
            } else {
                queueY.enqueue(x - y);
            }

            steps++;
        }
        return steps;
    }

    public static int customTaskInteger(CustomQueue<Integer> queueX, CustomQueue<Integer> queueY) {
        int steps = 0;

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int x = queueX.dequeue();
            int y = queueY.dequeue();

            if (x < y) {
                queueX.enqueue(x + y);
            } else {
                queueY.enqueue(x - y);
            }

            steps++;
        }
        return steps;
    }


    public static int taskInteger(Queue<Integer> X, Queue<Integer> Y) {
        int steps = 0;

        while (!X.isEmpty() && !Y.isEmpty()) {
            int x = X.poll();
            int y = Y.poll();

            if (x < y) {X.offer(x + y);
            } else {Y.offer(x - y);}
            steps++;
        }
        return steps;
    }

    public static int taskDouble(Queue<Double> X, Queue<Double> Y) {
        int steps = 0;

        while (!X.isEmpty() && !Y.isEmpty()) {
            double x = X.poll();
            double y = Y.poll();

            if (x < y) {X.offer(x + y);
            } else {Y.offer(x - y);}
            steps++;
        }
        return steps;
    }


    public static CustomQueue<Double> stringToCustomQueueDouble(String str){
        CustomQueue<Double> queue = new CustomQueue<>();

        String[] numbers = str.split(" ");
        if(numbers.length == 0){return null;}

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {queue.enqueue(Double.parseDouble(number));
                }catch (Exception e){
                    System.out.println("Ошибка преобразования строку в число " + e);
                    return null;
                }
            }
        }

        return queue;
    }

    public static CustomQueue<Integer> stringToCustomQueueInteger(String str){
        CustomQueue<Integer> queue = new CustomQueue<>();

        String[] numbers = str.split(" ");
        if(numbers.length == 0){return null;}

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {queue.enqueue(Integer.parseInt(number));
                }catch (Exception e){
                    System.out.println("Ошибка преобразования строку в число " + e);
                    return null;
                }
            }
        }

        return queue;
    }



    /**
    * из строки получаем очередь
    * @param str - строка числа через пробел
    * @return - очередь
    */
    public static Queue<Integer> stringToQueueInteger(String str){
        Queue<Integer> queue = new LinkedList<>();

        String[] numbers = str.split(" ");
        if(numbers.length == 0){return null;}

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {queue.offer(Integer.parseInt(number));
                }catch (Exception e){
                    System.out.println("Ошибка преобразования строку в число " + e);
                    return null;
                }
            }
        }

        return queue;
    }

    /**
    * из строки получаем очередь
    * @param str - строка числа через пробел
    * @return - очередь
    */
    public static Queue<Double> stringToQueueDouble(String str){
        Queue<Double> queue = new LinkedList<>();

        String[] numbers = str.split(" ");
        if(numbers.length == 0){return null;}

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {queue.offer(Double.parseDouble(number));
                }catch (Exception e){
                    System.out.println("Ошибка преобразования строку в число " + e);
                    return null;
                }
            }
        }

        return queue;
    }

    /**
    * Из массива получаем строку
    * @param arr - int массив
    * @return String - строка, массив через пробел
    */
    public static String arrToString(int[] arr){
        StringBuilder s = new StringBuilder();

        for(int i : arr){s.append(i).append(" ");}

        if (s.length() > 0) {s.deleteCharAt(s.length() - 1);}

        return s.toString();
    }

    /**
    * Из массива получаем строку
    * @param arr - double массив
    * @return String - строка, массив через пробел
    */
    public static String arrToString(double[] arr){
        StringBuilder s = new StringBuilder();

        for(double i : arr){s.append(i).append(" ");}

        if (s.length() > 0) {s.deleteCharAt(s.length() - 1);}

        return s.toString();
    }
}
