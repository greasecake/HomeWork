package com.homework.wordcounter;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader
                    .lines()
                    .flatMap(n -> Arrays.stream(n.split("(?U)\\W")))
                    .map(n -> n.toLowerCase(Locale.ROOT))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(System.out::println);
        }
    }
}
