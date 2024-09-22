package ru.vsu.cs.vereschagin;

import java.util.*;

public class WordSelection {
    public static List<String> selectWords(String text) {
        Set<String> uniqueWords = new HashSet<>();
        String wordDelimiter = "[^А-Яа-яA-Za-z0-9]+";
        String[] words = text.split(wordDelimiter);

        for (String word : words) {
            if (hasThreeOrMoreSameLetters(word)) {
                uniqueWords.add(word);
            }
        }

        return new ArrayList<>(uniqueWords);
    }

    private static boolean hasThreeOrMoreSameLetters(String word) {
        word = word.toLowerCase();
        Map<Character, Integer> letterCountMap = new HashMap<>();

        for (char letter : word.toCharArray()) {
            letterCountMap.put(letter, letterCountMap.getOrDefault(letter, 0) + 1);
        }

        for (int count : letterCountMap.values()) {
            if (count >= 3) {
                return true;
            }
        }

        return false;
    }

    public static List<String> runTests() {
        List<String> tests = Arrays.asList(
                "Hello, world! Apple, banana, and orange.",
                "letter, success, programming",
                "OneTwoThree, OneTwoThree, OneTwoThree",
                "1234567890, 1234567890, 1234567890",
                "#@!$%^&*()_-+=<>?/{}[]|",
                "",
                "программирование, ягода, перевернуть, перевернуть",
                "АББРЕВИАТУРА, ОДИНДВАТРИ, МАНУФАКТУРА",
                "111qq, qwerty1234567890qwertyy",
                "barabas]математика?15755)123qwe122-00"

        );

        List<String> results = new ArrayList<>();

        for (String test : tests) {
            List<String> selectedWords = selectWords(test);
            results.add("Текст: " + test + "\nВыбранные слова: " + selectedWords + "\n");
        }

        return results;
    }

    public static void main(String[] args) {
        List<String> results = runTests();

        for (String result : results) {
            System.out.println(result);
        }
    }
}