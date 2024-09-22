package ru.vsu.cs.course1;

import java.util.*;

public class AdvancedSolution {


    public static PriorityQueue<Map.Entry<String, Integer>> task(String text) {

        List<String> pairs = getLetterPairs(text);

        Map<String, Integer> frequencyMap = getFrequencyMap(pairs);

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        priorityQueue.addAll(frequencyMap.entrySet());

        return priorityQueue;
    }

    public static void draw(PriorityQueue<Map.Entry<String, Integer>> priorityQueue){
        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    /**
    * Создаем пары букв
    * @param text - строка, текст
    * @return - List<String> пары строк
    */
    private static List<String> getLetterPairs(String text) {
        List<String> pairs = new ArrayList<>();
        text = text.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < text.length() - 1; i++) { pairs.add(text.substring(i, i + 2)); }

        return pairs;
    }

    /**
    * Подсчёт пар
    * @param pairs - List<String> пары строк
    * @return Map<String, Integer>
    */
    private static Map<String, Integer> getFrequencyMap(List<String> pairs) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String pair : pairs) {
            frequencyMap.put(pair, frequencyMap.getOrDefault(pair, 0) + 1);
        }
        return frequencyMap;
    }
}
