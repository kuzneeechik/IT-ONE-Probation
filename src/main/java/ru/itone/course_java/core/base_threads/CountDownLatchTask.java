package ru.itone.course_java.core.base_threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTask {

    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch finishLatch = new CountDownLatch(3);

    private static void work() {
        try {
            startLatch.await();

            System.out.println(
                    Thread.currentThread().getName() + " started"
            );

            Thread.sleep(1000);

            System.out.println(
                    Thread.currentThread().getName() + " finished"
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            finishLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(CountDownLatchTask::work, "Thread 1");
        Thread thread2 = new Thread(CountDownLatchTask::work, "Thread 2");
        Thread thread3 = new Thread(CountDownLatchTask::work, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Starting all threads...");
        startLatch.countDown();

        finishLatch.await();

        System.out.println("All threads finished");
    }
}
