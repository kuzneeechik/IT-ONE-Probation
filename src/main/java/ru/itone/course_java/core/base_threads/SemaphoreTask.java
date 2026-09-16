package ru.itone.course_java.core.base_threads;

import java.util.concurrent.Semaphore;

public class SemaphoreTask {

    private static final Semaphore semaphore = new Semaphore(2);

    private static void work() {
        try {
            semaphore.acquire();

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
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SemaphoreTask::work, "Thread 1");
        Thread thread2 = new Thread(SemaphoreTask::work, "Thread 2");
        Thread thread3 = new Thread(SemaphoreTask::work, "Thread 3");
        Thread thread4 = new Thread(SemaphoreTask::work, "Thread 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
