package ru.itone.course_java.core.base_threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTask {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();

        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ReentrantLockTask::increment);
        Thread thread2 = new Thread(ReentrantLockTask::increment);
        Thread thread3 = new Thread(ReentrantLockTask::increment);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Counter: " + counter);
    }
}
