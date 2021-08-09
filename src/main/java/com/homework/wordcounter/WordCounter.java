package com.homework.wordcounter;
import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(file)));

        Map<String, Integer> words = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(words.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        int top = 10;
        int index = entries.size() - 1;
        while (top > 0 && index > 0) {
            Map.Entry<String, Integer> entry = entries.get(index);
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
            top--;
            index--;
        }

    }
}
