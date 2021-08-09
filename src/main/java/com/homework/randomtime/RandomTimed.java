package com.homework.randomtime;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTimed {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (int index = 0; index < 1000000; index ++) {
            byte[] bytes = new byte[10];
            new Random().nextBytes(bytes);
            String randomString = new String(bytes, StandardCharsets.UTF_8);
            arrayList.add(randomString);
            linkedList.add(randomString);
        }

        System.out.println("Timing ArrayList...");
        long startTime = System.currentTimeMillis();
        for (int index = 0; index < 100000; index ++) {
            arrayList.get(ThreadLocalRandom.current().nextInt(0, 1000000));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");

        System.out.println("Timing LinkedList...");
        startTime = System.currentTimeMillis();
        for (int index = 0; index < 1000; index ++) {
            linkedList.get(ThreadLocalRandom.current().nextInt(0, 1000000));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + ((endTime - startTime)/1000) + "s");
    }
}
