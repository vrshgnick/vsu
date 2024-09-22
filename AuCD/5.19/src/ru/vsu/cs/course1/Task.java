package ru.vsu.cs.course1;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Task {

    public static List<Node> task(String text) {
        Queue queue = new Queue();

        for (int i = 0; i < text.length() - 1; i++) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                String pair = "" + first + second;
                queue.enqueue(pair.toLowerCase());
            }
        }

        List<Node> pairs = queue.getPairs();
        pairs.sort((a, b) -> b.count - a.count);

        return pairs;
    }

    public static PriorityQueue<Map.Entry<String, Integer>> taskS(String text) {

        Map<String, Integer> pairCountMap = new HashMap<>();

        // Заполнение карты пар и их количества
        for (int i = 0; i < text.length() - 1; i++) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                String pair = "" + first + second;
                pair = pair.toLowerCase();
                pairCountMap.put(pair, pairCountMap.getOrDefault(pair, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));

        pq.addAll(pairCountMap.entrySet());

        return pq;
    }

    public static String ListToString(PriorityQueue<Map.Entry<String, Integer>> queue){
        StringBuilder s = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            s.append(String.valueOf(entry.getKey())).append(" ").append(String.valueOf(entry.getValue())).append("\n");
        }
        return s.toString();
    }

    public static String ListToString(List<Node> pairs){
        StringBuilder s = new StringBuilder();
        for (Node node : pairs) {
            s.append(String.valueOf(node.pair)).append(" ").append(String.valueOf(node.count)).append("\n");
        }
        return s.toString();
    }


}
