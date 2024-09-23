package ru.vsu.cs.vereschagin.logic;

import java.io.*;

public class LinkedListUtils {

    // Переделать лист в массив
    public static int[] listToArr(LinkedList<Integer> linkedList) {
        int[] arr = new int[linkedList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = linkedList.get(i);
        }
        return arr;
    }

    // Переделать массив в лист
    public static LinkedList<Integer> arrToList(int[] arr) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : arr) {
            linkedList.add(i);
        }
        return linkedList;
    }


    public static LinkedList<Integer> listFromFile(String file) {
        String str = read(file);
        int[] arr = stringToArr(str);
        return arrToList(arr);
    }

    private static String read(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static int[] stringToArr(String str) {
        String[] arrStr = str.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i].trim());
        }
        return arr;
    }


    public static void write(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
