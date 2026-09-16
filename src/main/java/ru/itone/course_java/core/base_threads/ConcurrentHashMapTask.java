package ru.itone.course_java.core.base_threads;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTask {

    private static final ConcurrentHashMap<String, Integer> map =
            new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            map.put("First", 1);
            map.put("Second", 2);
        });

        Thread thread2 = new Thread(() -> map.put("Third", 3));

        Thread thread3 = new Thread(() -> System.out.println("Map: " + map));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        thread3.start();
    }
}
